package com.horsetrack2017.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	@Test
	public void containsNumberTest() {
		assertTrue(Util.containsNumber("w 5"));
		assertFalse(Util.containsNumber("q"));
	}
	
	@Test
	public void isNumberTest() {
		assertFalse(Util.isNumber("w 5"));
		assertTrue(Util.isNumber("5"));
	}
	
	@Test
	public void numberRangeTest() {
		assertTrue(Util.numberRange(7));
		assertFalse(Util.numberRange(8));
	}

}
