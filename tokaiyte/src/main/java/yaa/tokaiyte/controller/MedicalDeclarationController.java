package yaa.tokaiyte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import yaa.tokaiyte.model.MedicalDeclaration;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/medical")
public class MedicalDeclarationController {

    // Danh sách các mục dùng chung cho form (ví dụ: năm sinh, giới tính, quốc tịch)
    // Bạn có thể load chúng từ database hoặc file properties nếu cần
    @ModelAttribute("years")
    public List<Integer> getYears() {
        // Tạo danh sách năm sinh, ví dụ từ 1900 đến năm hiện tại
        java.time.YearMonth currentYearMonth = java.time.YearMonth.now();
        int currentYear = currentYearMonth.getYear();
        List<Integer> years = new java.util.ArrayList<>();
        for (int i = currentYear; i >= 1900; i--) {
            years.add(i);
        }
        return years;
    }

    @ModelAttribute("genders")
    public List<String> getGenders() {
        return Arrays.asList("Nam", "Nữ", "Khác");
    }

    @ModelAttribute("nationalities")
    public List<String> getNationalities() {
        // Đây chỉ là ví dụ, bạn nên có danh sách đầy đủ hơn
        return Arrays.asList("Việt Nam", "Mỹ", "Nhật Bản", "Hàn Quốc", "Trung Quốc", "Anh", "Pháp", "Đức", "Khác");
    }

    @ModelAttribute("vehicles")
    public List<String> getVehicles() {
        return Arrays.asList("Tàu bay", "Tàu thuyền", "Ô tô", "Khác");
    }


    // Hiển thị form khai báo
    @GetMapping("/declare")
    public String showDeclarationForm(Model model) {
        // Tạo một đối tượng MedicalDeclaration rỗng để binding với form
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "declaration-form"; // Trả về tên view của form
    }

    // Xử lý submit form khai báo
    @PostMapping("/declare")
    public String submitDeclaration(@Valid @ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration,
                                    BindingResult bindingResult,
                                    Model model) {

        // Kiểm tra lỗi validation
        if (bindingResult.hasErrors()) {
            // Nếu có lỗi, quay lại form và hiển thị các lỗi
            // Các @ModelAttribute chung (years, genders,...) vẫn sẽ được thêm vào model
            return "declaration-form";
        }

        // Nếu không có lỗi, xử lý dữ liệu (ví dụ: lưu vào database)
        // Hiện tại, chúng ta chỉ hiển thị lại thông tin đã khai báo
        model.addAttribute("submittedDeclaration", medicalDeclaration);
        return "declaration-info"; // Trả về tên view hiển thị thông tin
    }

    // (Tùy chọn) Hiển thị trang thông tin đã khai báo (nếu bạn muốn có trang riêng để xem/cập nhật)
    // @GetMapping("/info")
    // public String showInfoPage(@ModelAttribute("submittedDeclaration") MedicalDeclaration medicalDeclaration, Model model){
    //     // Giả sử medicalDeclaration được truyền từ session hoặc lấy từ DB
    //     // model.addAttribute("medicalDeclaration", medicalDeclaration); // Nếu cần lấy lại
    //     return "declaration-info";
    // }
}
