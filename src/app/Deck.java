package app;

public class Deck {

	private Card [] cards = new Card [52];

	public Deck() {
		int count = 0;
		for (int i = 0; i < 13; ++i) {
			for (int j = 0; j < 4; ++j ) {
				Card c = new Card(i, j);
				this.cards[count] = c;
				count++;
			}
		}
	}

	public void shuffle() {
		// FIX ME
		int count = 0; 
		

	}

	public Card drawCard() {
		// FIX ME
		return new Card(0,0);
	}
	

	public void print() {
		for (int i = 0; i < this.cards.length; ++i) {
			this.cards[i].print();
		}
	}



}
