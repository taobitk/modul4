package yaa.buoi2bth5.service;

import yaa.buoi2bth5.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Service // Nếu bạn muốn Spring tự động tìm thấy qua component-scan
public class SimpleCustomerServiceImpl implements ICustomerService {
    private static final Map<Long, Customer> customers = new HashMap<>();
    private static long nextId = 1;

    static {
        customers.put(nextId, new Customer(nextId++, "Nguyen Van A", "a.nguyen@example.com", "Hanoi"));
        customers.put(nextId, new Customer(nextId++, "Le Thi B", "b.le@example.com", "Danang"));
        customers.put(nextId, new Customer(nextId++, "Tran Van C", "c.tran@example.com", "HCM"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null || customer.getId() == 0) { // Xử lý cả trường hợp id là 0 nếu form gửi về
            customer.setId(nextId++);
        }
        customers.put(customer.getId(), customer);
    }
}