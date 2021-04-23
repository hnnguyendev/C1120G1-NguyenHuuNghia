package com.furamavietnam.repository;

import com.furamavietnam.entity.ExtraService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExtraServiceRepository extends JpaRepository<ExtraService, Long> {
    
}
