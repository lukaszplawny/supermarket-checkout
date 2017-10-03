package com.lukasz.plawny.supermarket.service;

import java.util.ArrayList;
import java.util.List;

import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCart;

/**
 * 
 * Class that implements supermarket checkout functionality. Class is stateful
 * 
 * @author Lukasz Plawny
 *
 */
public class SupermarketCheckoutServiceImpl implements SupermarketCheckoutService {

	private final ShoppingCart shoppingCartForScannedItems;
	private final PriceCalculator priceCalculator;
	private int actualTotalPrice;

	public SupermarketCheckoutServiceImpl() {
		shoppingCartForScannedItems = new ShoppingCart();
		priceCalculator = new PriceCalculatorImpl();
		actualTotalPrice = 0;
	}

	SupermarketCheckoutServiceImpl(ShoppingCart shoppingCart, PriceCalculator priceCalculator) {
		this.shoppingCartForScannedItems = shoppingCart;
		this.priceCalculator = priceCalculator;
		actualTotalPrice = priceCalculator.calculateTotalPrice(shoppingCart);
	}

	/**
	 * Method returns total price of all items passed to the method during service lifecycle.
	 * 
	 * @param itemId List of item identifiers
	 * @return total price of all items
	 */
	public int checkout(List<String> itemId) {
		List<Item> items = convertToItems(itemId);
		shoppingCartForScannedItems.addItems(items);
		actualTotalPrice = priceCalculator.calculateTotalPrice(shoppingCartForScannedItems);
		return actualTotalPrice;
	}

	
	/**
	 * Method returns total price of all items passed to the method during service lifecycle.
	 * 
	 * @return total price of all items
	 */
	public int getActualTotalPrice() {
		return actualTotalPrice;
	}

	private List<Item> convertToItems(List<String> itemsId) {
		List<Item> items = new ArrayList<>();
		for (String itemid : itemsId) {
			items.add(Item.valueOf(itemid));
		}
		return items;
	}
}