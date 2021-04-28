package app;

public class Card {

	String [] suits= {
			"Clubs", "Diamonds", "Hearts" , "Spades"
	};

	String [] ranks = {
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
	};

	private int rank;
	private int suit;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Card(String rank, String suit) {
		for (int i = 0; i < suits.length; ++i) {
			if (suits[i].equals(suit)) {
				this.suit = i;
			}
		}
		for (int j = 0; j < ranks.length; ++j) {
			if (ranks[j].equals(rank)) {
				this.rank = j;
			}
		}
	}

	public int getRank() {
		return this.rank;

	}
	
	public String getRankAsString() {
		return ranks[this.rank];
	}

	public int getSuit() {
		return this.suit;
	}
	
	public String getSuitAsString() {
		return suits[this.suit];
	}

	/**
	 * @param c Card which is being compared to current card
	 * @return -1 if Card is worse than opponent, 0 if Card is equal to opponent, 1 if Card is better than opponent
	 */
	public int compareToCard(Card c) {

		int otherCardRank = c.getRank();
		int otherCardSuit = c.getSuit();

		if (this.rank > otherCardRank) {
			return 1;
		} else if (this.rank < otherCardRank) {
			return -1;
		} else if (this.rank == otherCardRank && this.suit > otherCardSuit) {
			return 1;
		} else if (this.rank == otherCardRank && this.suit < otherCardSuit) {
			return -1;
		} else {
			return 0;
		}

	}

	public void print() {
		System.out.println(ranks[this.rank] + " of " + suits[this.suit]);
	}

}
