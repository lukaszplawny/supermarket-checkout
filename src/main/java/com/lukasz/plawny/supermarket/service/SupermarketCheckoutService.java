package com.lukasz.plawny.supermarket.service;

import java.util.List;

import com.lukasz.plawny.supermarket.data.Item;

interface SupermarketCheckoutService {

	int checkout(List<Item> items);
	int getActualTotalPrice();

}