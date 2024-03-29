package com.trainings.algorithms.lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Product {
    public static BinaryOperator<Double> priceWithDiscount = (price, discount) -> price * (1 - discount);
    public static UnaryOperator<Double> tax = price -> price >= 2500 ? price * (1 + 0.085) : price;
    public static UnaryOperator<Double> delivery = price -> price >= 3000 ? price + 100 : price + 50;
    public static Function<Double, String> format = price -> String.format("R$%.2f", price);
    private final Double price;
    private final Double discount;

    public Product(Double price, Double discount) {
        super();
        this.price = price;
        this.discount = discount;
    }

    public String getTotalPrice() {
        return priceWithDiscount.andThen(tax).andThen(delivery).andThen(format).apply(price, discount);
    }

}
