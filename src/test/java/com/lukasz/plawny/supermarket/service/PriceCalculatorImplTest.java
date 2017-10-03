package com.lukasz.plawny.supermarket.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCart;

public class PriceCalculatorImplTest {
	
	private PriceCalculator priceCalculator = new PriceCalculatorImpl();
	
	private ShoppingCart shoppingCart;

	@Test
	public void shouldCalculatePriceWithoutDiscount() {
		shoppingCart = new ShoppingCart();
		shoppingCart.addItems(Arrays.asList(Item.A, Item.B, Item.C));
		int calculatedPrice = priceCalculator.calculateTotalPrice(shoppingCart);
		assertEquals(calculatedPrice, 80);
	}
	
	@Test
	public void shouldCalculatePriceWithDiscount() {
		shoppingCart = new ShoppingCart();
		shoppingCart.addItems(Arrays.asList(Item.A, Item.A, Item.A));
		int calculatedPrice = priceCalculator.calculateTotalPrice(shoppingCart);
		assertEquals(calculatedPrice, 70);
	}

}
