package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {

    void save(Customer customer);

    List<Customer> findAll();

    Customer findById(Long id);

    void update(Long id, Customer customer);

    void remove(Long id);

    List<Customer> search(String txtSearch);

}
