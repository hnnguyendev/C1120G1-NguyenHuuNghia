package repositories.impl;

import models.Customer;
import repositories.ICustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements ICustomerRepository {

    private static Map<Integer, Customer> customerList;

    static {
        customerList = new HashMap<>();
        customerList.put(1, new Customer(1, "Juan Mata", "juanmata@gmail.com", "Spain"));
        customerList.put(2, new Customer(2, "David Beckham", "davidbeckham@gmail.com", "England"));
        customerList.put(3, new Customer(3, "Leo Messi", "leomessi@gmail.com", "Argentina"));
        customerList.put(4, new Customer(4, "Kenvin de Bruyne", "kenvindebruyne@gmail.com", "Belgium"));
        customerList.put(5, new Customer(5, "David Degea", "daviddegea@gmail.com", "Spain"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
