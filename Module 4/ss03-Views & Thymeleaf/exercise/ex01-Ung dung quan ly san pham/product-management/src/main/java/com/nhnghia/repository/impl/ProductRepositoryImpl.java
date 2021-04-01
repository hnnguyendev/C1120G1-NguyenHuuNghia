package com.nhnghia.repository.impl;

import com.nhnghia.model.Product;
import com.nhnghia.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private static Map<Long, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1L, new Product(1L, "Samsung", 900, "S series"));
        productMap.put(2L, new Product(2L, "Iphone", 1000, "Pro"));
        productMap.put(3L, new Product(3L, "Nokia", 500, "Microsoft"));
        productMap.put(4L, new Product(4L, "One Plus", 400, "Google"));
        productMap.put(5L, new Product(5L, "Huawei", 600, "Mate"));
    }
    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(Long id) {
        return productMap.get(id);
    }

    @Override
    public void update(Long id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(Long id) {
        productMap.remove(id);
    }
}
