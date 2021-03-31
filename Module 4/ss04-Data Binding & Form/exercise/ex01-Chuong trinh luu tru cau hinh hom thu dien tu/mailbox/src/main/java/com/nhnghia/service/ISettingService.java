package com.nhnghia.service;

import java.util.List;

public interface ISettingService {

    List<String> findAllLanguage();

    List<Integer> findAllPageSize();

}
