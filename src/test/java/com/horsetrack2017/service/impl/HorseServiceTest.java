package com.horsetrack2017.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.horsetrack2017.model.Horse;
import com.horsetrack2017.service.HorseService;

/**
 * @author Suresh Thangavel
 *
 */
@SuppressWarnings("unchecked")
public class HorseServiceTest {

	private HorseService service = new HorseServiceImpl();

	@Test
	public void setBet() {
		// check default
		assertTrue(service.retrieveBet().getHorse() == 0);

		service.makeBet(4, 40);
		assertTrue(service.retrieveBet().getHorse() == 4);
		assertTrue(service.retrieveBet().getBet() == 40);
	}

	@Test
	public void setWinner() {
		// check default state
		Map<Integer, Horse> horses = service.getHorses();
		assertTrue(horses.get(1).isWon());
		service.setWinner(4);
		assertFalse(horses.get(1).isWon());
		assertTrue(horses.get(4).isWon());
	}
}
