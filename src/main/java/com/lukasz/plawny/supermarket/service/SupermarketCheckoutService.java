package com.lukasz.plawny.supermarket.service;

import java.util.List;

/**
 * 
 * Interface that provides access to supermarket checkout functionality
 * 
 * @author Lukasz Plawny
 *
 */

public interface SupermarketCheckoutService {

	/**
	 * 
	 * This method calculates total price of items, which were passed to the method.
	 * 
	 * @param itemId List of items identifier 
	 * @return total price for specified items
	 */
	public int checkout(List<String> itemId);
	
	/**
	 * 
	 * @return total price of the actual shopping cart
	 */
	public int getActualTotalPrice();

}