package yaa.emailconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yaa.emailconfig.model.EmailSettings;
import yaa.emailconfig.service.IEmailSettingsService;

@Controller
@RequestMapping("/settings") // Tất cả các request đến /settings sẽ được controller này xử lý
public class EmailSettingsController {

    private final IEmailSettingsService emailSettingsService;

    @Autowired
    public EmailSettingsController(IEmailSettingsService emailSettingsService) {
        this.emailSettingsService = emailSettingsService;
    }

    @GetMapping
    public String showSettingsForm(Model model) {
        // Lấy đối tượng settings hiện tại từ service
        EmailSettings currentSettings = emailSettingsService.getSettings();

        // Thêm đối tượng settings vào model để form có thể binding
        // Cũng thêm các danh sách lựa chọn vào model
        model.addAttribute("emailSettings", currentSettings);
        // Không cần add languagesSupported và pageSizesSupported nữa
        // vì chúng là phương thức của đối tượng emailSettings (`currentSettings.getLanguagesSupported()`)
        // và có thể truy cập trực tiếp từ Thymeleaf thông qua đối tượng "emailSettings"

        // Nếu có thông báo từ lần redirect trước (sau khi save), nó sẽ tự động được thêm vào model
        // nhờ cơ chế Flash Attributes của Spring.
        // Nếu bạn muốn truyền một message cụ thể ở đây, có thể làm:
        // model.addAttribute("message", "Đây là trang cấu hình.");

        return "settings-form"; // Trả về view settings-form.html
    }

    @PostMapping("/save")
    public String saveSettings(@ModelAttribute("emailSettings") EmailSettings settings,
                               RedirectAttributes redirectAttributes) {
        // Đối tượng 'settings' ở đây đã được Spring tự động cập nhật
        // với các giá trị từ form người dùng nhập vào.

        emailSettingsService.saveSettings(settings);

        // Thêm một "flash attribute" để hiển thị thông báo sau khi redirect.
        // Flash attributes chỉ tồn tại cho request tiếp theo (sau redirect).
        redirectAttributes.addFlashAttribute("message", "Cấu hình đã được lưu thành công!");

        // Redirect về lại trang form (GET /settings)
        return "redirect:/settings";
    }
}