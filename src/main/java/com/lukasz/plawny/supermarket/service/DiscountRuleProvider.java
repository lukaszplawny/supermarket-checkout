package com.lukasz.plawny.supermarket.service;

import com.lukasz.plawny.supermarket.dto.DiscountRule;
import com.lukasz.plawny.supermarket.dto.Item;

public interface DiscountRuleProvider {

	public DiscountRule findDiscountRule(Item item);
}
