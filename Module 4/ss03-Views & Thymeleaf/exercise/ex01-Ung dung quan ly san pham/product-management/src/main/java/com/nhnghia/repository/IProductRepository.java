package com.nhnghia.repository;

import com.nhnghia.model.Product;

import java.util.List;

public interface IProductRepository {

    void save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    void update(Long id, Product product);

    void delete(Long id);

}
