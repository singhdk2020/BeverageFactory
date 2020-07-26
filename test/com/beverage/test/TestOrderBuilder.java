package com.beverage.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.beverage.builder.BeverageBuilder;
import com.beverage.helper.OrderBuilder;

public class TestOrderBuilder {

	@Test
	public void TestInputAsList() {
		String orderName = "coffee";
		List<String> elements = OrderBuilder.inputAsList(orderName);
		assertNotNull(elements);
		
		String orderName2 = "chai, -sugar";
		List<String> elements2 = OrderBuilder.inputAsList(orderName2);
		assertNotNull(elements2);
	}
	
	@Test
	public void TestGetBeverageBuilderPositive() throws Exception {
		String orderName = "coffee";
		BeverageBuilder beverageBuilder = OrderBuilder.getBeverageBuilder(orderName);
		assertNotNull(beverageBuilder);
	}
	
	@Test
	public void TestGetBeverageBuilderPositive2() throws Exception {
		String orderName = "chai, -milk";
		BeverageBuilder beverageBuilder = OrderBuilder.getBeverageBuilder(orderName);
		assertNotNull(beverageBuilder);
	}
	
	@Test(expected = Exception.class)
	public void TestGetBeverageBuilderNegative() throws Exception {
		String orderName = "abc";
		OrderBuilder.getBeverageBuilder(orderName);
	}
	
	@Test(expected = Exception.class)
	public void TestGetBeverageBuilderNegative2() throws Exception {
		String orderName = "";
		OrderBuilder.getBeverageBuilder(orderName);
	}
	
	@Test(expected = Exception.class)
	public void TestGetBeverageBuilderNegative3() throws Exception {
		String orderName = "chai, -milk, -sugar, -water";
		OrderBuilder.getBeverageBuilder(orderName);
	}
	
	@Test
	public void TestGetPricePositive() throws Exception {
		String orderName = "coffee";
		double price = OrderBuilder.getPrice(orderName);
		assertNotNull(price);
	}
	
	@Test
	public void TestGetPricePositive2() throws Exception {
		String orderName = "mojito, -mint";
		double price = OrderBuilder.getPrice(orderName);
		assertNotNull(price);
	}
	
	@Test(expected = Exception.class)
	public void TestGetPriceNegative() throws Exception {
		String orderName = "abc";
		OrderBuilder.getPrice(orderName);
	}
	
	@Test(expected = Exception.class)
	public void TestGetPriceNegative2() throws Exception {
		String orderName = "mojito, -milk";
		OrderBuilder.getPrice(orderName);
	}
}
