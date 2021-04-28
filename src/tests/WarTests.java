package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.War;

import app.Player;

public class WarTests {
    void testGameOver(){
        Player p1 = new Player("user");
        War war = new War(p1);
        war.setCompScore(2);
        war.setPlayerScore(5);
        boolean a = war.stillPlaying();
        assertEquals(a, false);
    }
    void testGameNotOver(){
        Player p1 = new Player("user");
        War war = new War(p1);
        war.setCompScore(13);
        war.setPlayerScore(13);
        boolean a = war.stillPlaying();
        assertEquals(a, true);
    }

    void testCheckBalanceTie(){
        Player p1 = new Player("user");
        int bal = p1.getBalance();
        War war = new War(p1);
        war.setCompScore(13);
        war.setPlayerScore(13);
        boolean a = war.stillPlaying();
        assertEquals(p1.getBalance(), bal);
    }

    void testCheckBalanceWin(){
        Player p1 = new Player("user");
        int bal = p1.getBalance();
        War war = new War(p1);
        war.setCompScore(12);
        war.setPlayerScore(14);
        boolean a = war.stillPlaying();
        assertEquals(p1.getBalance(), bal+10);
    }

    void testCheckBalanceLose(){
        Player p1 = new Player("user");
        int bal = p1.getBalance();
        War war = new War(p1);
        war.setCompScore(14);
        war.setPlayerScore(12);
        boolean a = war.stillPlaying();
        assertEquals(p1.getBalance(), bal-10);
    }
}
