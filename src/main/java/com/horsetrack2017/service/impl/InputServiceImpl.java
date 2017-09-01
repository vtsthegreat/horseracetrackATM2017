package com.horsetrack2017.service.impl;

import com.horsetrack2017.model.Cash;
import com.horsetrack2017.model.Horse;
import com.horsetrack2017.service.DispenseService;
import com.horsetrack2017.service.HorseService;
import com.horsetrack2017.service.InputService;
import com.horsetrack2017.service.OutputService;
import com.horsetrack2017.util.Util;

/**
 * @author Suresh Thangavel
 * 
 *		Input Format
 *		
 *		Blank input lines should be ignored.
 *		Valid commands are as follows:
 *		• 'R' or 'r' - restocks the cash inventory
 *		• 'Q' or 'q' - quits the application
 *		• 'W' or 'w' [1-7] - sets the winning horse number
 *		• [1-7] <amount> - specifies the horse wagered on and the amount of the bet
 *		
 *		If the user enters an improperly formatted command, then the program should display a single-line message with
 *		the following format:
 *		Invalid Command: <characters that were entered>
 *		
 *		If the user tries to specify a non-existent horse number, then the program should display a single-line message
 *		with the following format:
 *		Invalid Horse Number: <number that was entered>
 *		
 *		If the user enters the number of a horse that did not win, the program should display a single-line message with
 *		the following format:
 *		No Payout: <horse name>
 *		
 *		If the user enters an invalid bet amount, the program should display a single-line message with the following
 *		format:
 *		Invalid Bet: <amount>
 *		
 *		If the user enters a horse number that did win, the program should display a multi-line message with the following
 *		format:
 *		Payout: <horse name>,<total winnings>
 *		Dispensing:
 *		$1: <number of $1 bills>
 *		$5: <number of $5 bills>
 *		$10: <number of $10 bills>
 *		$20: <number of $20 bills>
 *		$100: <number of $100 bills>
 *		
 *		if the machine does not have enough cash on hand to make a complete and exact payout, the program
 *		should display a single-line message with the following format:
 *		Insufficient Funds: <payout amount>
 *		
 *		The machine inventory and list of horses (see next section) should be displayed immediately following any
 *		applicable message.
 * 
 */
public class InputServiceImpl implements InputService {

	HorseService horseService = new HorseServiceImpl();
	OutputService outputService = new OutputServiceImpl();
	DispenseService dispenseService = new DispenseServiceImpl();
	Cash cash = Cash.getCash();

	private void processCommandWithMultiInput(String input) {
		String in = input.split(" ")[0];
		// command start with a char
		if (Util.isNumber(in)) {
			Integer horseNumber = Integer.parseInt(in);
			// If the user tries to specify a non-existent horse number
			if (!Util.numberRange(horseNumber)) {
				outputService.displayAllMessages("Invalid Horse Number: " + horseNumber);
				return;
			}

			// [1-7] <amount> - specifies the horse wagered on and the amount of the bet
			if (input.length() > 1) {
				String bet = input.split(" ")[1];

				if (Util.isNumber((bet))) {
					horseService.makeBet(horseNumber, Integer.parseInt(bet));
				} else {
					// If the user enters an invalid bet amount
					outputService.displayAllMessages("Invalid Bet: " + input);
					return;
				}
			}
			Integer winnerKey = horseService.getWinner();
			Horse winner = (Horse) horseService.getHorses().get(winnerKey);
			if (winnerKey == horseNumber) {
				outputService.displayInventoryAndHorses();
				Integer theBet = horseService.retrieveBet().getBet();
				Integer theOdds = winner.getOdds();
				// If the user enters a horse number that did win
				StringBuilder sb = new StringBuilder("Payout: " + winner.getName() + ", $" + theOdds * theBet);

				String result = dispenseService.dispenseWinnings(theBet * theOdds);

				if (!result.isEmpty()) {
					outputService.displayMessage(sb.toString());
					outputService.displayMessage(result);
				} else {
					// if the machine does not have enough cash on hand to make a complete and exact
					// payout
					outputService.displayAllMessages("Insufficient Funds: " + theBet * theOdds);
				}
			} else {
				// If the user enters the number of a horse that did not win
				Horse loser = (Horse) horseService.getHorses().get(horseNumber);
				outputService.displayAllMessages("No Payout: " + loser.getName());
			}

		} else {
			// 'W' or 'w' [1-7] - sets the winning horse number
			Integer horseNumber = Integer.parseInt(input.split(" ")[1]);
			if (in.equalsIgnoreCase("w") && Util.numberRange(horseNumber)) {
				horseService.setWinner(Integer.parseInt(input.substring(1).trim()));
				outputService.displayInventoryAndHorses();
			} else {
				outputService.displayAllMessages("Invalid Command: " + input);
			}
		}
	}

	private void processCommandWithSingleInput(String input) {
		String in = input.split(" ")[0];
		switch (in) {
		case "Q":
		case "q": {// 'Q' or 'q' - quits the application
			System.exit(0);
			break;
		}
		case "R":
		case "r": {// 'R' or 'r' - restocks the cash inventory
			cash.reload();
			outputService.displayInventoryAndHorses();
			break;
		}
		default:
			outputService.displayAllMessages("Invalid Command: " + input);
		}
	}

	@Override
	public void processInput(String input) {
		int inputLength = input.trim().split(" ").length;

		if (inputLength == 0 || inputLength>2) {
			outputService.displayAllMessages("Invalid Command: " + input);
			return;
		}
		// single char not a number
		if (inputLength == 1 && !Util.containsNumber(input)) {
			processCommandWithSingleInput(input);
			return;
		}
		// There is a number in the input
		if (Util.containsNumber(input) && inputLength >= 1) {
			processCommandWithMultiInput(input);
		} else {
			outputService.displayAllMessages("Invalid Command: " + input);
		}
	}

}
