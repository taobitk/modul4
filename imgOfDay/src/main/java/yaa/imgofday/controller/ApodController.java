package yaa.imgofday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yaa.imgofday.model.Feedback;
import yaa.imgofday.service.IFeedbackService;

@Controller
@RequestMapping("/img") // <<< ĐÃ THAY ĐỔI TẠI ĐÂY
public class ApodController {

    @Autowired
    private IFeedbackService feedbackService;

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("feedbacks", feedbackService.getTodaysFeedback());
        model.addAttribute("feedback", new Feedback());
        return "index";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute Feedback feedback, RedirectAttributes redirectAttributes) {
        feedbackService.save(feedback);
        redirectAttributes.addFlashAttribute("message", "Cảm ơn bạn đã gửi đánh giá!");
        return "redirect:/img"; // <<< ĐÃ CẬP NHẬT ĐƯỜNG DẪN CHUYỂN HƯỚNG
    }

    @PostMapping("/like/{id}")
    public String likeComment(@PathVariable Long id) {
        feedbackService.like(id);
        return "redirect:/img"; // <<< ĐÃ CẬP NHẬT ĐƯỜNG DẪN CHUYỂN HƯỚNG
    }
}
