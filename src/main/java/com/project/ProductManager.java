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
                .forEach((key, value) -> System.out.println(
                        Product.getFormat().format(key) + " - " + value.size()));
    }

    public void filterByCategory(String category){
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .findAny().ifPresent(System.out::println);
    }

    public double countAverageFrequencyInOneCategory(String category) {
        List<Product> listOfFrequencies = products
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        return listOfFrequencies.stream()
                .reduce(0.0, (x, y) ->
                        x + y.getFrequencyOFSearching(), Double::sum)
                / listOfFrequencies.size();
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
