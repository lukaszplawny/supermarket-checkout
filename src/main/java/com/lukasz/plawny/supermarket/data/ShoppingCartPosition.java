package com.lukasz.plawny.supermarket.data;

import com.lukasz.plawny.supermarket.data.Item;

public class ShoppingCartPosition {

	private static final int INITIAL_ITEM_QUANTITY = 1;

	private final Item item;
	private int quantity;

	public ShoppingCartPosition(Item item) {
		this(item, INITIAL_ITEM_QUANTITY);
	}

	public ShoppingCartPosition(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}
	
}