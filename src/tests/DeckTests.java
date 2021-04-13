package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Deck;

class DeckTests {

	@Test
	void shuffleTest() {
		Deck d1 = new Deck();
		Deck d2 = d1;
		int count = 0;
		d1.shuffle();
		for(int i =0; i<52; i++){
			if(d1.drawCard().compareToCard(d2.drawCard()) != 0 ){
				count=1;
			}
		}
		assertEquals(count,0);
	}
	
}
