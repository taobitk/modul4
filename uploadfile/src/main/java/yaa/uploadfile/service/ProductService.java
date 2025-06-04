package yaa.uploadfile.service; // Đã thay đổi package

import org.springframework.stereotype.Service; // Thêm @Service để Spring quản lý
import yaa.uploadfile.model.Product; // Đã thay đổi import

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service // Đánh dấu là một Spring bean để có thể inject vào controller
public class ProductService implements IProductService {
    private final List<Product> products;
    private static int nextId = 1; // Để tự động tăng ID cho sản phẩm mới

    public ProductService() {
        products = new ArrayList<>();
        // Thêm một vài sản phẩm mẫu nếu muốn
        // save(new Product(0, "Sample Product 1", "Description 1", "sample1.jpg"));
        // save(new Product(0, "Sample Product 2", "Description 2", "sample2.jpg"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products); // Trả về bản sao để tránh sửa đổi trực tiếp
    }

    @Override
    public void save(Product product) {
        if (product.getId() == 0) { // Nếu là sản phẩm mới (id chưa được set hoặc là 0)
            product.setId(nextId++);
            products.add(product);
        } else { // Cập nhật sản phẩm đã có
            update(product.getId(), product);
        }
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; // Hoặc ném exception nếu không tìm thấy
    }

    @Override
    public void update(int id, Product product) {
        OptionalInt indexOpt = IntStream.range(0, products.size())
                .filter(i -> products.get(i).getId() == id)
                .findFirst();

        if (indexOpt.isPresent()) {
            products.set(indexOpt.getAsInt(), product);
        } else {
            // Xử lý trường hợp không tìm thấy sản phẩm để cập nhật, ví dụ ném exception
            System.err.println("Product with id " + id + " not found for update.");
        }
    }

    @Override
    public void remove(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
