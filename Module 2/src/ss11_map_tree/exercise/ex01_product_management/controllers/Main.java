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

    public static void main(String[] args) {


        showProduct();
//        updateProduct();
        productService.remove(3);
        System.out.println("after remove");
        showProduct();
    }
}
