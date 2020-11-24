package com.project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        try (Scanner scannerShop = new Scanner(new File("shop.txt"))) {
            while (scannerShop.hasNext()) {
                Product product = new Product(scannerShop.nextLine());
                products.add(product);
            }
            products
                    .stream()
                    .map(Product::getName)
                    .filter(s -> s.length() > 5)
                    .reduce((x, y) -> x + ", " + y)
                    .ifPresent(System.out::println);
            products
                    .stream()
                    .collect(Collectors.toMap(Product::getDeliveryDate, Product::getName))
                    .entrySet()
                    .stream()
                    .parallel()
                    .sorted((x, y) -> (int) (x.getKey().getTime() - y.getKey().getTime()))
                    .findAny().ifPresent(System.out::println);
            products
                    .stream()
                    .collect(Collectors.groupingBy(Product::getCategory))
                    .entrySet()
                    .forEach(System.out::println);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
