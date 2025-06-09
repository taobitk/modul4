package yaa.musicapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yaa.musicapp.model.Song;
import yaa.musicapp.model.SongForm;
import yaa.musicapp.service.ISongService;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        return "create";
    }

    /**
     * -- PHẦN SỬA ĐỔI: CẬP NHẬT LOGIC LƯU VÀ VALIDATE FILE --
     * Thay vì dùng RedirectAttributes, chúng ta sẽ dùng Model để trả về lỗi.
     * Cách này giúp giữ lại dữ liệu người dùng đã nhập trên form khi có lỗi xảy ra.
     */
    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm, Model model, RedirectAttributes redirect) {
        MultipartFile multipartFile = songForm.getFilePath();

        // 1. Kiểm tra xem người dùng có chọn file để tải lên không
        if (multipartFile == null || multipartFile.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn một file nhạc!");
            // Trả về view 'create' trực tiếp, giữ lại songForm đã nhập
            return "create";
        }

        // 2. Kiểm tra định dạng file (Server-side validation)
        String contentType = multipartFile.getContentType();
        // contentType của file âm thanh thường bắt đầu bằng "audio/" (ví dụ: audio/mpeg, audio/wav)
        if (contentType == null || !contentType.startsWith("audio/")) {
            model.addAttribute("message", "Định dạng file không hợp lệ! Vui lòng chọn một file âm thanh.");
            // Trả về view 'create' trực tiếp, giữ lại songForm đã nhập
            return "create";
        }
        // -- KẾT THÚC PHẦN SỬA ĐỔI --

        // Nếu tất cả kiểm tra đều hợp lệ, tiến hành lưu file
        songService.save(songForm);

        // Sử dụng RedirectAttributes để gửi thông báo thành công sang trang danh sách
        redirect.addFlashAttribute("message", "Thêm bài hát mới thành công!");
        return "redirect:/songs";
    }

    @GetMapping("/{id}/listen")
    public String showListenPage(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            // Nếu không tìm thấy bài hát, quay về trang danh sách
            return "redirect:/songs";
        }
        model.addAttribute("song", song);
        return "listen";
    }

    @GetMapping("/{id}/delete")
    public String showDeletePage(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteSong(@RequestParam Long id, RedirectAttributes redirect) {
        songService.remove(id);
        redirect.addFlashAttribute("message", "Đã xóa bài hát!");
        return "redirect:/songs";
    }
}
