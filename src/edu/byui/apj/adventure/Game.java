package edu.byui.apj.adventure;

import edu.byui.apj.adventure.actions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private Player player;
    private List<Action> actions;

    /**
     * Starts the game by initializing the game, then playing the game
     */
    public void start() {
        initGame();
        playGame();
    }

    /**
     * Initializes the game by initializing the game map and the player.
     * The player is places at location 4, which is the middle tile of the game map.
     */
    public void initGame() {
        GameMap gameMap = new GameMap();
        gameMap.init();

        player = new Player();
        player.init(gameMap);

        actions = new ArrayList<>();
        actions.addAll(Arrays.asList(
                new GetItemAction(),
                new InventoryAction(),
                new ShowMapAction(),
                new TravelNorthAction(),
                new TravelEastAction(),
                new TravelSouthAction(),
                new TravelWestAction(),
                new QuitAction(),
                new InvalidAction()
        ));

        actions.get(0).setActionKey("G");
        actions.get(1).setActionKey("I");
        actions.get(2).setActionKey("M");
        actions.get(3).setActionKey("N");
        actions.get(4).setActionKey("E");
        actions.get(5).setActionKey("S");
        actions.get(6).setActionKey("W");
        actions.get(7).setActionKey("Q");
    }

    /**
     * This contains the main loop for playing the game by responding to user inputs
     * and updating the game map and player state as play continues.
     */
    public void playGame() {
        // The scanner is used to gather information from an input stream
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String move;
        System.out.println("Hale hardy adventurer. You seek the Amulet of Power! Let us begin your quest!");
        System.out.println();

        while (true) {
            System.out.println("============================");
            GameTile location = player.getLocation();
            System.out.println("You are currently in " + location.getTerrain());
            if (location.getItem() != null) {
                System.out.println("You see a " + location.getItem() + " here.");
            }
            System.out.println("============================");
            System.out.print("Valid Actions are: ");
            // Display actions
            for (Action action : actions) {
                if (action.canDoAction(player)) {
                    System.out.print(action.getActionDescription());
                    System.out.print(" - ");
                }
            }
            System.out.println();
            System.out.print("What is your move: ");
            move = scanner.nextLine().toUpperCase();

            // Do Actions
            for (Action action : actions) {
                if (action.validKey(move)) {
                    action.doAction(player);
                }
            }
        }
    }
}
