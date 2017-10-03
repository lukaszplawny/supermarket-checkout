package com.lukasz.plawny.supermarket.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCart;

@RunWith(MockitoJUnitRunner.class)
public class SupermarketCheckoutServiceImplTest {

	private SupermarketCheckoutService checkoutService;

	@Mock
	private ShoppingCart shoppingCart;

	@Mock
	private PriceCalculator priceCalculator;

	@Before
	public void createCheckoutService() {
		Mockito.when(priceCalculator.calculateTotalPrice(shoppingCart)).thenReturn(0);
		checkoutService = new SupermarketCheckoutServiceImpl(shoppingCart, priceCalculator);
	}

	@Test
	public void shouldUpdateTotalPriceWhenNewItemsAdded() {
		Mockito.when(priceCalculator.calculateTotalPrice(shoppingCart)).thenReturn(430);
		int actualTotalPrice = checkoutService.checkout(Arrays.asList("A", "B", "A"));
		assertEquals(430, actualTotalPrice);
	}

	@Test
	public void shouldUpdateTotalPriceWhenNewItemsAddedToAlreadyNotEmptyShoppingCart() {
		Mockito.when(priceCalculator.calculateTotalPrice(shoppingCart)).thenReturn(430);
		checkoutService.checkout(Arrays.asList("A", "B", "A"));
		Mockito.when(priceCalculator.calculateTotalPrice(shoppingCart)).thenReturn(480);
		int actualTotalPrice = checkoutService.checkout(Arrays.asList("C"));
		assertEquals(480, actualTotalPrice);
	}

	@Test
	public void shouldUpdateShoppingCartWhenNewItemsAdded() {
		Mockito.when(priceCalculator.calculateTotalPrice(shoppingCart)).thenReturn(430);
		checkoutService.checkout(Arrays.asList("A", "B", "A"));
		Mockito.verify(shoppingCart, Mockito.times(1)).addItems(Mockito.eq(Arrays.asList(Item.A, Item.B, Item.A)));
	}

	@Test
	public void shouldSetTotalPriceToZeroDuringInitialization() {
		assertEquals(checkoutService.getActualTotalPrice(), 0);
		checkoutService = new SupermarketCheckoutServiceImpl();
		assertEquals(checkoutService.getActualTotalPrice(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenInvalidItemId() {
		checkoutService.checkout(Arrays.asList("INVALIDID"));
	}

	@Test
	public void shouldReturnActualTotalPrice() {

	}

}