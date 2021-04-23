package com.furamavietnam.service.impl;

import com.furamavietnam.entity.Customer;
import com.furamavietnam.repository.ICustomerRepository;
import com.furamavietnam.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findALl(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByContaining(String txtSearch, Pageable pageable) {
        return customerRepository.findByContaining(txtSearch, pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customerRepository.deleteById(id);

        return customer;
    }
}
