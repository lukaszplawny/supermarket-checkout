package com.lukasz.plawny.supermarket.data;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<ShoppingCartPosition> shoppingCartPositions;

	public ShoppingCart() {
		shoppingCartPositions = new ArrayList<ShoppingCartPosition>();
	}

	public void addItems(List<Item> items) {
		for (Item item : items) {
			ShoppingCartPosition shoppingCartPositionWithItem = findShoppingCartPositionWithItem(item);
			if (shoppingCartPositionWithItem != null) {
				incrementItemQuantity(shoppingCartPositionWithItem);
			} else // actual there is no shopping cart position with the item,
					// there is need to add new one
			{
				ShoppingCartPosition shoppingCartPosition = new ShoppingCartPosition(item);
				shoppingCartPositions.add(shoppingCartPosition);
			}
		}
	}

	public int getItemQuantity(Item item) {
		ShoppingCartPosition shoppingCartPositionWithItem = findShoppingCartPositionWithItem(item);
		if (shoppingCartPositionWithItem != null) {
			return shoppingCartPositionWithItem.getQuantity();
		}
		return 0;
	}

	// TODO return clone with cloned objects
	public List<ShoppingCartPosition> getShoppingCartPositions() {
		return shoppingCartPositions;
	}

	private ShoppingCartPosition findShoppingCartPositionWithItem(Item item) {
		for (ShoppingCartPosition cartPositionToCheck : shoppingCartPositions) {
			if (cartPositionToCheck.getItem().equals(item)) {
				return cartPositionToCheck;
			}
		}
		return null;
	}

	private void incrementItemQuantity(ShoppingCartPosition shoppingCartPosition) {
		int actualItemQuantity = shoppingCartPosition.getQuantity();
		shoppingCartPosition.setQuantity(++actualItemQuantity);
	}

}