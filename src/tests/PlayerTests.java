package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Player;

class PlayerTests {

	@Test
	void testPlayerInitialBalance() {
		Player p = new Player("Andrew");
		int balance = p.getBalance();
		assertEquals(balance, 100);
	}

	@Test
	void testPlayerDeposit(){
		Player p = new Player("Andrew");
		int amount = 100;
		p.deposit(amount);
		assertEquals(p.getBalance(), 200);
	}

	@Test 
	void testPlayerWithdraw(){
		Player p = new Player("Andrew");
		int amount = 100;
		p.withdraw(100);
		assertEquals(p.getBalance(), 0);
	}

	@Test  
	void testGetPlayersUsername(){
		Player p = new Player("Andrew");
		assertEquals(p.getUsername(), "Andrew");
	}
}
