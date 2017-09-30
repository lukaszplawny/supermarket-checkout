package com.lukasz.plawny.supermarket.service;

import java.util.EnumSet;

import com.lukasz.plawny.supermarket.data.DiscountRule;
import com.lukasz.plawny.supermarket.data.Item;

public class DiscountRuleProviderImpl implements DiscountRuleProvider{
		
	public DiscountRule findDiscountRule(Item item){
		for (DiscountRule dr : EnumSet.allOf(DiscountRule.class)){
			if (dr.getItem().equals(item))
				return dr;
		}
		return null;
	}
}