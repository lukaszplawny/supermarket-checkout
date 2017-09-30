package com.lukasz.plawny.supermarket.service;

import java.util.List;

import com.lukasz.plawny.supermarket.data.Item;
import com.lukasz.plawny.supermarket.data.ShoppingCart;

public class SupermarketCheckoutServiceImpl implements SupermarketCheckoutService{
	
	private final ShoppingCart shoppingCartForScannedItems;
	private final PriceCalculator priceCalculator;
	private int actualTotalPrice;

	public SupermarketCheckoutServiceImpl() {
		shoppingCartForScannedItems = new ShoppingCart();
		priceCalculator = new PriceCalculatorImpl();
		actualTotalPrice = 0;
	}

	public int checkout(List<Item> items) {
		shoppingCartForScannedItems.addItems(items);
		actualTotalPrice = priceCalculator.calculateTotalPrice(shoppingCartForScannedItems);
		return actualTotalPrice;
	}

	public int getActualTotalPrice() {
		return actualTotalPrice;
	}

}