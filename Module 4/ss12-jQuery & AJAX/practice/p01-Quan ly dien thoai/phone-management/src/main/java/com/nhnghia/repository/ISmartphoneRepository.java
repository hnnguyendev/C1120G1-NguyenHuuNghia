package com.nhnghia.repository;

import com.nhnghia.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
