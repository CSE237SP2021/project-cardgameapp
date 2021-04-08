package app;

import java.util.Scanner;

public class GameMenu {

	private Scanner keyboardIn;
	private Player playerAgent;
	private Game currentGame;

	public GameMenu() {
		this.keyboardIn = new Scanner(System.in);
	}

	private void printWelcomeMessage() {
		System.out.println("###############################");
		System.out.println("###    The Card Game App    ###");
		System.out.println("###############################");
	}

	private void promptForUsername() {
		System.out.println("Please enter your username: ");
		String username = keyboardIn.nextLine();
		playerAgent = new Player(username);
	}

	private void promptForGame() {
		System.out.println("Please enter the number of the game you would like to play");
		System.out.println("1. Blackjack");
		System.out.println("2. War");
		String input = keyboardIn.nextLine();
		switch (input) {
		case "1":
			this.currentGame = new Blackjack(this.playerAgent);
			System.out.println("You selected to play Blackjack");
			break;
		case "2":
			this.currentGame = new War(this.playerAgent);
			System.out.println("You selected to play War");
			break;
		default:
			System.out.println("Game does not exist");
			break;
		}
	}

	public void run() {
		printWelcomeMessage();
		promptForUsername();
		promptForGame();
		currentGame.play();
	}

}
