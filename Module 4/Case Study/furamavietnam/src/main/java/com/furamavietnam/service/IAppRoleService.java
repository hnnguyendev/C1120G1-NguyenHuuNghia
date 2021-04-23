package com.furamavietnam.service;

import com.furamavietnam.entity.AppRole;

public interface IAppRoleService {

    AppRole findByRoleName(String roleName);

}
