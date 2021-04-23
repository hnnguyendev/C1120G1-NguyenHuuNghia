package com.furamavietnam.service.impl;

import com.furamavietnam.entity.AppRole;
import com.furamavietnam.repository.IAppRoleRepository;
import com.furamavietnam.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleServiceImpl implements IAppRoleService {

    @Autowired
    IAppRoleRepository appRoleRepository;

    @Override
    public AppRole findByRoleName(String roleName) {
        return appRoleRepository.findAppRoleByRoleName(roleName);
    }
}
