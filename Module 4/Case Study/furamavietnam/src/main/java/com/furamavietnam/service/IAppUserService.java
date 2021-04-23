package com.furamavietnam.service;

import com.furamavietnam.entity.AppUser;

public interface IAppUserService {

    AppUser findByUsername(String username);

    void save(AppUser appUser);
    
}
