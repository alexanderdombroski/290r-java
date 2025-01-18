package edu.byui.apj.adventure;

class GameTile {
    String terrain;
    GameTile north;
    GameTile south;
    GameTile east;
    GameTile west;

    GameTile(String terrain) {
        this.terrain = terrain;
    }
}

