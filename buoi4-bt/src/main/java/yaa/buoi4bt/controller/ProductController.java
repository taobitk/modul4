package yaa.buoi4bt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import yaa.buoi4bt.model.Product;
import yaa.buoi4bt.service.IProductService;
import yaa.buoi4bt.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
 private final IProductService productService = new ProductService();

   @GetMapping("")
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
           return "list";
    }
  @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

   @PostMapping("/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
         productService.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Sản phẩm đã được tạo thành công!");
        return "redirect:/products";
    }

     @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "update";
    }

      @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("successMessage", "Sản phẩm đã được cập nhật thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteForm(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
         return "delete_confirm";
    }
  @PostMapping("/delete")
    public String deleteProduct(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("successMessage", "Sản phẩm đã được xóa thành công!");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "view";
    }
}
