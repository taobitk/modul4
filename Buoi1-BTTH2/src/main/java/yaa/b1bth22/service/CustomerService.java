package yaa.b1bth22.service;

import yaa.b1bth22.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static final List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Hà Nội"));
        customers.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.vn", "Đà Nẵng"));
        customers.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn", "Hà Nội"));
        customers.add(new Customer(4, "Nguyen Thuy Duong", "duong.nguyen@codegym.vn", "Sài Gòn"));
        customers.add(new Customer(5, "CodeGym", "codegym@codegym.vn", "Việt Nam"));
    }

    public CustomerService() {
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}