package com.furamavietnam.repository;

import com.furamavietnam.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole, Long> {

    AppRole findAppRoleByRoleName(String roleName);
}
