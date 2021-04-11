package com.nhnghia.service;

import com.nhnghia.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

}
