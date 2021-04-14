package com.nhnghia.service.impl;

import com.nhnghia.entity.Smartphone;
import com.nhnghia.repository.ISmartphoneRepository;
import com.nhnghia.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneServiceImpl implements ISmartphoneService {

    @Autowired
    ISmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone delete(Long id) {
        Smartphone smartphone = smartphoneRepository.findById(id).orElse(null);
        smartphoneRepository.deleteById(id);
        return smartphone;
    }
}
