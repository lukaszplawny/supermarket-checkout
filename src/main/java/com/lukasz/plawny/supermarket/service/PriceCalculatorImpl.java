package com.lukasz.plawny.supermarket.service;

import java.util.logging.Logger;

import com.lukasz.plawny.supermarket.dto.DiscountRule;
import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.dto.ShoppingCart;
import com.lukasz.plawny.supermarket.dto.ShoppingCartEntry;

public class PriceCalculatorImpl implements PriceCalculator {

	private static final Logger logger = Logger.getLogger(PriceCalculatorImpl.class.getName());
	private DiscountRuleProvider discountRuleProvider;

	public PriceCalculatorImpl() {
		discountRuleProvider = new DiscountRuleProviderImpl();
	}

	public int calculateTotalPrice(final ShoppingCart shoppingCart) {
		int totalPrice = 0;
		for (ShoppingCartEntry cartPosition : shoppingCart.getShoppingCartEntries()) {
			int shoppingCartPositionPrice = calculatePrice(cartPosition);
			totalPrice += shoppingCartPositionPrice;
		}
		return totalPrice;
	}

	private int calculatePrice(ShoppingCartEntry shoppingCartPosition) {
		Item item = shoppingCartPosition.getItem();
		int itemQuantity = shoppingCartPosition.getQuantity();
		logger.info("Calculating price for item: " + item + ", item quantity: " + itemQuantity);
		int cartPositionPrice = item.getUnitPrice() * itemQuantity;
		logger.info("Price before discount: " + cartPositionPrice);
		DiscountRule discountRuleForTheItem = discountRuleProvider.findDiscountRule(item);
		if (discountRuleForTheItem != null) {
			int discountValue = calculateDiscount(item, itemQuantity, discountRuleForTheItem);
			cartPositionPrice -= discountValue;
		}
		logger.info("Final cart position price: " + cartPositionPrice);
		return cartPositionPrice;

	}

	private int calculateDiscount(Item item, int itemQuantity, DiscountRule discountRuleForTheItem) {
		int discountValue = 0;
		if (isDiscountApplicable(item, itemQuantity, discountRuleForTheItem)) {
			discountValue = (itemQuantity / discountRuleForTheItem.getItemQuantity())
					* discountRuleForTheItem.getDiscountValue();
			logger.info("Discount for the item: " + item + ", item quantity:" + itemQuantity + ", discount value: "
					+ discountValue);
		}
		return discountValue;
	}

	private boolean isDiscountApplicable(Item item, int itemQuantity, DiscountRule discountRuleForTheItem) {
		return item == discountRuleForTheItem.getItem() && itemQuantity >= discountRuleForTheItem.getItemQuantity();
	}
}