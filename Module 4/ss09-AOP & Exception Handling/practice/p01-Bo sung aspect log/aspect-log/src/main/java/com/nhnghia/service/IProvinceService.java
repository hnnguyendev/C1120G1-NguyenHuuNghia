package com.nhnghia.service;

import com.nhnghia.entity.Province;

import java.util.List;

public interface IProvinceService {

    List<Province> findAll();

    Province findById(Long id);

    Province save(Province Province);

    List<Province> save(List<Province> Provinces);

    boolean exists(Long id);

    List<Province> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Province Province);

    void delete(List<Province> Provinces);

    void deleteAll();

}
