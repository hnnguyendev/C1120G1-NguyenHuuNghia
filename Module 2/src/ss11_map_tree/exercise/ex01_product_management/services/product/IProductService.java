package ss11_map_tree.exercise.ex01_product_management.services.product;

import ss11_map_tree.exercise.ex01_product_management.models.Product;
import ss11_map_tree.exercise.ex01_product_management.services.crud.ICRUDService;

import java.util.List;

public interface IProductService extends ICRUDService<Product> {

    // any extra method, without ICRUDService
    List<Product> searchByName(String name);

    void sortByPrice(int sort);

}
