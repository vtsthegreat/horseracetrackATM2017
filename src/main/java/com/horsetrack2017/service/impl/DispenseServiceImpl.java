package com.horsetrack2017.service.impl;

import com.horsetrack2017.enums.Demonination;
import com.horsetrack2017.model.Cash;
import com.horsetrack2017.service.DispenseService;
import com.horsetrack2017.service.OutputService;

/**
 * @author Suresh Thangavel
 *
 */
public class DispenseServiceImpl implements DispenseService {

	private static int balance;
	private static int payout;
	OutputService outputService = new OutputServiceImpl();
	Cash cash = Cash.getCash();

	private boolean adjustInventory(int hundred, int twenty, int ten, int five, int one) {
		int oldHundred = cash.getHundred();
		int oldTwenty = cash.getTwenty();
		int oldTen = cash.getTen();
		int oldFive = cash.getFive();
		int oldOne = cash.getOne();

		boolean success = true;

		if (cash.getHundred() >= hundred) {
			cash.setHundred(cash.getHundred() - hundred);
		} else {
			success = false;
		}
		if (cash.getTwenty() >= twenty) {
			cash.setTwenty(cash.getTwenty() - twenty);
		} else {
			success = false;
		}
		if (cash.getTen() >= ten) {
			cash.setTen(cash.getTen() - ten);
		} else {
			success = false;
		}
		if (cash.getFive() >= five) {
			cash.setFive(cash.getFive() - five);
		} else {
			success = false;
		}
		if (cash.getOne() >= one) {
			cash.setOne(cash.getOne() - one);
		} else {
			success = false;
		}

		if (success == false) {
			cash.setHundred(oldHundred);
			cash.setTwenty(oldTwenty);
			cash.setTen(oldTen);
			cash.setFive(oldFive);
			cash.setOne(oldOne);
		}
		return success;
	}

	@Override
	public String dispenseWinnings(Integer thePayout) {

		balance = cash.getTotalCashOnHand();
		payout = thePayout;

		if (payout > balance) {
			outputService.displayAllMessages("Insufficient Funds: " + payout);
			return "";
		}
		// This should be a recursive function but this will work for now
		int hundred = makeChange(Demonination.HUNDRED.getValue());
		int twenty = makeChange(Demonination.TWENTY.getValue());
		int ten = makeChange(Demonination.TEN.getValue());
		int five = makeChange(Demonination.FIVE.getValue());
		int one = makeChange(Demonination.ONE.getValue());

		if (!adjustInventory(hundred, twenty, ten, five, one)) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Dispensing:\n");
		sb.append("$1,");
		sb.append(one);
		sb.append("\n");
		sb.append("$5,");
		sb.append(five);
		sb.append("\n");
		sb.append("$10,");
		sb.append(ten);
		sb.append("\n");
		sb.append("$20,");
		sb.append(twenty);
		sb.append("\n");
		sb.append("$100,");
		sb.append(hundred);
		return sb.toString();
	}

	private int makeChange(int currency) {
		int result = payout / currency;
		balance -= result * currency;
		payout -= result * currency;
		return result;
	}
}
