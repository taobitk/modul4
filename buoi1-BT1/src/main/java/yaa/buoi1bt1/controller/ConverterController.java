package yaa.buoi1bt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @GetMapping("/convert") // Xử lý request GET tới URL /convert
    public String showConverterForm() {
        return "converter-form";
    }

    @PostMapping("/convert")
    public String performConversion(@RequestParam(name = "usdAmount", required = false) Double usdAmount,
                                    @RequestParam(name = "exchangeRate", required = false) Double exchangeRate,
                                    Model model) {

        if (usdAmount != null && exchangeRate != null) {
            if (exchangeRate <= 0) {
                model.addAttribute("error", "Exchange rate must be positive.");
            } else {
                double vndAmount = usdAmount * exchangeRate;
                model.addAttribute("usdAmount", usdAmount);
                model.addAttribute("exchangeRate", exchangeRate);
                model.addAttribute("vndAmount", vndAmount);
            }
        } else {
           }
        return "converter-form";
    }
}