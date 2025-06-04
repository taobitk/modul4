package yaa.uploadfile.service; // Đã thay đổi package

import yaa.uploadfile.model.Product; // Đã thay đổi import
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id); // Giữ nguyên kiểu int
    void update(int id, Product product); // Giữ nguyên kiểu int
    void remove(int id); // Giữ nguyên kiểu int
}
