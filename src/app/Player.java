package app;

public class Player {

	private String username;
	private int balance;

	public Player(String username) {
		// Player starts with 100 in credit
		this.username = username;
		this.balance = 100;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}

	public String getUsername() {
		return this.username;
	}

	public int getBalance(){
		return this.balance;
	}
}
