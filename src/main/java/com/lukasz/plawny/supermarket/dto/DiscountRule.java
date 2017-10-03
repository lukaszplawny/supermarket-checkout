package com.lukasz.plawny.supermarket.dto;

//TODO I would like to have discount rules in for example json file to provide possibility for easy extension of discount rules
public enum DiscountRule {

	BUY_3_ITEMS_A_GET_50_DISCOUNT(Item.A, 3, 50), BUY_2_ITEMS_B_GET_5_DISCOUNT(Item.B, 2, 5);

	private final Item item;
	private final int itemQuantity;
	private final int discountValue;

	private DiscountRule(Item item, int itemQuantity, int discountValue) {
		this.item = item;
		this.itemQuantity = itemQuantity;
		this.discountValue = discountValue;
	}

	public Item getItem() {
		return item;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public int getDiscountValue() {
		return discountValue;
	}

}