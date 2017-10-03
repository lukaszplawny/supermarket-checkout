package com.lukasz.plawny.supermarket.service;

import java.util.EnumSet;

import com.lukasz.plawny.supermarket.dto.DiscountRule;
import com.lukasz.plawny.supermarket.dto.Item;

public class DiscountRuleProviderImpl implements DiscountRuleProvider{
		
	public DiscountRule findDiscountRule(Item item){
		for (DiscountRule dr : EnumSet.allOf(DiscountRule.class)){
			if (dr.getItem().equals(item))
				return dr;
		}
		//there is no discount rule for the item
		return null;
	}
}