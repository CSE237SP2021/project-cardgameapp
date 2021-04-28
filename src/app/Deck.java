package app;

public class Deck {
	public  int Score = 0; 

	private Card [] cards = new Card [52];
	private int topCard;

	public Deck() {
		int count = 0;
		for (int i = 0; i < 13; ++i) {
			for (int j = 0; j < 4; ++j ) {
				Card c = new Card(i, j);
				this.cards[count] = c;
				count++;
			}
		}
		this.topCard = 0;
	}

	public void shuffle() {
		int deckSize = this.cards.length;
		for (int i = 0; i<deckSize; i++) {
			int random = (int)(deckSize * Math.random());
			Card placeHolder = new Card(0,0);
			placeHolder = this.cards[i];
			this.cards[i]= this.cards[random];
			this.cards[random]=placeHolder;
		}
	}

	public Card drawCard() {
		if(this.topCard == this.cards.length) {
			shuffle();
			this.topCard = 0;
		}
		int nextCard = topCard;
		this.topCard++;
		return cards[nextCard];
	}


	public void print() {
		System.out.println("Your hand consists of: ");
		for (int i = 0; i < this.cards.length; ++i) {
			this.cards[i].print();
		}
	}
}
