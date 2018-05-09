package model;

import model.interfaces.DicePair;
import model.interfaces.Player;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.Locale;
//import java.util.logging.Logger;

/**
 * Created by dungbean on 31/3/18.
 */

public class SimplePlayer implements Player {
    //private Logger logger;
    private String ID;
    private String name;
    private int points;
    private int bets;
    private DicePair rollResults;
    private Collection<Player> players = new ArrayList<>();
    private Player house;

    //3 constructors

    public SimplePlayer() {
        players = new ArrayList<>();
        house = new SimplePlayer("HOUSE", 0);
    }

    public SimplePlayer(String ID, String name, int points) {
        this.ID = ID;
        this.name = name;
        this.points = points;
        this.bets = 0;
        this.rollResults = null;
    }

    public SimplePlayer(String name, int points) {
        this.name = "HOUSE";
        this.points = points;
        this.bets = 0;
        this.rollResults = null;
    }

    public String getPlayerName() {
        return this.name;
    }

    //playerName - human readable player name
    public void setPlayerName(String playerName) {
        playerName = name;
    }

    public int getPoints() {
        return this.points;
    }

    //points - for betting (updated by GameEngineImpl with each win or loss)
    public void setPoints(int points) {
       this.points = points;
    }

    //Returns: the player ID which is generated by the implementing class
    public String getPlayerId() {
        return this.ID;
    }

    //Returns: true if the player had sufficient points and the bet was placed
    public boolean placeBet (int bets) {
        if (bets > points || bets < 0) {
            return false;
        }
        points = points - bets;
        this.bets = bets;
        return true;
    }

    //Returns: the bet as set with placeBet()
    public int getBet() {
        return bets;
    }

    //Returns:a DicePair containing both dice values (updated from the GameEngine)
    public DicePair getRollResult() {
        return rollResults;
    }

    //rollResult - a DicePair containing both dice values (updated from the GameEngine)
    public void setRollResult(DicePair rollResult) {
        this.rollResults = rollResult;
    }

    //Returns: a human readable String that lists the values of this Player instance (see OutputTrace.txt)
    public String toString() {
		return ID;
    	
//        Formatter formatter = new Formatter(new StringBuilder(), Locale.US);
//        String display;
//        setPoints(100);
//        formatter.format("Player: id=%s, name=%s, points=%d", getPlayerId(), getPlayerName(), getPoints());
//        display = formatter.toString();
//        formatter.close();
//        return display;  
    }
}