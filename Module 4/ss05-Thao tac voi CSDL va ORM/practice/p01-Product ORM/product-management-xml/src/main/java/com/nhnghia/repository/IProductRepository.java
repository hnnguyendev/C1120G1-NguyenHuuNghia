package com.nhnghia.repository;

import com.nhnghia.entity.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void delete(Long id);

}
