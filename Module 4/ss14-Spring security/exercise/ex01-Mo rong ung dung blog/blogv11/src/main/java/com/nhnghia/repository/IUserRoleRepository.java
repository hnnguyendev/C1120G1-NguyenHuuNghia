package com.nhnghia.repository;

import com.nhnghia.entity.AppUser;
import com.nhnghia.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
