package com.lukasz.plawny.supermarket.dto;
import static org.junit.Assert.*;

import org.junit.Test;

import com.lukasz.plawny.supermarket.dto.Item;

public class ItemTest {

	@Test
	public void shouldReturnCorrectItemPrice() {
		assertEquals(40, Item.A.getUnitPrice());
		assertEquals(10, Item.B.getUnitPrice());
		assertEquals(30, Item.C.getUnitPrice());
		assertEquals(25, Item.D.getUnitPrice());
	}

}