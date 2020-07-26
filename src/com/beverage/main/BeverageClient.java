package com.beverage.main;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.beverage.helper.OrderBuilder;

public class BeverageClient {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter beverage name :: ");
		String orderName = input.nextLine();
		input.close();
		// get the order price
		double price = OrderBuilder.getPrice(orderName);
		// remove decimal zeroes for whole number
		DecimalFormat format = new DecimalFormat("0.#");
		String finalPrice = format.format(price);
		// print order name and final bill
		System.out.println("Order Name :: [" + orderName + "]");
		System.out.println("Bill :: " + finalPrice + "$");
	}
}