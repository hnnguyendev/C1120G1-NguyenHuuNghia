package com.furamavietnam.repository;

import com.furamavietnam.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Long> {
}
