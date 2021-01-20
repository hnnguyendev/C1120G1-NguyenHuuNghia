package ss11_map_tree.exercise.ex01_product_management;

import ss11_map_tree.exercise.ex01_product_management.models.Product;
import ss11_map_tree.exercise.ex01_product_management.utils.sort.AscPriceComparator;
import ss11_map_tree.exercise.ex01_product_management.utils.sort.DescPriceComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private static final List<Product> productList = new ArrayList<>();
    private static int id = 0;

    public static void insertProduct() {
        Scanner scanner = new Scanner(System.in);
        id += 1;
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, price);
        productList.add(product);
    }

    public static void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id of product you want to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("You want to update:\n" +
                "1. Product Name\n" +
                "2. Product Price\n" +
                "Your choice: ");
        int field = Integer.parseInt(scanner.nextLine());
        switch (field) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                productList.get(getIndex(id)).setName(newName);
                break;
            case 2:
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                productList.get(getIndex(id)).setPrice(newPrice);
                break;
        }
    }

    public static void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id of product you want to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        productList.remove(getIndex(id));
    }

    public static void showProduct() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
    }

    public static void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        System.out.print("Search: ");
        String searchName = scanner.nextLine();
        for (Product product : productList) {
            if (searchName.contains(product.getName())) {
                flag = true;
            }
            if (flag) {
                System.out.println(product.toString());
            }
            flag = false;
        }
    }

    public static void sortByPriceAsc() {
        productList.sort(new AscPriceComparator());
    }

    public static void sortByPriceDesc() {
        productList.sort(new DescPriceComparator());
    }

    public static void sortByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("You want to sort:\n" +
                "1. Ascending\n" +
                "2. Descending\n" +
                "Your choice: ");
        int sort = Integer.parseInt(scanner.nextLine());
        switch (sort) {
            case 1:
                sortByPriceAsc();
                showProduct();
                break;
            case 2:
                sortByPriceDesc();
                showProduct();
                break;
        }
    }

    public static int getIndex(int id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int menuOptions;
        do {
            System.out.print("---------------------PRODUCT MANAGER---------------------\n" +
                    "1. Add Product\t\t" +
                    "2. Update Product\t" +
                    "3. Remove Product\n" +
                    "4. Show Product\t\t" +
                    "5. Search Product\t" +
                    "6. Sort Product\n" +
                    "0. Exit\n" +
                    "---------------------------------------------------------\n");
            do {
                System.out.print("Your choice: ");
                menuOptions = Integer.parseInt(scanner.nextLine());
            } while (menuOptions > 6 || menuOptions < 0);
            switch (menuOptions) {
                case 1:
                    insertProduct();
                    showProduct();
                    break;
                case 2:
                    updateProduct();
                    showProduct();
                    break;
                case 3:
                    removeProduct();
                    showProduct();
                    break;
                case 4:
                    showProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    sortByPrice();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
