package com.horsetrack2017.util;

public class Util {
	public static Boolean isValidHorseNumber(String value) {
		return value.matches("^[1-7]$");
	}
	
	public static Boolean isValidQuitCommand(String input) {
		return input.matches("^[Qq]$");
	}
	
	public static Boolean isValidReloadCommand(String input) {
		return input.matches("^[Rr]$");
	}
	
	public static Boolean isValidProcessCommand(String input) {
		return input.matches("^[1-7]{1}[\" \"][0-9]+") || input.matches("^[Ww]{1}[\" \"][1-7]+") || input.matches("^[1-7]$");
	}
	
	public static Boolean isNotValidHorseNumber(String input) {
		return input.matches("\\d+") || input.matches("^[Ww]{1}[\" \"][0-9]+");
	}
	
}