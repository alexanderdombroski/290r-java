package edu.byui.apj.adventure;


public class GameMap {
    private final GameTile[] tiles = new GameTile[9];
    private final Item winningItem;

    public GameMap() {
        Item[] items = {
            new Item("Amulet of Power"),
            new Item("Lump of Coal"),
            new Item("Fishing Pole"),
            new Item("Old Raft"),
            new Item("Sword of Justice"),
            new Item("Ermine Cloak"),
            new Item("Gold Key"),
            new Item("Thick-Soled Boots"),
            new Item("Scarf")
        };
        winningItem = items[0];
        String[] terrain = {
            "DESERT",
            "MOUNTAIN",
            "MOUNTAIN",
            "DESERT",
            "FOREST",
            "FOREST",
            "DESERT",
            "LAKE",
            "RIVER"
        };
        Obstacle[] obstacles = {
            new Obstacle("Wooden Chest", items[6]),
            new Obstacle("Snowstorm", items[5]),
            new Obstacle("Freezing Man in Hut", items[1]),
            new Obstacle("Scorpion", items[7]),
            null,
            new Obstacle("Kobold", items[4]),
            new Obstacle("Dust Storm", items[8]),
            new Obstacle("Fishing Dock", items[2]),
            new Obstacle("Wide River", items[3])
        };
        for (int i = 0; i<9; i++) {
            tiles[i] = new GameTile(terrain[i], items[i], obstacles[i]);
        }

        // Link Tiles Together
        for (byte i = 0; i<6; i++) {
            tiles[i].setSouth(tiles[i+3]);
            tiles[i+3].setNorth(tiles[i]);
        }
        for (int i : new int[] {0, 1, 3, 4, 6, 7}) {
            tiles[i].setEast(tiles[i+1]);
            tiles[i+1].setWest(tiles[i]);
        }
    }

    public GameTile getStartLocation() {
        return tiles[4];
    }

    /**
    * Prints an even table with the terrain of known locations.
     */
    public void showMap(GameTile currentLocation) {
        Runnable border = () -> System.out.println("–".repeat(84));
        border.run();
        for (int i = 0; i < 9; i += 3) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
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
                    System.out.flush();
                }
                TerminalUtils.sleep(200);
                System.out.println();
            }
            border.run();
        }
    }

    public Item getWinningItem() {
        return winningItem;
    }
}
