package edu.byui.apj.adventure;

import edu.byui.apj.adventure.enemies.Drake;
import edu.byui.apj.adventure.enemies.Kobold;
import edu.byui.apj.adventure.enemies.Scorpion;

import java.io.Serializable;
import java.security.InvalidParameterException;

public class GameMap implements Serializable {
    private final GameTile[] tiles = new GameTile[9];
    private final Item winningItem;
    private final GameTile startLocation;

    public GameMap(int id) {
        if (id == 1) {
            // ---------- ORIGINAL MAP ----------
            Item[] items = {
                Item.AMULET_OF_POWER,
                new Item("Hoard Of Hold", "The man accepts your gold and offers you his fishing pole."),
                new Item("Fishing Pole", "You cast your line into the lake and pull out a pair of boots."),
                new Item("Old Raft", "You board the old raft and float across the river."),
                Item.SWORD_OF_JUSTICE,
                new Item("Ermine Cloak", "This ermine cloak looks good on you."),
                new Item("Gold Key", "With trembling hands you insert the key into the chest. The lock clicks open!"),
                new Item("Thick-Soled Boots", "These boots are thick and offer protection."),
                new Item("Scarf", "You wind the scarf around your nose and mouth and you can breathe easy now.")
            };
            winningItem = items[0];
            Terrain[] terrain = {
                Terrain.DESERT,
                Terrain.MOUNTAINS,
                Terrain.MOUNTAINS,
                Terrain.DESERT,
                Terrain.FOREST,
                Terrain.FOREST,
                Terrain.DESERT,
                Terrain.LAKE,
                Terrain.RIVER
            };
            Obstacle[] obstacles = {
                new Obstacle("Wooden Chest", "You see an old wooden chest which is securely locked.", items[6]),
                new Drake("Dreadful Drake", "The Mountain Drake opens his maw as a freezing fog gathers around.", items[5]),
                new Obstacle("Freezing Man in Hut", "You see an old man sitting in his mountain hut. Looks like he needs money to make some repairs.", items[1]),
                new Scorpion("Scary Scorpion", "The Scary Scorpion wields his stinger menacingly.", items[7]),
                null,
                new Kobold("Cringing Kobold", "The Cringing Kobold bares his sharp teeth in challenge.", items[4]),
                new Obstacle("Dust Storm", "A blinding sandstorm arises - it is difficult to breathe without something to cover your mouth.", items[8]),
                new Obstacle("Fishing Dock", "There is a dock here that would be perfect for fishing.", items[2]),
                new Obstacle("Wide River", "There is a wide river here that is difficult to cross without a way across.", items[3])
            };
            for (int i = 0; i<9; i++) {
                tiles[i] = new GameTile(terrain[i], items[i], obstacles[i]);
            }

            // Link Tiles Together
            for (int i = 0; i<6; i++) {
                tiles[i].setSouth(tiles[i+3]);
                tiles[i+3].setNorth(tiles[i]);
            }
            for (int i : new int[] {0, 1, 3, 4, 6, 7}) {
                tiles[i].setEast(tiles[i+1]);
                tiles[i+1].setWest(tiles[i]);
            }

            startLocation = tiles[4];


        } else if (id == 2) {
            // ---------- ALTERNATE MAP ----------

            Item[] items = {
                    new Item("Fishing Pole", "You cast your line into the lake and pull out a 3 ft trout."),
                    new Item("Thick-Soled Boots", "These boots are thick and offer protection."),
                    new Item("Professor's Key", "The fellow professor thanks you as help him back into his locked office.\nYou do back exercises inside the office on the floor and the professor mentions he has something for you..."),
                    new Item("Old Raft", "You board the old raft and float across the river."),
                    Item.AMULET_OF_POWER,
                    new Item("Large Trout", "The cat is quiet now that it isn't hungry anymore. It purrs, remembering it isn't a dog."),
                    Item.SWORD_OF_JUSTICE,
                    new Item("Scarf", "You wind the scarf around your nose and mouth and you can breathe easy now."),
                    new Item("Ermine Cloak", "This ermine cloak looks good on you.")
            };
            winningItem = items[4];
            Terrain[] terrain = {
                    Terrain.MOUNTAINS,
                    Terrain.TUNDRA,
                    Terrain.MOUNTAINS,
                    Terrain.DESERT,
                    Terrain.TOWN,
                    Terrain.LAKE,
                    Terrain.FOREST,
                    Terrain.FOREST,
                    Terrain.RIVER
            };
            Obstacle[] obstacles = {
                new Drake("Dreadful Drake", "The Mountain Drake opens his maw as a freezing fog gathers around.", items[8]),
                new Obstacle("Barking Cat", "A strange barking cat won't be quiet. In what world does a cat bark?", items[5]),
                new Scorpion("Scary Scorpion", "The Scary Scorpion wields his stinger menacingly.", items[1]),
                new Obstacle("Dust Storm", "A blinding sandstorm arises - it is difficult to breathe without something to cover your mouth.", items[7]),
                new Obstacle("Bad Back", "You feel your back hurting as you talk with a fellow professor.", items[2]),
                new Obstacle("Fishing Dock", "There is a dock here that would be perfect for fishing.", items[0]),
                null,
                new Kobold("Cringing Kobold", "The Cringing Kobold bares his sharp teeth in challenge.", items[6]),
                new Obstacle("Wide River", "There is a wide river here that is difficult to cross without a way across.", items[3])
            };
            for (int i = 0; i<9; i++) {
                tiles[i] = new GameTile(terrain[i], items[i], obstacles[i]);
            }

            // Link Tiles Together
            for (int i = 0; i<6; i++) {
                tiles[i].setSouth(tiles[i+3]);
                tiles[i+3].setNorth(tiles[i]);
            }
            for (int i : new int[] {0, 1, 3, 4, 6, 7}) {
                tiles[i].setEast(tiles[i+1]);
                tiles[i+1].setWest(tiles[i]);
            }

            startLocation = tiles[6];
        } else {
            System.out.println(TerminalUtils.Ansi.colorRed("Unknown Map Option"));
            throw new IllegalArgumentException("Unknown map id: " + id);
        }
    }

    public GameTile getStartLocation() {
        return startLocation;
    }

    /**
    * Prints an even table with the terrain of known locations.
     */
    public void showMap(GameTile currentLocation) {
        Runnable border = () -> System.out.println("–".repeat(84));
        border.run();
        for (int i = 0; i < 9; i += 3) { // Row
            for (int k = 0; k < 3; k++) { // sub row
                for (int j = 0; j < 3; j++) { // Column
                    System.out.print("| ");

                    GameTile tile = tiles[i + j];
                    String desc = switch (k) {
                        case 0 -> // Terrain
                                currentLocation == tile ? String.format("[%s]", tile.showTerrain()) : tile.showTerrain();
                        case 1 -> // Item
                                tile.showItem();
                        case 2 -> // Obstacle
                                tile.showObstacle();
                        default -> "";
                    };


                    desc = TerminalUtils.center(desc, 24);

                    System.out.print(desc);
                    System.out.print(" |");
                }
                TerminalUtils.sleep(50);
                System.out.println();
            }
            border.run();
        }
    }

    public Item getWinningItem() {
        return winningItem;
    }
}
