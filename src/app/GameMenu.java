package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	private void readLeaderboard() {
		System.out.println();
		System.out.println("Here is a list of previous players and the balances they achieved:");
		 try {
		      File leaderboard = new File("theVault.txt");
		      Scanner myReader = new Scanner(leaderboard);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		System.out.println();
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
	
	private boolean promptUserQuit() {
		System.out.println("Would you like to exit the app? Enter the number of the option you would like to select.");
		System.out.println("1. Yes");
		System.out.println("2. No");
		String input = keyboardIn.nextLine();
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("Invalid input, please enter valid command");
			input = keyboardIn.nextLine();
		}
		switch (input) {
		case "1":
			System.out.println("Saving your balance. Goodbye.");
			try {
				playerAgent.saveBalance();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		case "2":
			System.out.println("Sounds good!");
			System.out.println();
			return true;
		default:
			promptUserQuit();
		}
		return true;
	}
	
	public void run() {
		boolean running = true;
		printWelcomeMessage();
		readLeaderboard();
		promptForUsername();
		while(running) {
			promptForGame();
			currentGame.play();
			running = promptUserQuit();
		}
	}

}
