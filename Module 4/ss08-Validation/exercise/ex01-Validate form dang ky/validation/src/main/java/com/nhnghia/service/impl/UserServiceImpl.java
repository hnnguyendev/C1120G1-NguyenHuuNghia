package com.nhnghia.service.impl;

import com.nhnghia.entity.User;
import com.nhnghia.repository.IUserRepository;
import com.nhnghia.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
