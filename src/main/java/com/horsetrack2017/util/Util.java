package com.horsetrack2017.util;

public class Util {

	public static boolean containsNumber(String input) {
		return input.matches(".*\\d+.*");
	}

	public static boolean isNumber(String str) {
		return str.matches("\\d+");
	}

	public static boolean numberRange(Integer horseNumber) {
		return horseNumber >= 1 && horseNumber <= 7 ? true : false;
	}
}