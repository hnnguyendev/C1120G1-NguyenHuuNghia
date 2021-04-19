package com.furamavietnam.service.impl;

import com.furamavietnam.entity.ServiceType;
import com.furamavietnam.repository.IServiceTypeRepository;
import com.furamavietnam.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {

    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(Long id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }
}
