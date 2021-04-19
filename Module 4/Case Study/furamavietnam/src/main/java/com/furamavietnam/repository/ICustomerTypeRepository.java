package com.furamavietnam.repository;

import com.furamavietnam.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
