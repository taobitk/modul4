package yaa.bai6bth.service;

import yaa.bai6bth.model.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void remove(int id);
}
