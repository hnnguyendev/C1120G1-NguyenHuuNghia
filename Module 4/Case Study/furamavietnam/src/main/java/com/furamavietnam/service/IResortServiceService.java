package com.furamavietnam.service;

import com.furamavietnam.entity.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IResortServiceService {

    Page<ResortService> findAll(Pageable pageable);

    ResortService findById(Long id);

    ResortService save(ResortService resortService);

    ResortService delete(Long id);
    
}
