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
	
}
