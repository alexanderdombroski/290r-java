package edu.byui.apj.week2;

import java.util.Random;

public class Player {

    public final String name;
    private final Random rnd = new Random();

    public Player(String name) {
        this.name = name;
    }

    public int GetGuess() {
        return rnd.nextInt(GuessGame.NUMBER_RANGE) + 1;
    }
}
