package com.lukasz.plawny.supermarket.dto;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<ShoppingCartEntry> shoppingCartEntries;

	public ShoppingCart() {
		shoppingCartEntries = new ArrayList<>();
	}

	public void addItems(List<Item> items) {
		for (Item item : items) {
			ShoppingCartEntry shoppingCartEntryWithItem = getShoppingCartEntry(item);
			incrementItemQuantity(shoppingCartEntryWithItem);
		}
	}

	public List<ShoppingCartEntry> getShoppingCartEntries() {
		return shoppingCartEntries;
	}

	private ShoppingCartEntry getShoppingCartEntry(Item item) {
		for (ShoppingCartEntry cartEntryToCheck : shoppingCartEntries) {
			if (cartEntryToCheck.getItem().equals(item)) {
				return cartEntryToCheck;
			}
		}
		ShoppingCartEntry newlyCreatedShoppingCartEntry = new ShoppingCartEntry(item);
		shoppingCartEntries.add(newlyCreatedShoppingCartEntry);
		return newlyCreatedShoppingCartEntry;
	}

	private void incrementItemQuantity(ShoppingCartEntry shoppingCartEntry) {
		int actualItemQuantity = shoppingCartEntry.getQuantity();
		shoppingCartEntry.setQuantity(++actualItemQuantity);
	}
}