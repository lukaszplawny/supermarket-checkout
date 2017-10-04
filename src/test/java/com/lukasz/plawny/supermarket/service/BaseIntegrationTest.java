package com.lukasz.plawny.supermarket.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BaseIntegrationTest {

	private SupermarketCheckoutService checkoutService;

	@Before
	public void createCheckoutService() {
		checkoutService = new SupermarketCheckoutServiceImpl();
	}

	@Test
	public void checkout_ShouldUpdateTotalPrice_WhenNewItemsAdded() {
		int actualTotalPrice = checkoutService.checkout(Arrays.asList("A", "B", "A"));
		assertEquals(90, actualTotalPrice);
	}
	
	@Test
	public void checkout_ShouldUpdateTotalPriceAndApplyDiscountRule() {
		checkoutService.checkout(Arrays.asList("A", "B", "A", "A"));
		int actualTotalPrice = checkoutService.checkout(Arrays.asList("C"));
		assertEquals(110, actualTotalPrice);
	}

	@Test
	public void checkout_ShouldUpdateTotalPrice_WhenNewItemsAddedToAlreadyNotEmptyShoppingCart() {
		checkoutService.checkout(Arrays.asList("A", "B", "A"));
		int actualTotalPrice = checkoutService.checkout(Arrays.asList("C"));
		assertEquals(120, actualTotalPrice);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkout_ShouldThrowException_WhenInvalidItemIdPassedAsArgument() {
		checkoutService.checkout(Arrays.asList("INVALIDID"));
	}

}
