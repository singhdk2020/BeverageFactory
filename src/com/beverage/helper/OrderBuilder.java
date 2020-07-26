package com.beverage.helper;

import java.util.Arrays;
import java.util.List;

import com.beverage.builder.BananaSmoothieBuilder;
import com.beverage.builder.BeverageBuilder;
import com.beverage.builder.ChaiBuilder;
import com.beverage.builder.CoffeeBuilder;
import com.beverage.builder.MojitoBuilder;
import com.beverage.builder.StrawberryShakeBuilder;

public class OrderBuilder {

	public static BeverageBuilder getBeverageBuilder(String orderName) throws Exception {
		BeverageBuilder beverageBuilder = null;
		List<String> elements = inputAsList(orderName);
		if (orderName == null || orderName.length() == 0) {
			throw new Exception("Please select at least one menu item...");
		} else if (orderName.trim().startsWith("coffee") && elements.size() < 4) {
			beverageBuilder = new CoffeeBuilder();
		} else if (orderName.trim().startsWith("chai") && elements.size() < 4) {
			beverageBuilder = new ChaiBuilder();
		} else if (orderName.trim().startsWith("banana smoothie") && elements.size() < 4) {
			beverageBuilder = new BananaSmoothieBuilder();
		} else if (orderName.trim().startsWith("strawberry shake") && elements.size() < 4) {
			beverageBuilder = new StrawberryShakeBuilder();
		} else if (orderName.trim().startsWith("mojito") && elements.size() < 5) {
			beverageBuilder = new MojitoBuilder();
		} else if (!orderName.trim().startsWith("coffee") || orderName.trim().startsWith("chai")
				|| orderName.trim().startsWith("banana smoothie") || orderName.trim().startsWith("strawberry shake")
				|| orderName.trim().startsWith("mojito")) {
			throw new Exception("Invalid order received. Please try again!");
		} else {
			throw new Exception("An order cannot have all the ingredients in exclusion for a menu item.");
		}
		return beverageBuilder;
	}

	public static List<String> inputAsList(String orderName) {
		String[] orderElements = orderName.split(",");
		List<String> elements = Arrays.asList(orderElements);
		return elements;
	}

	public static double getPrice(String orderName) throws Exception {
		BeverageBuilder beverageBuilder = getBeverageBuilder(orderName);
		double price = 0;
		List<String> elements = inputAsList(orderName);

		if (elements.size() == 0 || null == elements) {
			throw new Exception("Please select at least one menu item...");
		}
		if (elements != null && elements.size() == 1) {
			price += beverageBuilder.getItemPrice();
		} else if (elements != null && elements.size() > 1) {
			price += beverageBuilder.getItemPrice();
			for (int i = 1; i < elements.size(); i++) {
				if (elements.get(i).trim().equalsIgnoreCase("-sugar")) {
					price = price - beverageBuilder.removeSugar();
				} else if (elements.get(i).trim().equalsIgnoreCase("-milk") && !orderName.trim().startsWith("mojito")) {
					price = price - beverageBuilder.removeMilk();
				} else if (elements.get(i).trim().equalsIgnoreCase("-water")) {
					price = price - beverageBuilder.removeWater();
				} else if (elements.get(i).trim().equalsIgnoreCase("-mint") && orderName.trim().startsWith("mojito")) {
					price = price - beverageBuilder.removeMint();
				} else if (elements.get(i).trim().equalsIgnoreCase("-soda") && orderName.trim().startsWith("mojito")) {
					price = price - beverageBuilder.removeSoda();
				} else {
					throw new Exception("Invalid order received...");
				}
			}
		} else {
			throw new Exception("Invalid order received...");
		}
		return price;
	}
}