package edu.byui.apj.adventure;


class GameMap {
    private final GameTile[] tiles = new GameTile[9];
    void init() {
        // DESERT, MOUNTAIN, FOREST, LAKE or RIVER.
        tiles[0] = new GameTile("DESERT", new Item("Amulet of Power"));
        tiles[1] = new GameTile("MOUNTAIN", new Item("Lump of Coal"));
        tiles[2] = new GameTile("MOUNTAIN", new Item("Fishing Pole"));
        tiles[3] = new GameTile("DESERT", new Item("Old Raft"));
        tiles[4] = new GameTile("FOREST", new Item("Sword of Justice"));
        tiles[5] = new GameTile("FOREST", new Item("Ermine Cloak"));
        tiles[6] = new GameTile("DESERT", new Item("Gold Key"));
        tiles[7] = new GameTile("LAKE", new Item("Thick-Soled Boots"));
        tiles[8] = new GameTile("RIVER", new Item("Scarf"));

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

    public GameTile[] getGameTiles() {
        return tiles;
    }

    /**
    * Prints an even table with the terrain of known locations.
     */
    public void showMap(GameTile currentLocation) {
        int i = 0;
        for (GameTile tile : tiles) {
            i += 1;
            System.out.print("| ");

            String desc = currentLocation == tile ? String.format("[%s]", tile.showTile()) : tile.showTile();
            desc = TerminalUtils.center(desc, 14);

            System.out.print(desc);
            System.out.print(" |");

            if (i % 3 == 0) System.out.println();
            System.out.flush();
            TerminalUtils.sleep(200);
        }

        TerminalUtils.sleep(750);
    }
}
