package com.beverage.utils;

public enum Ingredients {
	MILK ("milk", 1),
	SUGAR ("sugar", 0.5),
	SODA ("soda", 0.5),
	MINT ("mint", 0.5),
	WATER ("water", 0.5);
	
	private String name;
	private double price;
	
	private Ingredients (String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
