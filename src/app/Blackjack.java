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
		private int promptForPlayChoice() {
			// player can make a choice for hit 
		int currentBalance = playerAgent.getBalance();
				String choice = keyboardIn.nextLine();
		while(isValidInteger(amountAsString)) {
			System.out.println("That is not a string");
			choice = keyboardIn.nextLine();
		}
		if(choice == "hit"){
			hit = true; 

		}
		else if(choice == "double"){
			boolean doubling = true; 


		}
		else if(choice == "split"){
			boolean split = true; 


		}
		else{

		// player choice is stand by defalut 

		}

		System.out.println("You currently have " + currentBalance + " credits left in your balance. How much would like to bet?");
		
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
	public void HitorStand(){
		boolean hit; 
		// player chosses to either to ask for another card or hold current hand

		if(hit){
			Card hitcard = drawCard(); 
			playerAgent.player_score += hitcard.getRaank();
			playerAgent.hand[hand.length()] = hitcard;

		} 
		else{

		}

		return 0;
	}
	public boolean Bustwin(){

		if(playerAgent.player_score >21){

			return true;
		}
		else if(playerAgent.player_score == 21){

			return false;
			// display and log winner 
		}

		else{
			return false; 
		}
	}
	public void checkHand(){
		// run loop through the hand to get the players score from the hand 


	}


}
