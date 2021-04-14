package app;

import java.util.Scanner;

//import org.graalvm.compiler.nodes.NodeView.Default;

public class War implements Game {

	private Deck deck;
	private Player playerAgent;
	private Scanner keyboardIn;

	public War(Player playerAgent) {
		this.playerAgent = playerAgent;
		this.deck = new Deck();
		this.keyboardIn = new Scanner(System.in);
	}

	@Override
	public void initialize() {
		deck.shuffle();

	}

	@Override
	public int play() {
		System.out.println("Welcome to War"+ this.playerAgent.username+"!");
		boolean stillPlaying = true;
		while(stillPlaying){
			prompt();
			battle();
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
			//fill
		}else if(comparison == 0){
			//fill
		}else{
			//fill
		}
		
	}

}
