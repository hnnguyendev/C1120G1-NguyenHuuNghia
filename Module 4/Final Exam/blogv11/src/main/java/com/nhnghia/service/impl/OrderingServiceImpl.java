package com.nhnghia.service.impl;

import com.nhnghia.entity.Ordering;
import com.nhnghia.repository.IOrderingRepository;
import com.nhnghia.service.IOrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderingServiceImpl implements IOrderingService {

    @Autowired
    IOrderingRepository orderingRepository;

    @Override
    public List<Ordering> findAll() {
        return orderingRepository.findAll();
    }

    @Override
    public List<Ordering> findByContaining(String txtSearch) {
        return orderingRepository.findByContaining(txtSearch);
    }

    @Override
    public Ordering findById(Long id) {
        return orderingRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Ordering ordering) {
        orderingRepository.save(ordering);
    }

    @Override
    public void delete(Long id) {
        orderingRepository.deleteById(id);
    }

    @Override
    public List<Ordering> findByCustomerId(Long id) {
        return null;
    }
}
