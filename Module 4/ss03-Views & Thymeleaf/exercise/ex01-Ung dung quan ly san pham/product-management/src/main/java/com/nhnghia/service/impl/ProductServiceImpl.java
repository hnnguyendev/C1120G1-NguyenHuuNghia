package com.nhnghia.service.impl;

import com.nhnghia.model.Product;
import com.nhnghia.repository.IProductRepository;
import com.nhnghia.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Long id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }
}
