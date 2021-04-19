package com.furamavietnam.service.impl;

import com.furamavietnam.entity.RentType;
import com.furamavietnam.repository.IRentTypeRepository;
import com.furamavietnam.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {

    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Long id) {
        return rentTypeRepository.findById(id).orElse(null);
    }
}
