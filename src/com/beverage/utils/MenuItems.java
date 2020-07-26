package com.beverage.utils;

public enum MenuItems {
	COFFEE ("coffee", 5),
	CHAI ("chai", 4),
	BANANASMOOTHIE ("banana-smoothie", 6),
	STRAWBERRYSHAKE ("strawberry-shake", 7),
	MOJITO ("mojito", 7.5);
	
	private String name;
	private double price;
	
	private MenuItems (String name, double price) {
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
