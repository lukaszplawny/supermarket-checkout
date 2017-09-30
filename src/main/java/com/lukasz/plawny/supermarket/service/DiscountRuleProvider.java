package com.lukasz.plawny.supermarket.service;

import com.lukasz.plawny.supermarket.data.DiscountRule;
import com.lukasz.plawny.supermarket.data.Item;

public interface DiscountRuleProvider {

	public DiscountRule findDiscountRule(Item item);
}
