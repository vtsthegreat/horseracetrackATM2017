package com.horsetrack2017;

import java.util.Scanner;

import com.horsetrack2017.service.InputService;
import com.horsetrack2017.service.OutputService;
import com.horsetrack2017.service.impl.InputServiceImpl;
import com.horsetrack2017.service.impl.OutputServiceImpl;

/**
 * @author Suresh Thangavel It has two responsibilities: 1. To allow a park
 *         employee to set the number of the winning horse. 2. To allow patrons
 *         to determine if the horse they have already bet on won, and then
 *         collect their winnings if it did.
 */
public class HorseRaceTrackATM {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		OutputService outputService = new OutputServiceImpl();
		outputService.displayInventoryAndHorses();

		InputService inputService = new InputServiceImpl();
		Scanner console = new Scanner(System.in);

		do {
			inputService.processInput(console.nextLine());
		} while (true);
	}
}
