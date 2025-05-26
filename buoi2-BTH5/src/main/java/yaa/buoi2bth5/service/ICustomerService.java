package yaa.buoi2bth5.service; // ĐÃ THAY ĐỔI

import yaa.buoi2bth5.model.Customer; // ĐÃ THAY ĐỔI
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
}