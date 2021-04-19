package com.furamavietnam.service;

import com.furamavietnam.entity.ServiceType;

import java.util.List;

public interface IServiceTypeService {

    List<ServiceType> findAll();

    ServiceType findById(Long id);

}
