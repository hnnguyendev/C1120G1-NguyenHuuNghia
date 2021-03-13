package repositories.impl;

import models.Product;
import repositories.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 12 Pro Max", 1500, "Description Iphone 12 Pro Max", "Apple"));
        products.put(2, new Product(2, "Sony Xperia", 1000, "Description Sony Xperia", "Sony"));
        products.put(3, new Product(3, "Bphone B86", 500, "Description Bphone B86", "Bkav"));
        products.put(4, new Product(4, "Samsung Galaxy Note 20 Ultra", 1200, "Description Samsung Galaxy Note 20 Ultra", "Samsung"));
        products.put(5, new Product(5, "Vsmart Aris", 400, "Description Vsmart Aris", "VinSmart"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>(products.values());
        List<Product> searchList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                searchList.add(product);
            }
        }

        return searchList;
    }
}
