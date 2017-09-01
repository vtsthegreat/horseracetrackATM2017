package com.horsetrack2017.service;

import java.util.Map;

import com.horsetrack2017.model.Bet;
import com.horsetrack2017.model.Horse;

/**
 * @author Suresh Thangavel
 *
 */
public interface HorseService {
	public void displayHorses(Map<Integer, Horse> horses);

	@SuppressWarnings("rawtypes")
	public Map getHorses();

	public Integer getWinner();

	public void makeBet(Integer horse, Integer bet);

	public Bet retrieveBet();

	public void setWinner(Integer key);
}
