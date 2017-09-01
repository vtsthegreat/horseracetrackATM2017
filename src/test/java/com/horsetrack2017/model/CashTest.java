package com.horsetrack2017.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Suresh Thangavel
 *
 */
@SuppressWarnings("static-access")
public class CashTest {

	Cash cash = new Cash(10, 10, 10, 10, 10);

	@Test
	public void testReload() {
		cash.setFive(0);
		cash.setTen(2);
		cash.setTwenty(2);
		assertEquals(1070, cash.getTotalCashOnHand());
		cash.displayCurrencyInventory();
		cash.reload();
		assertEquals(1360, cash.getTotalCashOnHand());
		cash.displayCurrencyInventory();
	}

	@Test
	public void testTotalCashOnHand() {
		assertEquals(1360, cash.getTotalCashOnHand());
	}
}
