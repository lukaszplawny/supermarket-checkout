package com.lukasz.plawny.supermarket.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCart {

	private final Set<ShoppingCartPosition> shoppingCartPositions;

	public ShoppingCart() {
		shoppingCartPositions = new HashSet<>();
	}

	public void addItems(List<Item> items) {
		for (Item item : items) {
			ShoppingCartPosition shoppingCartPositionWithItem = getShoppingCartPosition(item);
			incrementItemQuantity(shoppingCartPositionWithItem);
		}
	}
	
	public Set<ShoppingCartPosition> getShoppingCartPositions() {
		return shoppingCartPositions;
	}
	
	private ShoppingCartPosition getShoppingCartPosition(Item item) {
		for (ShoppingCartPosition cartPositionToCheck : shoppingCartPositions) {
			if (cartPositionToCheck.getItem().equals(item)) {
				return cartPositionToCheck;
			}
		}
		return new ShoppingCartPosition(item);
	}

	private void incrementItemQuantity(ShoppingCartPosition shoppingCartPosition) {
		int actualItemQuantity = shoppingCartPosition.getQuantity();
		shoppingCartPosition.setQuantity(++actualItemQuantity);
	}
}