package yaa.uploadfile2.service; // Đã thay đổi package

import yaa.uploadfile2.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}