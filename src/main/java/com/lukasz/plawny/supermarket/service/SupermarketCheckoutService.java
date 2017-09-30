package com.lukasz.plawny.supermarket.service;

import java.util.List;

import com.lukasz.plawny.supermarket.data.Item;

public interface SupermarketCheckoutService {

	public int checkout(List<Item> items);
	public int getActualTotalPrice();

}