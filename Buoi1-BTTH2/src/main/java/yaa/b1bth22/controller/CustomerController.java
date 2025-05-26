package yaa.b1bth22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import yaa.b1bth22.model.Customer; // Import lớp Customer
import yaa.b1bth22.service.CustomerService; // Import CustomerService

import javax.servlet.http.HttpServletRequest; // Import HttpServletRequest
import java.util.List; // Import List

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerService();

    @GetMapping("/customers")
    public String showList(HttpServletRequest request) { // Thêm HttpServletRequest request làm tham số
        // 1. Gọi CustomerService để lấy danh sách tất cả khách hàng
        List<Customer> customersList = customerService.findAll();

        // 2. Đặt danh sách khách hàng vào request attribute để JSP có thể truy cập
        request.setAttribute("customers", customersList);

        // 3. Trả về tên view logic (ViewResolver sẽ xử lý thành file JSP)
        return "list";
    }
}