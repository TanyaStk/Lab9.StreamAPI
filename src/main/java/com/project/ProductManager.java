package com.project;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
    private final List<Product> products;

    public ProductManager(List<Product> products) {
        this.products = products;
    }

    public void divideProductsByDeliveryDate() {
        products
                .stream()
                .collect(Collectors.groupingBy(Product::getDeliveryDate))
                .entrySet()
                .stream().parallel()
                .findAny().ifPresent(System.out::println);
    }

    public double countAverageFrequencyInOneCategory(String category) {
        return products
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .reduce(0.0, (x, y) -> x + y.getFrequencyOFSearching(),
                        Double::sum)
                / (products
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .count());
    }

    public void sortProductsByNameLength() {
        products
                .stream()
                .collect(Collectors.toMap(Product::getNumber, Product::getName))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(x -> x.getValue().length()))
                .forEach(System.out::println);
    }
}
