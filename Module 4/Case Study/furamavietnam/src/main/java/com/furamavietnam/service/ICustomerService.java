package com.furamavietnam.service;

import com.furamavietnam.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Page<Customer> findALl(Pageable pageable);

    Page<Customer> findByContaining(String txtSearch, Pageable pageable);

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer delete(Long id);
    
}
