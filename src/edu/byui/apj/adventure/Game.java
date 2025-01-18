package edu.byui.apj.adventure;

class Game {
    GameMap gameMap;
    Player player;

    void start() {
        initGame();
        playGame();
    }

    void initGame() {
        gameMap = new GameMap();
        gameMap.init();

        player = new Player();
        player.init(gameMap.tiles[4]);
    }

    void playGame() {
        // The scanner is used to gather information from an input stream
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String move = "";
        System.out.println("Hale hardy adventurer. You seek the Amulet of Power! Let us begin your quest!");
        System.out.println();

        while (!move.equals("Q")) {
            System.out.println("You are currently in "+player.location.terrain);
            System.out.print("What's your next move? You can travel: ");
            if (player.location.north != null){
                System.out.print("(N)orth ");
            }
            if (player.location.east != null){
                System.out.print("(E)ast ");
            }
            if (player.location.south != null){
                System.out.print("(S)outh ");
            }
            if (player.location.west != null){
                System.out.print("(W)est ");
            }
            System.out.print("or (Q)uit: ");
            move = scanner.nextLine();

            if (!move.equals("Q")){
                player.travel(move);
            }
        }
        System.out.println();
        System.out.println("Alas, the adventure has ended. Fare thee well!");
    }
}
