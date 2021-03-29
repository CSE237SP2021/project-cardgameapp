package app;

public class Deck {

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
		topCard = 0;
	}

	public void shuffle() {
		// FIX ME
		int deckSize = this.cards.length;
		for (int i = 0; i<deckSize; i++) {
			int random = (int)(deckSize *Math.random());
			Card placeHolder = new Card(0,0);
			placeHolder = this.cards[i];
			this.cards[i]= this.cards[random];
			this.cards[random]=placeHolder;
		}
		//after shuffling, reset the next card to be drawn to be at the top
		topCard = 0;
	}

	public Card drawCard() {
		//Shuffle if the deck is empty
		if(topCard == this.cards.length) {
			shuffle();
		}
		int nextCard = topCard;
		topCard++;
		return cards[nextCard];
	}
	

	public void print() {
		for (int i = 0; i < this.cards.length; ++i) {
			this.cards[i].print();
		}
	}



}
