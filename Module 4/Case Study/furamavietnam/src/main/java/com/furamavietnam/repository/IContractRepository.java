package com.furamavietnam.repository;

import com.furamavietnam.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Long> {
}
