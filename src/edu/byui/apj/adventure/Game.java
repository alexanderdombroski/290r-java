package edu.byui.apj.adventure;

import edu.byui.apj.adventure.actions.*;
import edu.byui.apj.adventure.actions.normal.*;
import edu.byui.apj.adventure.actions.fight.*;
import edu.byui.apj.adventure.enemies.Enemy;

import java.util.*;

/**
 * This class contains the logic for the main game loop,
 * getting inputs and processing them to update the game state for the player
 * based on the game map contents and related obstacles and items.
 * The game also includes a sub loop for the fight system.
 */
public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    private Player player;
    private List<Action> normalActions;
    private List<FightAction> fightActions;
    private List<Action> travelActions;
    private static Game instance;

    enum GameState {
        NORMAL,
        FIGHTING
    }

    /**
     * Private constructor which initializes the Game
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
        GameMap gameMap = new GameMap();

        player = new Player(gameMap);

        normalActions = Arrays.asList(
                new GetItemAction("G"),
                new InventoryAction("I"),
                new UseItemAction("U"),
                new ShowMapAction("M"),
                new TravelNorthAction("N"),
                new TravelEastAction("E"),
                new TravelSouthAction("S"),
                new TravelWestAction("W"),
                new QuitAction("Q"),
                new InvalidAction("")
        );

        fightActions = Arrays.asList(
                new FleeAction("F"),
                new SlashAction("S"),
                new ThrustAction("T"),
                new SmashAction("M"),
                new InvalidFightAction("")
        );

        travelActions = Arrays.asList(
                new TravelNorthAction("N"),
                new TravelEastAction("E"),
                new TravelSouthAction("S"),
                new TravelWestAction("W")
        );
    }

    /**
     * This contains the main loop for playing the game
     * A welcome message is displayed
     * The main loop
     * - checks the game state and prints out player status
     * - If the user is not fighting
     * -- displays the user options
     * -- awaits input then acts accordingly
     * - If the user is fighting then enter the fighting sub loop
     * When the winning item is in inventory, the game ends showing the
     * game won message.
     * If the player is no longer alive, shows the defeat message.
     */
    private void playGame() {
        // The scanner is used to gather information from an input stream
        // Show the game welcome message
        showWelcome();

        GameState currentState;
        // Loop until the player has collected the winning item.
        while (!player.hasItem(Item.AMULET_OF_POWER) && player.isAlive()) {
            currentState = checkGameState();

            if (currentState==GameState.NORMAL) {
                displayValidActions(normalActions);
                moveAndAct(normalActions);
            }
            else{
                fightToTheDeath();
            }
        }

        // Show the game won/lost message.
        if (player.isAlive()) {
            showGameWon();
        } else {
            showGameLost();
        }
    }

    /**
     * Informs the user where they are currently located, what item is visible and
     * if any obstacles are preventing the item from being retrieved.
     */
    private GameState checkGameState() {
        System.out.println(TerminalUtils.Ansi.colorMagenta("============================"));
        GameTile location = player.getLocation();
        System.out.println("You are currently in " + location.getTerrain().getDescription());
        if (player.getLocation().canGetItem(player)) {
            System.out.println("You see a " + location.getItem() + " here.");
        }
        Optional<Obstacle> obstacle = location.getObstacle();
        if (obstacle.isPresent()) {
            System.out.println(obstacle.get().getDescription());
            if (obstacle.get() instanceof Enemy) {
                return GameState.FIGHTING;
            }
        }
        return GameState.NORMAL;
    }

    /**
     * Iterates over the list of valid actions and displays them to the user.
     *
     * @param actions The list of possible actions to be filtered for display
     */
    private <T extends Action> void displayValidActions(List<T> actions) {
        System.out.println(TerminalUtils.Ansi.colorMagenta("============================"));
        System.out.println("Valid Actions are: ");
        actions.forEach(action -> {
            if (action.canDoAction(player)) System.out.println(action.getActionDescription());
        });
        System.out.println();
    }

    /**
     * Gets the player's next move from the console and
     * attempts to do the corresponding action.
     *
     * @param actions A list of possible actions that might be taken based on the input from the user.
     */
    private <T extends Action> void moveAndAct(List<T> actions) {
        System.out.print("What is your move: ");
        String move = scanner.nextLine().toUpperCase();
        actions.forEach(action -> {
            if (action.validKey(move)) action.doAction(player);
        });
    }

    /**
     * This interrupts the normal game flow to enter the "fight to the death" state.
     * A new set of actions are available to the player.
     */
    private void fightToTheDeath() {
        System.out.println("It's a fight to the death!");
        Enemy enemy = (Enemy) player.getLocation().getObstacle().orElseThrow();

        // Continue the fight until death, or flee
        while (player.isAlive() && enemy.isAlive() && !player.isFleeing()) {
            showFighters(player, enemy);
            displayValidActions(fightActions);
            moveAndAct(fightActions);
        }

        // Check the outcome and act accordingly
        if (!enemy.isAlive()) {
            System.out.println("The " + player.getLocation().getObstacle().get() + " was defeated.");
            player.getLocation().setObstacle(null);
        } else if (!player.isAlive()) {
            System.out.println("You were defeated by the " + enemy.getName());
        } else {
            System.out.println("Fleeing in a random direction to escape certain death.");
            player.setFleeing(false);

            // Using the travelActions list, pick a random direction to flee in, then flee.
            // Filter the list to only valid directions available to the player
            // Then select a direction at random
            Random rnd = new Random();
            List<Action> moves = travelActions.stream()
                    .filter(direction -> direction.canDoAction(player))
                    .toList();
            Optional<Action> move = Optional.empty();
            if (!moves.isEmpty()) move = Optional.of(moves.get(rnd.nextInt(moves.size())));

            // Travel in the chosen direction.
            if (move.isEmpty()) System.exit(1);
            move.get().doAction(player);

            // Tell the user what direction you travelled in.
            // -- HINT: Use a switch statement and make a separate case for
            // TravelNorthAction.DESCRIPTION, TravelSouthAction.DESCRIPTION, etc.
            String message = switch (move.get().getActionDescription()) {
                case "Travel (N)orth" -> "You climb to the north to escape.";
                case "Travel (E)ast" -> "You travel east quickly.";
                case "Travel (S)outh" -> "You travel south as quick as you can.";
                case "Travel (W)est" -> "You trek far into the west to escape.";
                default -> throw new IllegalStateException("Unexpected value: " + move.get().getActionDescription());
            };
            System.out.println("You run for your life in shame and dismay. Oh the embarrassment!");
            System.out.println(message);

        }
    }

    /**
     * Prints statistics for fighters (# of hit points left)
     * @param player The player playing the game
     * @param enemy The enemy currently being fought
     */
    private void showFighters(Player player, Enemy enemy){
        System.out.println("Player health: "+player.getHitPoints());
        System.out.println(enemy.getName()+" health: "+enemy.getHitPoints());
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
        System.out.println("With the " + Item.AMULET_OF_POWER + " in your possession, you are ready to CONQUER THE WORLD!");
        System.out.println("Here is where your quest ends. Congratulations - victory is YOURS!");
    }

    /**
     * Shows the final message when the game is lost.
     */
    private void showGameLost() {
        System.out.println("Your journey has ended in ignominious defeat. Better luck next time, adventurer.");
    }

}