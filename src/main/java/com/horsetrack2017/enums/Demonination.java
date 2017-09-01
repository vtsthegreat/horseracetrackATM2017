package com.horsetrack2017.enums;

/**
 * @author Suresh Thangavel
 *
 */
public enum Demonination {

	HUNDRED(100), TWENTY(20), TEN(10), FIVE(5), ONE(1);

	private int value;

	private Demonination(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
