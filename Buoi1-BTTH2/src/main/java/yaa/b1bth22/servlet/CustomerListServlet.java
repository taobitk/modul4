
package yaa.b1bth22.servlet;

import yaa.b1bth22.model.Customer;
import yaa.b1bth22.service.CustomerService; // Giữ nguyên import này

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer-list")
public class CustomerListServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/customers/list.jsp");
        dispatcher.forward(request, response);
    }
}