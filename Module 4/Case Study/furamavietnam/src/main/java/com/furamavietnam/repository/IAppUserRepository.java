package com.furamavietnam.repository;

import com.furamavietnam.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
