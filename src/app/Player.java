package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	public void saveBalance() throws IOException {
		File file1 = new File("theVault.txt");
		FileWriter fw = new FileWriter(file1);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(getUsername() + ": " + getBalance());
		pw.close();
	}
	
}
