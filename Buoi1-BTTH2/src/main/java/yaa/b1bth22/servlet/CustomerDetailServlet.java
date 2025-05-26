package yaa.b1bth22.servlet;

import yaa.b1bth22.model.Customer;
import yaa.b1bth22.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer-info")
public class CustomerDetailServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Customer customer = customerService.findById(id);

            if (customer != null) {
                request.setAttribute("customer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customers/info.jsp");
                dispatcher.forward(request, response);
            } else {
                response.getWriter().println("Customer not found!");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid customer ID format!");
        }
    }
}