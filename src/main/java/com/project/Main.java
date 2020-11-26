package com.project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        try (Scanner scannerShop = new Scanner(new File("shop.txt"));
             Scanner inputScanner = new Scanner(System.in)) {
            while (scannerShop.hasNext()) {
                Product product = new Product(scannerShop.nextLine());
                products.add(product);
            }
            ProductManager productManager = new ProductManager(products);
            System.out.println("Enter category:");
            String category = inputScanner.nextLine();
            System.out.println("Average frequency in " + category + " = " +
                    productManager.countAverageFrequencyInOneCategory(category));
            System.out.println("Products divided by delivery date:");
            productManager.divideProductsByDeliveryDate();
            System.out.println("Sorted products");
            productManager.sortProductsByNameLength();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
