package com.horsetrack2017.service.impl;

import com.horsetrack2017.model.Cash;
import com.horsetrack2017.service.HorseService;
import com.horsetrack2017.service.OutputService;

/**
 * @author Suresh Thangavel
 * 
 *		Output Format
 *		
 *		All output should be written to the standard output stream.
 *		
 *		At program startup, and following the processing of
 *		every command, the machine inventory and the horse list should be displayed. Both the inventory and horse lists
 *		should be ordered as shown above
 *		Inventory:
 *		<denomination>,<quantity in inventory>
 *		...
 *		<denomination>,<quantity in inventory>
 *		Menu:
 *		<horse number>,<horse name>,<odds>,<did-win>
 *		...
 *		<horse number>,<horse name>,<odds>,<did-win>
 *		The <did-win> indicator should be either "won" or "lost".
 * 
 */
public class OutputServiceImpl implements OutputService {

	Cash cash = Cash.getCash();
	HorseService horseService = new HorseServiceImpl();

	@Override
	public void displayAllMessages(String msg) {
		System.out.println(msg);
		displayInventoryAndHorses();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void displayHorses() {
		horseService.displayHorses(horseService.getHorses());
	}

	@Override
	public void displayInventory() {
		cash.displayCurrencyInventory();
	}

	@Override
	public void displayInventoryAndHorses() {
		displayInventory();
		displayHorses();
	}

	@Override
	public void displayMessage(String msg) {
		System.out.println(msg);
	}

}
