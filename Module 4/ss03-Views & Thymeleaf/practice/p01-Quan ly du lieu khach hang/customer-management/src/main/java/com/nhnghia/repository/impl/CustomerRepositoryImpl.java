package com.nhnghia.repository.impl;

import com.nhnghia.model.Customer;
import com.nhnghia.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    private static  Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "John", "john@gmail.com", "England"));
        customerMap.put(2, new Customer(2, "David", "david@gmail.com", "Spain"));
        customerMap.put(3, new Customer(3, "Harry", "harry@gmail.com", "United State"));
        customerMap.put(4, new Customer(4, "Philips", "philips@gmail.com", "Poland"));
        customerMap.put(5, new Customer(5, "Kelvin", "kelvin@gmail.com", "Belgium"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
