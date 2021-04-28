package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.BlackJackHand;
import app.Card;
import java.util.*;

class BlackJackHandTests {

	@Test 
	void testGetHankValues() {
		BlackJackHand hand = new BlackJackHand();
		Card c1 = new Card("King", "Clubs");
		Card c2 = new Card("Ace", "Spades");
		hand.addCard(c1);
		hand.addCard(c2);
		Vector<Integer> values = hand.getHandValues();
		assertTrue(values.contains(21));
		assertTrue(values.contains(11));
	}
	
	@Test
	void testIsBust() {
		BlackJackHand hand = new BlackJackHand();
		Card c1 = new Card("King", "Clubs");
		Card c2 = new Card("Ace", "Spades");
		Card c3 = new Card("10", "Diamonds");
		hand.addCard(c1);
		hand.addCard(c2);
		hand.addCard(c3);
		assertTrue(hand.isBust());
	}
	
	@Test
	void testIsHit() {
		BlackJackHand hand = new BlackJackHand();
		Card c1 = new Card("King", "Clubs");
		Card c2 = new Card("Ace", "Spades");
		hand.addCard(c1);
		hand.addCard(c2);
		assertTrue(hand.isHit());
	}





}