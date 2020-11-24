package com.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private final SimpleDateFormat
            format = new SimpleDateFormat("dd.MM.yyyy");

    private String number;
    private String name;
    private Date deliveryDate;
    private String category;
    private double frequencyOFSearching;

    public Product(String inf) throws Exception {
        String[] words = inf.split(";");
        if (words.length < 5) {
            throw new Exception();
        }
        number = words[0];
        name = words[1];
        deliveryDate = format.parse(words[2]);
        category = words[3];
        frequencyOFSearching = Double.parseDouble(words[4]);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFrequencyOFSearching(double frequencyOFSearching) {
        this.frequencyOFSearching = frequencyOFSearching;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getCategory() {
        return category;
    }

    public double getFrequencyOFSearching() {
        return frequencyOFSearching;
    }

    @Override
    public String toString() {
        return "Product{" +
                " number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", category='" + category + '\'' +
                ", frequencyOFSearching=" + frequencyOFSearching +
                '}';
    }
}
