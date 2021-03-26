package app;

public class Main {

	public static void main(String[] args) {
		Card c = new Card(2, 3);
		Card c2 = new Card(2, 2);
		int comparison = c.compareToCard(c2);
		c.print();
		c2.print();
		System.out.println("Comparison: " + comparison);
		Deck d = new Deck();
		d.print();
	}

}
