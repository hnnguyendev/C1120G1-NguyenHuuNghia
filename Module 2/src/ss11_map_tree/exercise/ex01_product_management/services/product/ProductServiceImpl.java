package ss11_map_tree.exercise.ex01_product_management.services.product;

import ss11_map_tree.exercise.ex01_product_management.models.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductServiceImpl implements IProductService {

    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone 6", 300));
        productList.add(new Product(2, "Samsung Galaxy note 10", 1300));
        productList.add(new Product(3, "Nokia 2020", 800));
        productList.add(new Product(4, "Iphone 10", 1000));
        productList.add(new Product(5, "Iphone 12", 2000));
    }

    @Override
    public List<Product> findALl() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product, int id) {
        for (Product product1 : productList) {
            if (id == product1.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
            }
        }
    }

    @Override
    public void remove(int id) {
        // cach 1
        Iterator<Product> iter = productList.iterator();
        while (iter.hasNext()) {
            Product product = iter.next();

            if (id == product.getId())
                iter.remove();
        }

        // cach 2
//        productList.removeIf(product -> product.getId() == id);
    }
}
