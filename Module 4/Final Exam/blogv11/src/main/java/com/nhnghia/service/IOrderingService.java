package com.nhnghia.service;

import com.nhnghia.entity.Ordering;

import java.util.List;

public interface IOrderingService {

    List<Ordering> findAll();

    List<Ordering> findByContaining(String txtSearch);

    Ordering findById(Long id);

    void save(Ordering ordering);

    void delete(Long id);

    List<Ordering> findByCustomerId(Long id);

}
