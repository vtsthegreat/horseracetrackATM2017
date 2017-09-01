package com.horsetrack2017.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.horsetrack2017.model.Bet;
import com.horsetrack2017.model.Horse;
import com.horsetrack2017.service.HorseService;

/**
 * @author Suresh Thangavel
 *
 */
public class HorseServiceImpl implements HorseService {

	private static Map<Integer, Horse> horses = new HashMap<Integer, Horse>();
	static {
		horses.put(1, new Horse("That Darn Gray Cat", 5, Boolean.TRUE));
		horses.put(2, new Horse("Fort Utopia", 10, Boolean.FALSE));
		horses.put(3, new Horse("Count Sheep", 9, Boolean.FALSE));
		horses.put(4, new Horse("Ms Traitour", 4, Boolean.FALSE));
		horses.put(5, new Horse("Real Princess", 3, Boolean.FALSE));
		horses.put(6, new Horse("Pa Kettle", 5, Boolean.FALSE));
		horses.put(7, new Horse("Gin Stinger", 6, Boolean.FALSE));
	}

	private static Bet theBet = new Bet(0, 0);

	@Override
	public void displayHorses(Map<Integer, Horse> horses) {
		StringBuilder sb = new StringBuilder();
		sb.append("Horses:\n");

		for (Map.Entry<Integer, Horse> horse : horses.entrySet()) {
			sb.append(horse.getKey());
			sb.append(", ");
			sb.append(horse.getValue().getName());
			sb.append(", ");
			sb.append(horse.getValue().getOdds());
			sb.append(", ");
			sb.append(horse.getValue().isWon() ? "Won\n" : "Lost\n");

		}
		System.out.println(sb.toString().trim());
	}

	@Override
	public Map<Integer, Horse> getHorses() {
		return horses;
	}

	@Override
	public Integer getWinner() {
		for (Map.Entry<Integer, Horse> horse : horses.entrySet()) {
			if (horse.getValue().isWon()) {
				return horse.getKey();
			}
		}
		return null;
	}

	@Override
	public void makeBet(Integer horse, Integer bet) {
		theBet.setHorse(horse);
		theBet.setBet(bet);
	}

	@Override
	public Bet retrieveBet() {
		return theBet;
	}

	@Override
	public void setWinner(Integer key) {
		for (Map.Entry<Integer, Horse> horse : horses.entrySet()) {
			horse.getValue().setWon(Boolean.FALSE);
			if (horse.getKey() == key) {
				horse.getValue().setWon(Boolean.TRUE);
			}
		}
	}
}
