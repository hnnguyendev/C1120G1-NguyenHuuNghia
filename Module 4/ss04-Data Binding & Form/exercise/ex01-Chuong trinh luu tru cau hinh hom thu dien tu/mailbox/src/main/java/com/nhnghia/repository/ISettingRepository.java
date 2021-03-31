package com.nhnghia.repository;

import java.util.List;

public interface ISettingRepository {

    List<String> findAllLanguage();

    List<Integer> findAllPageSize();

}
