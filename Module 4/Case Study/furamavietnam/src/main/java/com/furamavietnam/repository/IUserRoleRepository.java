package com.furamavietnam.repository;

import com.furamavietnam.entity.AppUser;
import com.furamavietnam.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
