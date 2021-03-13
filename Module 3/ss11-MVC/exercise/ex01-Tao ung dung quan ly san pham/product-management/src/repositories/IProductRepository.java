package repositories;

import models.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(int id, Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
