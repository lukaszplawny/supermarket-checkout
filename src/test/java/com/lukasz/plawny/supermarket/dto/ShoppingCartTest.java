package com.lukasz.plawny.supermarket.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCart;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest {

	private ShoppingCart shoppingCart;
	
	@Mock
	private ShoppingCartEntry shoppingCartEntry;

	@Before
	public void createShoppingCart() {
		shoppingCart = new ShoppingCart();
	}

	@Test
	public void addItems_ShouldCreateNewShoppingCartEntry_WhenNewItemIsAdded() throws Exception {
		shoppingCart.addItems(Arrays.asList(Item.A));
		assertEquals(shoppingCart.getShoppingCartEntries().size(), 1);
		assertEquals(shoppingCart.getShoppingCartEntries().get(0).getItem(), Item.A);
	}

	@Test
	public void add_Items_ShouldIncrementItemsQuantity_WhenMultipleItemsAreAdded() {
		List<Item> items = new ArrayList<>();
		items.add(Item.A);
		items.add(Item.B);
		items.add(Item.C);
		items.add(Item.A);
		shoppingCart.addItems(items);
		Map<Item, ShoppingCartEntry> itemShoppingCartEntryMap = new HashMap<>();
		for (ShoppingCartEntry entry : shoppingCart.getShoppingCartEntries()){
			itemShoppingCartEntryMap.put(entry.getItem(), entry);
		}
		assertEquals(itemShoppingCartEntryMap.get(Item.A).getQuantity(), 2);
		assertEquals(itemShoppingCartEntryMap.get(Item.C).getQuantity(), 1);
		assertEquals(itemShoppingCartEntryMap.get(Item.B).getQuantity(), 1);
	}

	@Test
	public void ShoppingCart_ShouldCreateEmptyShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		assertTrue(shoppingCart.getShoppingCartEntries().isEmpty());
	}
}