package com.lukasz.plawny.supermarket.dto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCartEntry;

public class ShoppingCartEntryTest {

	private ShoppingCartEntry shoppingCartEntry;

	@Before
	public void createShoppingCartPosition() {
		shoppingCartEntry = new ShoppingCartEntry(Item.A);
	}

	@Test
	public void ShoppingCartEntry_ShouldCreateShoppingCartEntryWithZeroQuantity() {
		ShoppingCartEntry cartEntryWithZeroQuantity = new ShoppingCartEntry(Item.B);
		assertEquals(0, cartEntryWithZeroQuantity.getQuantity());
		assertEquals(Item.B, cartEntryWithZeroQuantity.getItem());
	}

	@Test
	public void setQuantity_ShouldUpdateItemsQuantity() {
		shoppingCartEntry.setQuantity(3);
		assertEquals(3, shoppingCartEntry.getQuantity());
		shoppingCartEntry.setQuantity(100000);
		assertEquals(100000, shoppingCartEntry.getQuantity());
		shoppingCartEntry.setQuantity(1);
		assertEquals(1, shoppingCartEntry.getQuantity());
	}

	@Test(expected = IllegalArgumentException.class)
	public void setQuantity_ShouldThrowException_WhenSettingNegativeQuantity() {
		shoppingCartEntry.setQuantity(-1);
	}

}
