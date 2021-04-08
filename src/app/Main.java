package app;

public class Main {

	public static void main(String[] args) {
		//		Card c = new Card(2, 3);
		//		Card c2 = new Card(2, 2);
		//		int comparison = c.compareToCard(c2);
		//		c.print();
		//		c2.print();
		//		System.out.println("Comparison: " + comparison);
		//		Deck d = new Deck();
		//		d.print();
		//		d.shuffle();
		//		d.print();
		//		for (int i = 0; i < 100; ++i) {
		//			Card drawnCard = d.drawCard();
		//			drawnCard.print();
		//		}
		
		
//		Player p = new Player();
//		int balance = p.getBalance();
//		System.out.println(balance);
//		p.deposit(100);
//		balance = p.getBalance();
//		System.out.println(balance);
		
		GameMenu g = new GameMenu();
		g.run();
	}

}
