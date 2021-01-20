package ss11_map_tree.exercise.ex01_product_management.utils.sort;

import ss11_map_tree.exercise.ex01_product_management.models.Product;

import java.util.Comparator;

public class DescPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o2.getPrice(), o1.getPrice());
    }
}
