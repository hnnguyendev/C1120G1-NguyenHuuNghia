package com.nhnghia.repository.impl;

import com.nhnghia.repository.ISettingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettingRepositoryImpl implements ISettingRepository {

    private static Map<Integer, String> languageMap;
    private static Map<Integer, Integer> pageSizeMap;

    static {
        languageMap = new HashMap<>();
        languageMap.put(1, "English");
        languageMap.put(2, "Vietnamese");
        languageMap.put(3, "Japanese");
        languageMap.put(4, "Chinese");
        pageSizeMap = new HashMap<>();
        pageSizeMap.put(1, 5);
        pageSizeMap.put(2, 10);
        pageSizeMap.put(3, 15);
        pageSizeMap.put(4, 20);
        pageSizeMap.put(5, 25);
        pageSizeMap.put(6, 50);
        pageSizeMap.put(7, 100);
    }

    @Override
    public List<String> findAllLanguage() {
        return new ArrayList<>(languageMap.values());
    }

    @Override
    public List<Integer> findAllPageSize() {
        return new ArrayList<>(pageSizeMap.values());
    }
}
