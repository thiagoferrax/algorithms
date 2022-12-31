package com.trainings.lambdas;

public class ProductB {
	private String name;
	private Double price;
	private Double discount;

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
