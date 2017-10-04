package com.lukasz.plawny.supermarket.dto;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lukasz.plawny.supermarket.dto.DiscountRule;
import com.lukasz.plawny.supermarket.dto.Item;

public class DiscountRuleTest {

	@Test
	public void getDiscuntValue_ShouldReturnCorrectDiscountValue() {
		assertEquals(50, DiscountRule.BUY_3_ITEMS_A_GET_50_DISCOUNT.getDiscountValue());
		assertEquals(5, DiscountRule.BUY_2_ITEMS_B_GET_5_DISCOUNT.getDiscountValue());
	}

	@Test
	public void getItemQuantity_ShouldReturnItemQuantityEntitledToDiscountPrice() {
		assertEquals(3, DiscountRule.BUY_3_ITEMS_A_GET_50_DISCOUNT.getItemQuantity());
		assertEquals(2, DiscountRule.BUY_2_ITEMS_B_GET_5_DISCOUNT.getItemQuantity());
	}

	@Test
	public void getItem_ShouldReturnItemWithAvailableDiscount() {
		assertEquals(Item.A, DiscountRule.BUY_3_ITEMS_A_GET_50_DISCOUNT.getItem());
		assertEquals(Item.B, DiscountRule.BUY_2_ITEMS_B_GET_5_DISCOUNT.getItem());
	}
}
