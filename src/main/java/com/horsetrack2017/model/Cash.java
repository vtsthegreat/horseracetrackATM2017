package com.horsetrack2017.model;

/**
 * @author Suresh Thangavel
 *
 */
@SuppressWarnings("static-access")
public class Cash {

	private static int one;
	private static int five;
	private static int ten;
	private static int twenty;
	private static int hundred;

	public static Cash cash = new Cash(10, 10, 10, 10, 10);

	public static Cash getCash() {
		return cash;
	}

	public Cash(int one, int five, int ten, int twenty, int hundred) {
		Cash.one = one;
		Cash.five = five;
		Cash.ten = ten;
		Cash.twenty = twenty;
		Cash.hundred = hundred;
	}

	public void displayCurrencyInventory() {
		StringBuilder sb = new StringBuilder();
		sb.append("Inventory:\n");
		sb.append("$1,");
		sb.append(getOne());
		sb.append("\n");
		sb.append("$5,");
		sb.append(getFive());
		sb.append("\n");
		sb.append("$10 ");
		sb.append(getTen());
		sb.append("\n");
		sb.append("$20,");
		sb.append(getTwenty());
		sb.append("\n");
		sb.append("$100,");
		sb.append(getHundred());
		sb.append("\n");
		System.out.println(sb.toString().trim());
	}

	public int getFive() {
		return five;
	}

	public int getHundred() {
		return hundred;
	}

	public int getOne() {
		return one;
	}

	public int getTen() {
		return ten;
	}

	public int getTotalCashOnHand() {
		return (one * 1) + (five * 5) + (ten * 10) + (twenty * 20) + (hundred * 100);
	}

	public int getTwenty() {
		return twenty;
	}

	public void reload() {
		one = five = ten = twenty = hundred = 10;
	}

	public void setFive(int five) {
		Cash.five = five;
	}

	public void setHundred(int hundred) {
		Cash.hundred = hundred;
	}

	public void setOne(int one) {
		Cash.one = one;
	}

	public void setTen(int ten) {
		Cash.ten = ten;
	}

	public void setTwenty(int twenty) {
		Cash.twenty = twenty;
	}

}
