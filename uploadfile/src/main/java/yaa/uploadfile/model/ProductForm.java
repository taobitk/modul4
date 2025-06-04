package yaa.uploadfile.model; // Đã thay đổi package

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private int id; // Giữ nguyên kiểu int
    private String name;
    private String description;
    private MultipartFile image; // Để nhận file upload từ form

    public ProductForm() {
    }

    public ProductForm(int id, String name, String description, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MultipartFile getImage() {
        return image;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
