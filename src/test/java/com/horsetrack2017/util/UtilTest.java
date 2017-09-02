package com.horsetrack2017.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {
	
	@Test
	public void isValidHorseNumberTest() {
		assertTrue(Util.isValidHorseNumber("2"));
		assertFalse(Util.isValidHorseNumber("8"));
	}
	@Test
	public void isValidQuitCommandTest() {
		assertTrue(Util.isValidQuitCommand("Q"));
		assertTrue(Util.isValidQuitCommand("q"));
		assertFalse(Util.isValidQuitCommand("2"));
		assertFalse(Util.isValidQuitCommand("a"));
	}
	@Test
	public void isValidReloadCommandTest() {
		assertTrue(Util.isValidReloadCommand("R"));
		assertTrue(Util.isValidReloadCommand("r"));
		assertFalse(Util.isValidReloadCommand("2"));
		assertFalse(Util.isValidReloadCommand("a"));
	}
	@Test
	public void isValidProcessCommandTest() {
		assertTrue(Util.isValidProcessCommand("W 3"));
		assertTrue(Util.isValidProcessCommand("3 50"));
		assertFalse(Util.isValidProcessCommand("10 50"));
		assertFalse(Util.isValidProcessCommand("W 8"));
		assertFalse(Util.isValidProcessCommand("hjasdghhjsakjf 4634"));
		assertFalse(Util.isValidProcessCommand("3113413 21341"));
	}
	@Test
	public void isNotValidHorseNumberTest() {
		assertTrue(Util.isNotValidHorseNumber("32524"));
		assertTrue(Util.isNotValidHorseNumber("W 352342"));
	}

}
