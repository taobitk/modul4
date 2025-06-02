package yaa.buoi4bt.service;

import org.springframework.stereotype.Service;
import yaa.buoi4bt.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 13", 20000000, "Điện thoại iPhone 13 128GB", "Apple"));
        products.put(2, new Product(2, "Samsung Galaxy S22", 18000000, "Điện thoại Samsung Galaxy S22 256GB", "Samsung"));
        products.put(3, new Product(3, "Xiaomi Redmi Note 11", 5000000, "Điện thoại Xiaomi Redmi Note 11 64GB", "Xiaomi"));
        products.put(4, new Product(4, "Oppo Reno7", 8500000, "Điện thoại Oppo Reno7 Z 5G", "Oppo"));
        products.put(5, new Product(5, "Macbook Pro M2", 35000000, "Máy tính xách tay Macbook Pro M2 13 inch", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        if (product.getId() == 0) {
            int newId = getNextId();
            product.setId(newId);
        }
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        if (products.containsKey(id)) {
            product.setId(id);
            products.put(id, product);
        }
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return findAll();
        }
        String lowerCaseName = name.toLowerCase();
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(lowerCaseName))
                .collect(Collectors.toList());
    }

    private int getNextId() {
        int maxId = 0;
        for (int id : products.keySet()) {
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }
}
