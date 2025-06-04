package yaa.uploadfile.model; // Đã thay đổi package

public class Product {
    private int id; // Giữ nguyên kiểu int như hướng dẫn
    private String name;
    private String description;
    private String image; // Tên file ảnh đã lưu

    public Product() {
    }

    public Product(int id, String name, String description, String image) {
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

    public String getImage() {
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

    public void setImage(String image) {
        this.image = image;
    }
}
