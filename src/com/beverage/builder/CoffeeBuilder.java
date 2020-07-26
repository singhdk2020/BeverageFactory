package com.beverage.builder;

import com.beverage.utils.Ingredients;
import com.beverage.utils.MenuItems;

public class CoffeeBuilder extends BeverageBuilder {
	CoffeeBuilder getCoffeeBuilderInstance() {
		return new CoffeeBuilder();
	}
	
	public double getItemPrice() {
		return MenuItems.COFFEE.getPrice();
	}
	
	public double removeMilk() {
		return Ingredients.MILK.getPrice();
	}
	
	public double removeSugar() {
		return Ingredients.SUGAR.getPrice();
	}
	
	public double removeWater() {
		return Ingredients.WATER.getPrice();
	}
}