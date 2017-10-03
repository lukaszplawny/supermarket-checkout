package com.lukasz.plawny.supermarket.dto;

//TODO I would like to have items in for example json or xml file to provide possibility for easy extension of product list
public enum Item {
	A(40), B(10), C(30), D(25);

	private final int unitPrice;

	private Item(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitPrice() {
		return unitPrice;
	}
}