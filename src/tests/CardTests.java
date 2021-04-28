package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Card;

class CardTests {



	@Test 
	void getCardRankAndSuitTests() {
		Card c = new Card(0,2);
		int rank = c.getRank();
		int suit = c.getSuit();
		assertEquals(rank, 0);
		assertEquals(suit, 2);
	}

	@Test 
	void getCardRankAndSuitUsingStringConstructor() {
		Card c = new Card("King", "Clubs");
		int rank = c.getRank();
		int suit = c.getSuit();
		assertEquals(rank, 11);
		assertEquals(suit, 0);
	}

	@Test
	void compareToCardWithLowerRank() {
		Card c1 = new Card(5,1);
		Card c2 = new Card(3,2);
		int comparison = c1.compareToCard(c2);
		assertEquals(comparison, 1);
	}

	@Test
	void compareToCardWithHigherRank() {
		Card c1 = new Card(3,2);
		Card c2 = new Card(5,1);
		int comparison = c1.compareToCard(c2);
		assertEquals(comparison, -1);
	}

	@Test 
	void compareToCardWithSameRankButLowerSuit(){
		Card c1 = new Card(12,3);
		Card c2 = new Card(12,2);
		int comparison = c1.compareToCard(c2);
		assertEquals(comparison, 1);
	}

	@Test 
	void compareToCardWithSameRankButHigherSuit() {
		Card c1 = new Card(12,1);
		Card c2 = new Card(12,2);
		int comparison = c1.compareToCard(c2);
		assertEquals(comparison, -1);
	}

	@Test
	void compareEqualCards() {
		Card c1 = new Card(12,2);
		Card c2 = new Card(12,2);
		int comparison = c1.compareToCard(c2);
		assertEquals(comparison, 0);
	}

}
