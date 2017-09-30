package com.lukasz.plawny.supermarket.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lukasz.plawny.supermarket.data.DiscountRule;
import com.lukasz.plawny.supermarket.data.Item;
import com.lukasz.plawny.supermarket.data.ShoppingCart;
import com.lukasz.plawny.supermarket.data.ShoppingCartPosition;

public class PriceCalculatorImpl implements PriceCalculator {

	private static final Logger logger = LoggerFactory.getLogger(PriceCalculatorImpl.class);
	private DiscountRuleProvider discountRuleProvider;

	public PriceCalculatorImpl() {
		discountRuleProvider = new DiscountRuleProviderImpl();
	}

	public int calculateTotalPrice(final ShoppingCart shoppingCart) {
		int totalPrice = 0;
		for (ShoppingCartPosition cartPosition : shoppingCart.getShoppingCartPositions()) {
			int shoppingCartPositionPrice = calculatePrice(cartPosition);
			totalPrice += shoppingCartPositionPrice;
		}
		return totalPrice;
	}

	private int calculatePrice(ShoppingCartPosition shoppingCartPosition) {
		Item item = shoppingCartPosition.getItem();
		int itemQuantity = shoppingCartPosition.getQuantity();
		logger.debug("Calculating price for item: " + item + ", item quantity: " + itemQuantity);
		int cartPositionPrice = item.getUnitPrice() * itemQuantity;
		logger.debug("Price before discount: " + cartPositionPrice);
		DiscountRule discountRuleForTheItem = discountRuleProvider.findDiscountRule(item);
		int discountValue = calculateDiscount(item, itemQuantity, discountRuleForTheItem);
		cartPositionPrice -= discountValue;
		logger.debug("Final cart position price: " + cartPositionPrice);
		return cartPositionPrice;

	}

	private int calculateDiscount(Item item, int itemQuantity, DiscountRule discountRuleForTheItem) {
		int discountValue = 0;
		if (isDiscountApplicable(item, itemQuantity, discountRuleForTheItem)) {
			discountValue = (itemQuantity % discountRuleForTheItem.getItemQuantity())
					* discountRuleForTheItem.getDiscountValue();
			logger.debug("Discount for the item: " + item + ", item quantity: " + itemQuantity + ", discount value: "
					+ discountValue);
		}
		return discountValue;
	}

	private boolean isDiscountApplicable(Item item, int itemQuantity, DiscountRule discountRuleForTheItem) {
		return item == discountRuleForTheItem.getItem() && itemQuantity >= discountRuleForTheItem.getItemQuantity();
	}
}