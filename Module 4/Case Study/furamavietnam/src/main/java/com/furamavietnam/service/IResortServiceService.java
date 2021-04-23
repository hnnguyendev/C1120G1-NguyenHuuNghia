package com.furamavietnam.service;

import com.furamavietnam.entity.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IResortServiceService {

    List<ResortService> findAll();

    Page<ResortService> findAll(Pageable pageable);

    Page<ResortService> findByContaining(String txtSearch, Pageable pageable);

    ResortService findById(Long id);

    ResortService save(ResortService resortService);

    ResortService delete(Long id);
    
}
