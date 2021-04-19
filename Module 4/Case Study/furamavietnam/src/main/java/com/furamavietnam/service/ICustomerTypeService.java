package com.furamavietnam.service;

import com.furamavietnam.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();

    CustomerType findById(Long id);
    
}
