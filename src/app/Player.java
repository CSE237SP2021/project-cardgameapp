package app;

public class Player {

	public String username;
	private int player_score;
	private int balance;
	private Card [] hand; 

	public Player(String username) {
		// Player starts with 100 in credit
		this.username = username;
		this.balance = 100;
		this.player_score = player_score;
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
	public int getScore(){
		return this.player_score;
	}
}
