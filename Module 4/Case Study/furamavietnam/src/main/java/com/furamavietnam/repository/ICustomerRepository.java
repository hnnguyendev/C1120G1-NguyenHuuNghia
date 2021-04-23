package com.furamavietnam.repository;

import com.furamavietnam.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findAll(Pageable pageable);

    @Query("select c from Customer c where " +
            "concat(c.customerCode,c.fullName,c.idNumber,c.phoneNumber,c.email,c.address,c.customerType.name) " +
            "like %?1%")
    Page<Customer> findByContaining(String txtSearch, Pageable pageable);
}
