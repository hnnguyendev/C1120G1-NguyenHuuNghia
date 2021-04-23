package com.furamavietnam.service.impl;

import com.furamavietnam.entity.AppUser;
import com.furamavietnam.repository.IAppUserRepository;
import com.furamavietnam.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    IAppUserRepository appUserRepository;

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }
}
