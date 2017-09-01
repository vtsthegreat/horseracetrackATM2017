package com.horsetrack2017.model;

/**
 * @author Suresh Thangavel
 *
 */
public class Bet {

	private Integer horse;
	private Integer bet;

	public Bet(Integer horse, Integer bet) {
		this.horse = horse;
		this.bet = bet;
	}

	public Integer getBet() {
		return bet;
	}

	public Integer getHorse() {
		return horse;
	}

	public void setBet(Integer bet) {
		this.bet = bet;
	}

	public void setHorse(Integer horse) {
		this.horse = horse;
	}

	@Override
	public String toString() {
		String str = ("Horse: " + horse + " Bet: " + bet);
		return str;
	}

}
