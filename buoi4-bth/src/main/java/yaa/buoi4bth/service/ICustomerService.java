package yaa.buoi4bth.service;
import yaa.buoi4bth.model.Customer;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}