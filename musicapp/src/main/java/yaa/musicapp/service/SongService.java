package yaa.musicapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import yaa.musicapp.model.Song;
import yaa.musicapp.model.SongForm;
import yaa.musicapp.repository.ISongRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class SongService implements ISongService {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(SongForm songForm) {
        MultipartFile multipartFile = songForm.getFilePath();

        // Lấy tên file gốc từ người dùng
        String originalFileName = multipartFile.getOriginalFilename();

        // **-- PHẦN SỬA ĐỔI: TẠO TÊN FILE DUY NHẤT --**
        // Tạo một chuỗi ngẫu nhiên độc nhất để ghép vào trước tên file
        // Điều này đảm bảo mỗi file được tải lên sẽ có một tên riêng biệt, tránh bị ghi đè
        String randomPrefix = UUID.randomUUID().toString();
        // Thay thế khoảng trắng trong tên file gốc bằng dấu gạch dưới cho an toàn
        String safeOriginalFileName = originalFileName.replaceAll("\\s+", "_");
        // Kết hợp chuỗi ngẫu nhiên và tên file gốc để tạo tên file duy nhất
        String uniqueFileName = randomPrefix + "_" + safeOriginalFileName;

        try {
            // Tạo thư mục lưu trữ file nếu nó chưa tồn tại
            File uploadDir = new File(fileUpload);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Sử dụng Path để tạo đường dẫn tới file một cách an toàn, độc lập với HĐH
            Path filePath = Paths.get(fileUpload, uniqueFileName);

            // Copy dữ liệu từ file người dùng tải lên vào file mới trên server với tên duy nhất
            FileCopyUtils.copy(multipartFile.getBytes(), filePath.toFile());
        } catch (IOException e) {
            e.printStackTrace();
            // Trong ứng dụng thực tế, nên xử lý exception một cách tường minh hơn
            // Ví dụ: throw new RuntimeException("Không thể lưu file nhạc.", e);
        }

        // Tạo đối tượng Song để lưu vào CSDL, sử dụng tên file DUY NHẤT đã tạo
        Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getGenre(), uniqueFileName);
        // **-- KẾT THÚC PHẦN SỬA ĐỔI --**

        if (songForm.getId() != null) {
            song.setId(songForm.getId());
        }
        songRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        // Tìm bài hát trong CSDL
        Song song = songRepository.findById(id);
        if(song != null) {
            // Xóa file vật lý trên server
            File file = new File(fileUpload + song.getFilePath());
            if (file.exists()) {
                file.delete();
            }
            // Xóa bản ghi trong CSDL
            songRepository.remove(id);
        }
    }
}
