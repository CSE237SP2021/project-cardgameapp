package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Player {

	public String username;
	private int player_score;
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
	
	public int getScore(){
		return this.player_score;
	}
	
	/**
	 * Writes user's balance to a text file named theVault.txt following the conclusion of a session
	 * @throws IOException
	 */
	public void saveBalance() throws IOException {
		File file1 = new File("theVault.txt");
		if(!file1.exists()) {
            file1.createNewFile();
         }	
		FileWriter fw = new FileWriter(file1.getName(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		String data = getUsername() + ": " + getBalance() + "\n";
		bw.write(data);
        bw.close();
	}
}
