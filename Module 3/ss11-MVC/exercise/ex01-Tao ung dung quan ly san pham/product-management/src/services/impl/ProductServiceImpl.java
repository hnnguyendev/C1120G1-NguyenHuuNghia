package services.impl;

import models.Product;
import repositories.IProductRepository;
import repositories.impl.ProductRepositoryImpl;
import services.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {

    IProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
