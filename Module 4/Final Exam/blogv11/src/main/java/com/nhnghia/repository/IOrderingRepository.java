package com.nhnghia.repository;

import com.nhnghia.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderingRepository extends JpaRepository<Ordering, Long> {

    @Query("select o from Ordering o where concat(o.serviceCategory,o.customer.name) like %?1%")
    List<Ordering> findByContaining(String txtSearch);
}
