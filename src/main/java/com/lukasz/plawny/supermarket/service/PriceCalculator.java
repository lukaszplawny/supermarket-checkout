package com.lukasz.plawny.supermarket.service;

import com.lukasz.plawny.supermarket.dto.ShoppingCart;

public interface PriceCalculator {

	public int calculateTotalPrice(final ShoppingCart shoppingCart);
	
}
