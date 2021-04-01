package com.nhnghia.service;

import com.nhnghia.model.Product;

import java.util.List;

public interface IProductService {

    void save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    void update(Long id, Product product);

    void delete(Long id);

}
