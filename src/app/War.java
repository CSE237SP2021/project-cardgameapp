package app;

import java.util.Scanner;

//import org.graalvm.compiler.nodes.NodeView.Default;

public class War implements Game {

	private Deck deck;
	private Player playerAgent;
	private int playerScore;
	private int compScore;
	private Scanner keyboardIn;

	public War(Player playerAgent) {
		this.playerAgent = playerAgent;
		this.deck = new Deck();
		this.keyboardIn = new Scanner(System.in);
		this.playerScore = 0; 
		this.compScore = 0;
	}

	@Override
	public void initialize() {
		deck.shuffle();

	}

	@Override
	public int play() {
		System.out.println("Welcome to War"+ this.playerAgent.username+"! If you win, you gain 10 credits and if you lose you, you lose 10 credits.");
		boolean stillPlaying = true;
		while(stillPlaying){
			prompt();
			battle();
			if(this.playerScore+this.compScore==26){
				stillPlaying=false;
				if(this.playerScore > this.compScore){
					System.out.println("You won the war! You win 10 credits.");
					this.playerAgent.deposit(10);
				}else if(this.playerScore < this.compScore){
					System.out.println("You lost the war! You lose 10 credits.");
					this.playerAgent.withdraw(10);
				}else{
					System.out.println("You tied the war! You keep your credits.");
				}
			}
		}
		return 0;
	}
	//Prompt the user to start next turn
	private void prompt(){
		System.out.println("Enter F to fight the next battle!");
		String input = keyboardIn.nextLine();
		switch(input){
			case "F":
				break;
			case "f":
				break;
			default:
				prompt();
				break;
		}
	}

	//
	private void battle(){
		Card c1=this.deck.drawCard();
		Card c2=this.deck.drawCard();
		System.out.println(this.playerAgent.username+" drew a "+ c1.getRank() +" of "+c1.getSuit());
		System.out.println("Computer drew a "+ c2.getRank() +" of "+c2.getSuit());
		int comparison = c1.compareToCard(c2);
		if(comparison == 1){
			System.out.println(this.playerAgent.username+" won this battle!");
			this.playerScore++;
		}else{
			System.out.println("Computer won this battle!");
			this.compScore++;
		}
		
	}

}
