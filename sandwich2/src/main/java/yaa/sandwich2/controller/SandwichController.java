package yaa.sandwich2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String showSandwichForm() {
        return "sandwich-form";
    }

    @PostMapping("/saveCondiments") // URL khi submit form
    public String saveCondiments(@RequestParam(name = "condiment", required = false) String[] condiments, Model model) {
        if (condiments == null || condiments.length == 0) {
            model.addAttribute("message", "No condiments selected!");
        } else {
            model.addAttribute("selectedCondiments", condiments);
        }
        return "selected-condiments";
    }
}