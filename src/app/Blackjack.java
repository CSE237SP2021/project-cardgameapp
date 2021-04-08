package app;

import java.util.Scanner;

public class Blackjack implements Game {

	private Scanner keyboardIn;
	private Deck deck;
	private Player playerAgent;

	public Blackjack(Player playerAgent) {
		this.keyboardIn = new Scanner(System.in);
		this.playerAgent = playerAgent;
		this.deck = new Deck();
	}

	@Override
	public void initialize() {
		deck.shuffle();
	}

	private boolean isValidInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException nfe){
			return false;
		}
	}

	private int promptForBetAmount() {
		int currentBalance = playerAgent.getBalance();
		System.out.println("You currently have " + currentBalance + " credits left in your balance. How much would like to bet?");
		String amountAsString = keyboardIn.nextLine();
		while(!isValidInteger(amountAsString)) {
			System.out.println("That is not a number");
			amountAsString = keyboardIn.nextLine();
		}
		int amount =  Integer.parseInt(amountAsString);
		playerAgent.withdraw(amount);
		return amount;
	}

	@Override
	public int play() {
		// TODO Auto-generated method stub
		System.out.println("Starting game of Blackjack!");
		while (true) {
			int amount = promptForBetAmount();
			System.out.println("You are trying to bet " + amount);
			if (amount == 0) {
				break;
			}
		}
		return 0;
	}


}
