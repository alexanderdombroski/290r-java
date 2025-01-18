package edu.byui.apj.adventure;

class GameMap {
    GameTile[] tiles = new GameTile[9];
    void init() {
        // DESERT, MOUNTAIN, FOREST, LAKE or RIVER.
        tiles[0] = new GameTile("DESERT");
        tiles[1] = new GameTile("MOUNTAIN");
        tiles[2] = new GameTile("MOUNTAIN");
        tiles[3] = new GameTile("DESERT");
        tiles[4] = new GameTile("FOREST");
        tiles[5] = new GameTile("FOREST");
        tiles[6] = new GameTile("DESERT");
        tiles[7] = new GameTile("LAKE");
        tiles[8] = new GameTile("RIVER");

        // Link Tiles Together
        for (byte i = 0; i<6; i++) {
            tiles[i].south = tiles[i+3];
            tiles[i+3].north = tiles[i];
        }
        for (int i : new int[] {0, 1, 3, 4, 6, 7}) {
            tiles[i].east = tiles[i+1];
            tiles[i+1].west = tiles[i];
        }
    }
}
