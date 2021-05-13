package com.nhnghia.service.impl;

import com.nhnghia.entity.Customer;
import com.nhnghia.repository.ICustomerRepository;
import com.nhnghia.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
