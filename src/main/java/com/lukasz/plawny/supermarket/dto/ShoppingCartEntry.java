package com.lukasz.plawny.supermarket.dto;

import com.lukasz.plawny.supermarket.dto.Item;

public class ShoppingCartEntry {

	private static final int INITIAL_ITEM_QUANTITY = 0;

	private final Item item;
	private int quantity;

	public ShoppingCartEntry(Item item) {
		this(item, INITIAL_ITEM_QUANTITY);
	}

	public ShoppingCartEntry(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity <= 0)
			throw new IllegalArgumentException("Item quantity cannot be less than 0");
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}
	
}