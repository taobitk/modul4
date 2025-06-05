package yaa.musicupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yaa.musicupload.model.Song;
import yaa.musicupload.model.SongForm;
import yaa.musicupload.service.ISongService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/songs") // Tất cả các request đến /songs sẽ được xử lý bởi controller này
public class SongController {

    private final ISongService songService;

    @Value("${musicUploadPath}") // Inject đường dẫn lưu file từ upload_music.properties
    private String musicUploadPath;

    // Danh sách các đuôi file hợp lệ
    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList(".mp3", ".wav", ".ogg", ".m4p");

    @Autowired // Tự động inject một instance của SongService
    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("/list")
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView("list-songs"); // Trả về view list-songs.html
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("/upload")
    public ModelAndView showUploadForm() {
        ModelAndView modelAndView = new ModelAndView("create-song"); // Trả về view create-song.html
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("message", ""); // Thêm message trống ban đầu
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView uploadSong(@ModelAttribute SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getSongFile();
        String originalFileName = multipartFile.getOriginalFilename();
        ModelAndView modelAndView = new ModelAndView("create-song"); // View để hiển thị lại nếu có lỗi

        // 1. Kiểm tra file có được chọn không
        if (multipartFile.isEmpty()) {
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("message", "Vui lòng chọn một file để upload.");
            return modelAndView;
        }

        // 2. Kiểm tra đuôi file
        boolean isValidExtension = false;
        if (originalFileName != null && !originalFileName.isEmpty()) {
            String fileExtension = "";
            int lastDotIndex = originalFileName.lastIndexOf('.');
            if (lastDotIndex > 0 && lastDotIndex < originalFileName.length() - 1) {
                fileExtension = originalFileName.substring(lastDotIndex).toLowerCase();
            }
            if (ALLOWED_EXTENSIONS.contains(fileExtension)) {
                isValidExtension = true;
            }
        }

        if (!isValidExtension) {
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("message", "File không hợp lệ. Chỉ chấp nhận các file .mp3, .wav, .ogg, .m4p.");
            return modelAndView;
        }

        // 3. Lưu file
        try {
            // Tạo thư mục nếu chưa tồn tại
            File uploadDir = new File(musicUploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Tạo tên file duy nhất hoặc giữ nguyên tên gốc (cẩn thận trùng lặp)
            // Ở đây ta giữ nguyên tên gốc để đơn giản
            String fileNameToSave = originalFileName;
            FileCopyUtils.copy(multipartFile.getBytes(), new File(musicUploadPath + File.separator + fileNameToSave));

            // 4. Lưu thông tin bài hát vào service
            Song song = new Song();
            // ID sẽ được tự động tạo trong service
            song.setName(songForm.getName());
            song.setArtist(songForm.getArtist());
            song.setGenre(songForm.getGenre());
            song.setFilePath(fileNameToSave); // Lưu tên file (hoặc đường dẫn tương đối)

            songService.save(song);

            // 5. Redirect đến trang danh sách với thông báo thành công
            redirectAttributes.addFlashAttribute("message", "Upload bài hát \"" + song.getName() + "\" thành công!");
            return new ModelAndView("redirect:/songs/list");

        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.addObject("songForm", songForm);
            modelAndView.addObject("message", "Có lỗi xảy ra khi upload file: " + e.getMessage());
            return modelAndView;
        }
    }
}