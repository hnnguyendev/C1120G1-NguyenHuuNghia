package com.furamavietnam.service.impl;

import com.furamavietnam.entity.UserRole;
import com.furamavietnam.repository.IUserRoleRepository;
import com.furamavietnam.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    IUserRoleRepository userRoleRepository;

    @Override
    public void save(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
