package com.nhnghia.service;

import com.nhnghia.entity.Smartphone;

import java.util.List;

public interface ISmartphoneService {

    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartphone);

    Smartphone delete(Long id);
}
