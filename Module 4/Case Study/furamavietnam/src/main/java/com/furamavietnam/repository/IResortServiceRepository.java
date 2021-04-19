package com.furamavietnam.repository;

import com.furamavietnam.entity.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResortServiceRepository extends JpaRepository<ResortService, Long> {

    Page<ResortService> findAll(Pageable pageable);
}
