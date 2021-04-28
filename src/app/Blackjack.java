package app;

import java.util.Scanner;

public class Blackjack implements Game {

	private Scanner keyboardIn;
	private Deck deck;
	private Player playerAgent;
	private BlackJackHand dealerHand;
	private BlackJackHand playerHand;
	private boolean playersTurn;

	public Blackjack(Player playerAgent) {
		this.keyboardIn = new Scanner(System.in);
		this.playerAgent = playerAgent;
		this.deck = new Deck();
		this.dealerHand = new BlackJackHand();
		this.playerHand = new BlackJackHand();
		this.playersTurn = true;
	}

	@Override
	public void initialize() {
		this.deck = new Deck();
		this.deck.shuffle();
		this.playerHand = new BlackJackHand();
		this.dealerHand = new BlackJackHand();
		this.playersTurn = true;

		System.out.println();
		System.out.println("Dealing Cards...");

		dealPlayerAgentCards();
		dealDealerCards();

		System.out.println();
		System.out.println("Dealer's Hand: ");
		this.dealerHand.printAsDealerHand();

		System.out.println();
		System.out.println("Your Hand:");
		this.playerHand.print();

	}

	/**
	 * Deals two cards to player agent
	 */
	private void dealPlayerAgentCards() {
		Card firstCard = this.deck.drawCard();
		Card secondCard = this.deck.drawCard();
		this.playerHand.addCard(firstCard);
		this.playerHand.addCard(secondCard);
	}

	/**
	 * Deals two cards to dealer agent
	 */
	private void dealDealerCards() {
		Card firstCard = this.deck.drawCard();
		Card secondCard = this.deck.drawCard();
		this.dealerHand.addCard(firstCard);
		this.dealerHand.addCard(secondCard);
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

	/**
	 * Prompts players for amount they would like to wager each hand
	 * @return amount being wagered
	 */
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


	/**
	 * Prompts user for the move they would like to make each hand
	 */
	private void promptForPlayerMove() {
		System.out.println("Enter the number of the move you would like to make:");
		System.out.println("1. Hit");
		System.out.println("2. Stand");
		String input = keyboardIn.nextLine();
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("Invalid input, please enter valid command");
			input = keyboardIn.nextLine();
		}
		switch (input) {
		case "1":
			handleHit();
			break;
		case "2":
			handleStand();
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}
	}

	private void handleHit() {
		Card newCard = this.deck.drawCard();
		this.playerHand.addCard(newCard);
		System.out.println();
		System.out.println("Your Hand:");
		this.playerHand.print();
	}

	private void handleStand() {
		int bestValue = this.playerHand.getBestValue();
		System.out.println("Your cards totaled to: " + bestValue);
		this.playersTurn = false;
	}

	private void handleDealerHand() {
		System.out.println();
		System.out.println("Dealers Hand: ");
		this.dealerHand.print();
		System.out.println();
		while(this.dealerHand.getBestValue() < 17 && !this.dealerHand.isBust()) {
			System.out.println("Dealer Hits ...");
			Card newCard = this.deck.drawCard();
			this.dealerHand.addCard(newCard);
			this.dealerHand.print();
			System.out.println();
		}
	}

	/**
	 * Updates users balance based on the outcome of the round of blackjack
	 * @param betAmount
	 */
	private void handleGameOutcome(int betAmount) {
		int playerScore = this.playerHand.getBestValue();
		int dealerScore = this.dealerHand.getBestValue();
		if (playerScore > dealerScore) {
			this.playerAgent.deposit(2 * betAmount);
			System.out.println("You win!");
			System.out.println();
		}
		else if (dealerScore > playerScore) {
			System.out.println("The Dealer Wins :(");
			System.out.println();
		} else {
			this.playerAgent.deposit(betAmount);
			System.out.println("Its a tie.");
			System.out.println();
		}
	}

	private boolean promptToKeepPlaying() {
		System.out.println("Would you like to play another hand? Enter the number of the option you would like to select.");
		System.out.println("1. Yes");
		System.out.println("2. No");
		String input = keyboardIn.nextLine();
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("Invalid input, please enter valid command");
			input = keyboardIn.nextLine();
		}
		switch (input) {
		case "1":
			System.out.println("Sounds good! Lets play some more.");
			System.out.println();
			return true;
		case "2":
			System.out.println("Thanks for playing! Goodbye");
			System.out.println();
			return false;
		default:
			return true;
		}
	}

	@Override
	public int play() {
		System.out.println("Starting game of Blackjack!");
		boolean stillPlayingPoker = true;
		while (stillPlayingPoker) {

			int betAmount = promptForBetAmount();
			boolean currentHandIsLive = true;
			initialize();

			while (currentHandIsLive) {
				if (this.playerHand.isBust() || this.playerHand.isHit() || this.playersTurn == false) {
					currentHandIsLive = false;
				} else {
					System.out.println();
					promptForPlayerMove();
				}
			}	

			if (this.playerHand.isBust()) {
				System.out.println();
				System.out.println("You lose!");
				System.out.println();
			}
			else {
				handleDealerHand();
				handleGameOutcome(betAmount);
			}
			stillPlayingPoker = promptToKeepPlaying();
		}
		return 0;
	}



}
