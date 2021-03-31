package com.nhnghia.service.impl;

import com.nhnghia.repository.ISettingRepository;
import com.nhnghia.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingServiceImpl implements ISettingService {

    @Autowired
    ISettingRepository settingRepository;

    @Override
    public List<String> findAllLanguage() {
        return settingRepository.findAllLanguage();
    }

    @Override
    public List<Integer> findAllPageSize() {
        return settingRepository.findAllPageSize();
    }
}
