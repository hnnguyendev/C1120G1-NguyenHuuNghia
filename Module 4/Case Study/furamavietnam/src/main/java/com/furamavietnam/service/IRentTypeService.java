package com.furamavietnam.service;

import com.furamavietnam.entity.RentType;

import java.util.List;

public interface IRentTypeService {

    List<RentType> findAll();

    RentType findById(Long id);
    
}
