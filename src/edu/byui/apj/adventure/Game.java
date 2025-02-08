package edu.byui.apj.adventure;

import edu.byui.apj.adventure.actions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Player player;
    private List<Action> actions;
    private static Game instance;
    private GameMap gameMap;

    /**
     * Private constructor which initializes the Game
     *
     */
    private Game() {
        initGame();
    }

    /**
     * Creates a singleton instance for the Game class if none exists.
     *
     * @return the Game instance
     */
    public static synchronized Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    /**
     * Starts the game that has already been initialized
     */
    public void start() {
        playGame();
    }

    /**
     * Initializes the game by initializing the game map and the player.
     * The player is placed at the location specified by the map, which is the middle tile of the game map.
     */
    private void initGame() {
        gameMap = new GameMap();

        player = new Player(gameMap);

        actions = new ArrayList<>();
        actions.addAll(Arrays.asList(
            new GetItemAction("G"),
            new InventoryAction("I"),
            new ShowMapAction("M"),
            new TravelNorthAction("N"),
            new TravelEastAction("E"),
            new TravelSouthAction("S"),
            new TravelWestAction("W"),
            new QuitAction("Q"),
            new InvalidAction(""),
            new UseItemAction("U")
        ));
    }

    /**
     * This contains the main loop for playing the game
     * A welcome message is displayed
     * The main loop
     * - checks the game state and prints out player status
     * - displays the user options
     * - awaits input then acts accordingly
     * When the winning item is in inventory, the game ends showing the
     * game won message.
     */
    private void playGame() {
        // The scanner is used to gather information from an input stream
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Show the game welcome message
        showWelcome();

        // Loop until the player has collected the winning item.
        while (!player.getInventory().contains(gameMap.getWinningItem())) {
            checkGameState();
            displayValidActions();
            moveAndAct(scanner);
        }

        // Show the game won message.
        showGameWon();
    }

    /**
     * Informs the user where they are currently located, what item is visible and
     * if any obstacles are preventing the item from being retrieved.
     */
    private void checkGameState() {
        System.out.println("============================");
        GameTile location = player.getLocation();
        System.out.println("You are currently in " + location.getTerrain());
        if (location.getItem() != null) {
            System.out.println("You see a " + location.getItem() + " here.");
        }
        if (location.getObstacle() != null) {
            System.out.println("You cannot get the " + location.getItem() + " because of the " + location.getObstacle());
        }
    }

    /**
     * Iterates over the list of valid actions and displays them to the user.
     */
    private void displayValidActions() {
        System.out.println("============================");
        System.out.println("Valid Actions are: ");
        // Display actions
        for (Action action : actions) {
            if (action.canDoAction(player)) {
                System.out.println(action.getActionDescription());
            }
        }
        System.out.println();
    }

    /**
     * Gets the player's next move from the console and
     * attempts to do the corresponding action.
     *
     * @param scanner
     */
    private void moveAndAct(Scanner scanner) {
        System.out.print("What is your move: ");
        String move = scanner.nextLine().toUpperCase();

        // Do Actions
        for (Action action : actions) {
            if (action.validKey(move)) {
                action.doAction(player);
            }
        }
    }

    /**
     * Shows the welcome message for the start of the game.
     */
    private void showWelcome() {
        System.out.println("Hale hardy adventurer. You seek the Amulet of Power! Let us begin your quest!");
        System.out.println();
    }

    /**
     * Shows the final message when the game is won.
     */
    private void showGameWon() {
        System.out.println("With the " + gameMap.getWinningItem() + " in your possession, you are ready to CONQUER THE WORLD!");
        System.out.println("Here is where your quest ends. Congratulations - victory is YOURS!");
    }
}
