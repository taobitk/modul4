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

    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm, Model model, RedirectAttributes redirect) {
        MultipartFile multipartFile = songForm.getFilePath();

        if (multipartFile == null || multipartFile.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn một file nhạc!");
            return "create";
        }

        String contentType = multipartFile.getContentType();
        if (contentType == null || !contentType.startsWith("audio/")) {
            model.addAttribute("message", "Định dạng file không hợp lệ! Vui lòng chọn một file âm thanh.");
            return "create";
        }
        songService.save(songForm);

        redirect.addFlashAttribute("message", "Thêm bài hát mới thành công!");
        return "redirect:/songs";
    }

    @GetMapping("/{id}/listen")
    public String showListenPage(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
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
