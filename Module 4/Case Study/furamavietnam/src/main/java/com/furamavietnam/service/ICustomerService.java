package com.furamavietnam.service;

import com.furamavietnam.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findALl(Pageable pageable);

    Customer findById(Long id);

    Customer save(Customer customer);

    Customer delete(Long id);
    
}
