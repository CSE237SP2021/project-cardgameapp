package app;

public class War implements Game {

	private Deck deck;
	private Player playerAgent;

	public War(Player playerAgent) {
		this.playerAgent = playerAgent;
		this.deck = new Deck();
	}

	@Override
	public void initialize() {
		deck.shuffle();

	}

	@Override
	public int play() {
		// TODO Auto-generated method stub
		System.out.println("Starting game of War!");
		return 0;
	}

}
