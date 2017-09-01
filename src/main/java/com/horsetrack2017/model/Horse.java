package com.horsetrack2017.model;

/**
 * @author Suresh Thangavel
 *
 */
public class Horse {

	private String name;
	private int odds;
	private Boolean won;

	public Horse() {
	}

	public Horse(String name, int odds, Boolean won) {
		this.name = name;
		this.odds = odds;
		this.won = won;
	}

	public String getName() {
		return name;
	}

	public int getOdds() {
		return odds;
	}

	public Boolean isWon() {
		return won;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOdds(int odds) {
		this.odds = odds;
	}

	public void setWon(Boolean won) {
		this.won = won;
	}
}
