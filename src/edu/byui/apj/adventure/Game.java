package edu.byui.apj.adventure;

public class Game {

    private GameMap gameMap;
    private Player player;

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
        gameMap = new GameMap();
        gameMap.init();

        player = new Player();
        player.init(gameMap.getGameTiles()[4]);
    }

    /**
     * This contains the main loop for playing the game by responding to user inputs
     * and updating the game map and player state as play continues.
     */
    public void playGame() {
        // The scanner is used to gather information from an input stream
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String move = "";
        System.out.println("Hale hardy adventurer. You seek the Amulet of Power! Let us begin your quest!");
        System.out.println();

        while (!move.equals("Q")) {
            System.out.println("============================");
            GameTile location = player.getLocation();
            System.out.println("You are currently in " + location.getTerrain());
            if (location.getItem() != null) {
                System.out.println("You see a " + location.getItem() + " here.");
                System.out.println("You can (G)et this item.");
            }
            System.out.println("You can check (I)nventory.");
            System.out.println("You can view the (M)ap.");
            System.out.print("You can travel: ");
            if (location.getNorth() != null) {
                System.out.print("(N)orth ");
            }
            if (location.getEast() != null) {
                System.out.print("(E)ast ");
            }
            if (location.getSouth() != null) {
                System.out.print("(S)outh ");
            }
            if (location.getWest() != null) {
                System.out.print("(W)est ");
            }
            System.out.println();
            System.out.println("You can (Q)uit");
            System.out.print("What is your move: ");
            move = scanner.nextLine().toUpperCase();

            if (move.equals("I")){
                player.showInventory();
            } else if (move.equals("M")){
                gameMap.showMap(player.getLocation());
            } else if (move.equals("G")) {
                player.getItem(location);
            } else if (!move.equals("Q")) {
                player.travel(move);
            }
        }
        System.out.println();
        System.out.println("Alas, the adventure has ended. Fare thee well!");
    }
}
