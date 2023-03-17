package com.trainings.algorithms.lambdas;

public class ProductB {
    private final String name;
    private final Double price;
    private final Double discount;

    public ProductB(String name, Double price, Double discount) {
        super();
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }
}
