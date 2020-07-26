package com.beverage.builder;

import com.beverage.utils.Ingredients;
import com.beverage.utils.MenuItems;

public class MojitoBuilder extends BeverageBuilder {
	public double getItemPrice() {
		return MenuItems.MOJITO.getPrice();
	}
	
	public double removeSoda() {
		return Ingredients.SODA.getPrice();
	}
	
	public double removeMint() {
		return Ingredients.MINT.getPrice();
	}
	
	public double removeSugar() {
		return Ingredients.SUGAR.getPrice();
	}
	
	public double removeWater() {
		return Ingredients.WATER.getPrice();
	}
}