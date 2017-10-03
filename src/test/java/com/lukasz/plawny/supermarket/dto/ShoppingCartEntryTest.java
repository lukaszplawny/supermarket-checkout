package com.lukasz.plawny.supermarket.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCartEntry;

public class ShoppingCartEntryTest {

	private ShoppingCartEntry shoppingCartPosition;

	@Before
	public void createShoppingCartPosition() {
		shoppingCartPosition = new ShoppingCartEntry(Item.A);
	}

	@Test
	public void shouldCreateShoppingCartPositionWithZeroQuantity() {
		ShoppingCartEntry cartPositionWithZeroQuantity = new ShoppingCartEntry(Item.B);
		assertEquals(0, cartPositionWithZeroQuantity.getQuantity());
		assertEquals(Item.B, cartPositionWithZeroQuantity.getItem());
	}

	@Test
	public void shouldUpdateItemsQuantity() {
		shoppingCartPosition.setQuantity(3);
		assertEquals(3, shoppingCartPosition.getQuantity());
		shoppingCartPosition.setQuantity(100000);
		assertEquals(100000, shoppingCartPosition.getQuantity());
		shoppingCartPosition.setQuantity(1);
		assertEquals(1, shoppingCartPosition.getQuantity());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenSettingNegativeQuantity() {
		shoppingCartPosition.setQuantity(-1);
	}

}
