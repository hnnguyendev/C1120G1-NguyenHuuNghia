package ss11_map_tree.exercise.ex01_product_management.controllers;

import ss11_map_tree.exercise.ex01_product_management.models.Product;
import ss11_map_tree.exercise.ex01_product_management.services.product.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductServiceImpl productService = new ProductServiceImpl();
    private static Scanner scanner = new Scanner(System.in);
    public static int id = 5;

    public static void showProduct() {
        List<Product> productList = productService.findALl();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void createProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        productService.save(new Product(++id, name, price));
    }

    public static void updateProduct() {
        System.out.print("Enter id of product you want to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = productService.findById(id);
        System.out.print(product.toString() +
                "\nYou want to update:\n" +
                "1. Product Name\n" +
                "2. Product Price\n" +
                "Your choice: ");
        int field = Integer.parseInt(scanner.nextLine());
        switch (field) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                productService.update(new Product(id, newName, product.getPrice()), id);
                break;
            case 2:
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                productService.update(new Product(id, product.getName(), newPrice), id);
                break;
        }
    }

    public static void removeProduct() {
        System.out.print("Enter id of product you want to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        productService.remove(id);
    }

    public static void searchProduct() {
        System.out.print("Search name: ");
        String name = scanner.nextLine();

        List<Product> productList = productService.searchByName(name);

        if (!productList.isEmpty()) {
            for (Product product : productList) {
                System.out.println(product);
            }

        } else {
            System.out.println("No result");
        }
    }

    public static void sortByPrice() {
        System.out.print("Sort by price:\n" +
                "1. Ascending\n" +
                "2. Descending\n" +
                "Your choice: ");
        int sort = Integer.parseInt(scanner.nextLine());
        productService.sortByPrice(sort);
    }

    public static void main(String[] args) {
        int menuOptions;
        do {
            System.out.print("---------------------PRODUCT MANAGER---------------------\n" +
                    "1. Add Product\t\t" +
                    "2. Update Product\t" +
                    "3. Remove Product\n" +
                    "4. Show Product\t\t" +
                    "5. Search Product\t" +
                    "6. Sort Product\n" +
                    "0. EXIT\n" +
                    "---------------------------------------------------------\n");
            do {
                System.out.print("Your choice: ");
                menuOptions = Integer.parseInt(scanner.nextLine());
            } while (menuOptions > 6 || menuOptions < 0);
            switch (menuOptions) {
                case 1:
                    createProduct();
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
                    showProduct();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}
