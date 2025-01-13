package edu.byui.apj.week2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GuessGame {

    public static final int NUMBER_RANGE = 10;
    public final int secretNumber;

    public GuessGame() {
        Random rnd = new Random();
        this.secretNumber = rnd.nextInt(NUMBER_RANGE) + 1;
    }

    public void StartGame() {
        // Get Three Players
        String[] names = {"Player 1", "Player 2", "Player 3"};
        List<Player> players = Arrays.stream(names).map(Player::new).toList();

        // Run Game
        boolean notGuessed = true;
        while (notGuessed) {

            for (Player player : players) {
                int guess = player.GetGuess();
                System.out.printf("%s guessed %d which is %s%n", player.name, guess, guess == secretNumber ? "correct" : "incorrect");
                if (guess == secretNumber) notGuessed = false;
            }

            if (notGuessed) System.out.println("No player made a correct guess. Let's go again!\n");
        }
        System.out.println("We have our winner!\n");
    }
}