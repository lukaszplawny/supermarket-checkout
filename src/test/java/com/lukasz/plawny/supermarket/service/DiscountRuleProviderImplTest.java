package com.lukasz.plawny.supermarket.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lukasz.plawny.supermarket.dto.DiscountRule;
import com.lukasz.plawny.supermarket.dto.Item;
import com.lukasz.plawny.supermarket.service.DiscountRuleProvider;
import com.lukasz.plawny.supermarket.service.DiscountRuleProviderImpl;

public class DiscountRuleProviderImplTest {
	
	private static DiscountRuleProvider discountRuleProvider;
	
	@BeforeClass
	public static void createDiscountRuleProvider() {
		discountRuleProvider = new DiscountRuleProviderImpl();
	}

	@Test
	public void shouldReturnDiscountRuleForItem() {
		assertEquals(DiscountRule.BUY_3_ITEMS_A_GET_50_DISCOUNT, discountRuleProvider.findDiscountRule(Item.A));
		assertEquals(DiscountRule.BUY_2_ITEMS_B_GET_5_DISCOUNT, discountRuleProvider.findDiscountRule(Item.B));
	}

	@Test
	public void shouldReturnNullWhenThereIsNoDiscountRuleForItem() {
		assertNull(discountRuleProvider.findDiscountRule(Item.C));
		assertNull(discountRuleProvider.findDiscountRule(Item.D));
	}
}