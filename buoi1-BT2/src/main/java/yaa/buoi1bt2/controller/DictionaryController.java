package yaa.buoi1bt2.controller; // SỬA LẠI Ở ĐÂY

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static Map<String, String> dictionaryData = new HashMap<>();

    static {
        dictionaryData.put("hello", "Xin chào");
        dictionaryData.put("world", "Thế giới");
        dictionaryData.put("book", "Quyển sách");
        dictionaryData.put("computer", "Máy tính");
        dictionaryData.put("love", "Yêu");
        dictionaryData.put("developer", "Lập trình viên");
        dictionaryData.put("spring", "Mùa xuân (hoặc tên framework)");
    }

    @GetMapping("/dictionary")
    public String showLookupForm(Model model, @RequestParam(name="searchWord", required = false) String searchWord) {
        if (searchWord != null) {
            model.addAttribute("searchWord", searchWord);
        }
        return "lookup-form";
    }

    @PostMapping("/dictionary")
    public String performLookup(@RequestParam("searchWord") String englishWord, Model model) {
        String trimmedWord = englishWord.trim().toLowerCase();
        String vietnameseMeaning = dictionaryData.get(trimmedWord);

        model.addAttribute("searchWord", englishWord); // Gửi lại từ đã nhập

        if (vietnameseMeaning != null) {
            model.addAttribute("vietnameseMeaning", vietnameseMeaning);
        } else {
            model.addAttribute("notFoundMessage", "Không tìm thấy từ '" + englishWord + "' trong từ điển.");
        }
        return "lookup-form";
    }
}