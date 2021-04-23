package com.furamavietnam.service.impl;

import com.furamavietnam.entity.Education;
import com.furamavietnam.repository.IEducationRepository;
import com.furamavietnam.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {

    @Autowired
    IEducationRepository educationRepository;

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}
