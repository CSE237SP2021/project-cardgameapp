package app;

import java.util.*;

public class BlackJackHand {

	private Vector<Card> cards;

	public BlackJackHand() {
		this.cards = new Vector<Card>();
	}

	public void addCard(Card c) {
		cards.add(c);
	}
	
	/**
	 * @return value that is closest to 21 which does does not exceed 21
	 */
	public int getBestValue() {
		int bestValue = 0;
		Vector<Integer> values = getHandValues();
		for (int i = 0; i < values.size(); ++i) {
			int value = values.get(i);
			if (value > bestValue && value <= 21) {
				bestValue = value;
			}
		}
		return bestValue;
	}

	/**
	 * Hand is a hit if its cards combine in some way to make 21
	 * @return boolean indicating whether hand is a hit or not
	 */
	public boolean isHit() {
		Vector<Integer> potentialValues = getHandValues();
		
		for (int i = 0; i < potentialValues.size(); ++i) {
			int value = potentialValues.get(i);
			if (value == 21) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Hand is a bust if its card's sum exceeds 21 in all combinations
	 * @return boolean indicating whether hand is a bust or not
	 */
	public boolean isBust() {
		Vector<Integer> potentialValues = getHandValues();
		for (int i = 0; i < potentialValues.size(); ++i) {
			int value = potentialValues.get(i);
			if (value <= 21) {
				return false;
			}
		}
		return true;
	}


	public Vector<Integer> getHandValues() {

		Vector<Integer> values = new Vector<Integer>();

		int nonAceValue = 0;
		int numAces = 0;

		for (int i = 0; i <this.cards.size(); ++i) {
			Card c = this.cards.get(i);
			String rank = c.getRankAsString();
			if (rank.equals("Ace")) {
				++numAces;
			}  
			else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
				nonAceValue += 10;
			} 
			else {
				nonAceValue += Integer.parseInt(rank);
			}
		}

		int [] potentialAceValues = getPotentialAceValues(numAces);
		
		for (int j = 0; j < potentialAceValues.length; ++j) {
			int value = potentialAceValues[j];
			values.add(nonAceValue + value);
		}

		return values;
	}
	

	private int [] getPotentialAceValues(int numAces) {
		switch (numAces) {
		case 0:
			int [] none = {0};
			return none;
		case 1: 
			int [] oneAceValues = {1, 11};
			return oneAceValues;
		case 2:
			int [] twoAcesValues = {2, 12, 22};
			return twoAcesValues;
		case 3:
			int [] threeAcesValues = {3, 13, 23, 33};
			return threeAcesValues;
		case 4:
			int [] fourAcesValues = {4, 14, 24, 34, 55};
			return fourAcesValues;
		default:
			return new int [0];
		}

	}
	
	public void printAsDealerHand() {
		Card firstCard = this.cards.get(0);
		firstCard.print();
		System.out.println("Second Cards is Hidden");
	}

	public void print() {
		for(int i = 0; i < this.cards.size(); ++i) {
			Card c = this.cards.get(i);
			c.print();
		}
	}

}
