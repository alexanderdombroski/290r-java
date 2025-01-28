package edu.byui.apj.adventure;

class GameTile {
    String terrain;
    private GameTile north;
    private GameTile south;
    private GameTile east;
    private GameTile west;
    private Item item;
    private boolean isVisited;

    GameTile(String terrain, Item item) {
        this.terrain = terrain;
        this.item = item;
    }

    public String getTerrain() {
        return terrain;
    }

    public String showTile() {
        return isVisited ? terrain : "********";
    }

    public Item getItem() { return item; }
    public boolean hasItem() { return item != null; }
    public void removeItem() { item = null; }

    public GameTile getNorth() { return north; }
    public GameTile getSouth() { return south; }
    public GameTile getEast() { return east; }
    public GameTile getWest() { return west; }

    public void setNorth(GameTile north) { this.north = north; }
    public void setSouth(GameTile south) { this.south = south; }
    public void setEast(GameTile east) { this.east = east; }
    public void setWest(GameTile west) { this.west = west; }

    public boolean getVisited() { return isVisited; }
    public void setVisited(boolean visited) { isVisited = visited; }
}

