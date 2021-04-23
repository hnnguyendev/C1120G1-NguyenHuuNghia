package com.furamavietnam.repository;

import com.furamavietnam.entity.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IResortServiceRepository extends JpaRepository<ResortService, Long> {

    Page<ResortService> findAll(Pageable pageable);

    @Query("select s from ResortService s where " +
            "concat(s.serviceCode,s.name,s.area,s.cost,s.maxPeople,s.roomStandard,s.description," +
            "s.poolArea,s.numberOfFloor,s.rentType.name,s.serviceType.name) " +
            "like %?1%")
    Page<ResortService> findByContaining(String txtSearch, Pageable pageable);
}
