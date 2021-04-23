package com.furamavietnam.service.impl;

import com.furamavietnam.entity.ExtraService;
import com.furamavietnam.repository.IExtraServiceRepository;
import com.furamavietnam.service.IExtraServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraServiceServiceImpl implements IExtraServiceService {

    @Autowired
    IExtraServiceRepository extraServiceRepository;

    @Override
    public List<ExtraService> findAll() {
        return extraServiceRepository.findAll();
    }
}
