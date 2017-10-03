package com.lukasz.plawny.supermarket.dto;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<ShoppingCartEntry> shoppingCartEntries;

	public ShoppingCart() {
		this(new ArrayList<>());
	}

	public ShoppingCart(List<ShoppingCartEntry> shoppingCartEntries) {
		this.shoppingCartEntries = shoppingCartEntries;
	}

	public void addItems(List<Item> items) {
		for (Item item : items) {
			ShoppingCartEntry shoppingCartPositionWithItem = getShoppingCartEntry(item);
			incrementItemQuantity(shoppingCartPositionWithItem);
		}
	}

	public List<ShoppingCartEntry> getShoppingCartEntries() {
		return shoppingCartEntries;
	}

	private ShoppingCartEntry getShoppingCartEntry(Item item) {
		for (ShoppingCartEntry cartPositionToCheck : shoppingCartEntries) {
			if (cartPositionToCheck.getItem().equals(item)) {
				return cartPositionToCheck;
			}
		}
		ShoppingCartEntry newlyCreatedShoppingCartEntry = new ShoppingCartEntry(item);
		shoppingCartEntries.add(newlyCreatedShoppingCartEntry);
		return newlyCreatedShoppingCartEntry;
	}

	private void incrementItemQuantity(ShoppingCartEntry shoppingCartPosition) {
		int actualItemQuantity = shoppingCartPosition.getQuantity();
		shoppingCartPosition.setQuantity(++actualItemQuantity);
	}
}