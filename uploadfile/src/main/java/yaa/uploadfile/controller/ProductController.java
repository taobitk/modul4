package yaa.uploadfile.controller; // Đã thay đổi package

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import yaa.uploadfile.model.Product;
import yaa.uploadfile.model.ProductForm;
import yaa.uploadfile.service.IProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product") // Base mapping cho tất cả các request trong controller này
public class ProductController {

    @Value("${file-upload}") // Inject giá trị từ upload_file.properties
    private String fileUploadPath;

    private final IProductService productService;

    @Autowired // Constructor injection cho ProductService
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // Hiển thị danh sách sản phẩm
    @GetMapping("") // Map với /product
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index"; // Trả về view /WEB-INF/views/index.html
    }

    // Hiển thị form tạo sản phẩm mới
    @GetMapping("/create") // Map với /product/create
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create"); // View /WEB-INF/views/create.html
        modelAndView.addObject("productForm", new ProductForm()); // Gửi một ProductForm rỗng cho form
        return modelAndView;
    }

    // Xử lý submit form tạo/lưu sản phẩm
    @PostMapping("/save") // Map với POST request tới /product/save
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();

        // Tạo thư mục upload nếu chưa tồn tại
        File uploadDir = new File(fileUploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            // Copy file vào thư mục upload
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUploadPath + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
            // Xử lý lỗi upload ở đây, ví dụ trả về trang lỗi hoặc thông báo
            ModelAndView errorModelAndView = new ModelAndView("create"); // Hoặc một view lỗi riêng
            errorModelAndView.addObject("productForm", productForm);
            errorModelAndView.addObject("errorMessage", "File upload failed: " + ex.getMessage());
            return errorModelAndView;
        }

        // Tạo đối tượng Product từ ProductForm
        // Giả sử id = 0 cho sản phẩm mới, service sẽ tự gán id
        Product product = new Product(
                productForm.getId(), // Nếu id=0, service sẽ tự tạo id mới khi save
                productForm.getName(),
                productForm.getDescription(),
                fileName // Lưu tên file ảnh
        );
        productService.save(product);

        ModelAndView modelAndView = new ModelAndView("create"); // Quay lại trang create
        modelAndView.addObject("productForm", new ProductForm()); // Gửi form mới rỗng
        modelAndView.addObject("message", "Created/Updated product successfully!");
        return modelAndView;
    }
}
