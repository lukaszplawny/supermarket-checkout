package com.lukasz.plawny.supermarket.service;

import java.util.List;

import com.lukasz.plawny.supermarket.data.Item;
import com.lukasz.plawny.supermarket.data.ShoppingCart;

public class SupermarketCheckoutServiceImpl implements SupermarketCheckoutService{
	
	private final ShoppingCart shoppingCartForScannedItems;
	private int actualTotalPrice;

	public SupermarketCheckoutServiceImpl() {
		shoppingCartForScannedItems = new ShoppingCart();
		actualTotalPrice = 0;
	}

	public int checkout(List<Item> items) {
		shoppingCartForScannedItems.addItems(items);
		// TODO calculate actual total price
		return 0;
	}

	public int getActualTotalPrice() {
		return actualTotalPrice;
	}

}
