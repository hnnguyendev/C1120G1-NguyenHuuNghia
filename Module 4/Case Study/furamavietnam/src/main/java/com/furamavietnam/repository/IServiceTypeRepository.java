package com.furamavietnam.repository;

import com.furamavietnam.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
