package com.lukasz.plawny.supermarket.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import com.lukasz.plawny.supermarket.dto.DiscountRule;
import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCart;

@RunWith(MockitoJUnitRunner.class)
public class PriceCalculatorImplTest {

	private PriceCalculator priceCalculator;
	private ShoppingCart shoppingCart;

	@Mock
	DiscountRuleProvider discountRuleProvider;

	@Before
	public void createPriceCalculatorAndShoppingCart() {
		priceCalculator = new PriceCalculatorImpl();
		shoppingCart = new ShoppingCart();
		Mockito.when(discountRuleProvider.findDiscountRule(Item.A))
				.thenReturn(DiscountRule.BUY_3_ITEMS_A_GET_50_DISCOUNT);
		Mockito.when(discountRuleProvider.findDiscountRule(Item.B))
				.thenReturn(DiscountRule.BUY_2_ITEMS_B_GET_5_DISCOUNT);
		Mockito.when(discountRuleProvider.findDiscountRule(Item.C)).thenReturn(null);
		Whitebox.setInternalState(priceCalculator, "discountRuleProvider", discountRuleProvider);
	}

	@Test
	public void calculateTotalPrice_ShouldReturnPriceWithoutDiscount_WhenInsufficientNumberOfItems() {
		shoppingCart.addItems(Arrays.asList(Item.A, Item.B, Item.A));
		int calculatedPrice = priceCalculator.calculateTotalPrice(shoppingCart);
		assertEquals(90, calculatedPrice);
	}

	@Test
	public void calculateTotalPrice_ShouldReturnPriceWithoutDiscount_WhenThereIsNoDiscountForItem() {
		shoppingCart.addItems(Arrays.asList(Item.C, Item.C, Item.C, Item.C, Item.C));
		int calculatedPrice = priceCalculator.calculateTotalPrice(shoppingCart);
		assertEquals(150, calculatedPrice);
	}

	@Test
	public void calculateTotalPrice_ShouldReturnPriceWithDiscount_WhenSufficientItemQuantityAndThereIsDiscountForItem() {
		shoppingCart.addItems(Arrays.asList(Item.A, Item.A, Item.A));
		int calculatedPrice = priceCalculator.calculateTotalPrice(shoppingCart);
		assertEquals(70, calculatedPrice);
	}

}