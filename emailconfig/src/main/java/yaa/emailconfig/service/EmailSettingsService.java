package yaa.emailconfig.service;

import org.springframework.stereotype.Service;
import yaa.emailconfig.model.EmailSettings;

@Service
public class EmailSettingsService implements IEmailSettingsService {
    private EmailSettings currentSettings;

    public EmailSettingsService() {
        // Khởi tạo với các giá trị mặc định từ model
        this.currentSettings = new EmailSettings();
    }

    @Override
    public EmailSettings getSettings() {
        // Trả về một bản sao để tránh thay đổi trực tiếp từ bên ngoài (nếu cần)
        // Hoặc trả về trực tiếp nếu bạn muốn cập nhật đối tượng này
        // Hiện tại, chúng ta sẽ trả về đối tượng gốc để controller có thể cập nhật
        // và form binding hoạt động với cùng một object instance.
        // Tuy nhiên, để an toàn hơn khi có nhiều request, nên xem xét việc clone.
        // For simplicity now, return the direct reference:
        return this.currentSettings;
    }

    @Override
    public void saveSettings(EmailSettings settings) {
        // Đơn giản là gán đối tượng settings mới nhận được từ controller
        // (đã được Spring cập nhật qua form binding)
        this.currentSettings.setLanguage(settings.getLanguage());
        this.currentSettings.setPageSize(settings.getPageSize());
        this.currentSettings.setEnableSpamsFilter(settings.isEnableSpamsFilter());
        this.currentSettings.setSignature(settings.getSignature());

        // (Tùy chọn) In ra để kiểm tra
        System.out.println("Settings saved: ");
        System.out.println(" - Language: " + this.currentSettings.getLanguage());
        System.out.println(" - Page Size: " + this.currentSettings.getPageSize());
        System.out.println(" - Spam Filter: " + this.currentSettings.isEnableSpamsFilter());
        System.out.println(" - Signature: " + this.currentSettings.getSignature());
    }
}