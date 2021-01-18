package ss11_map_tree.exercise.ex01_product_management;

import java.util.Comparator;

public class AscPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
