package com.furamavietnam.repository;

import com.furamavietnam.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAll(Pageable pageable);

    @Query("select e from Employee e where " +
            "concat(e.fullName,e.idNumber,e.salary,e.phoneNumber,e.email,e.address,e.position.name," +
            "e.education.name,e.department.name, e.appUser.username) " +
            "like %?1%")
    Page<Employee> findByContaining(String txtSearch, Pageable pageable);

}
