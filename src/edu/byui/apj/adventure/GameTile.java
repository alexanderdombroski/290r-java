package edu.byui.apj.adventure;

public class GameTile {
    private final String terrain;
    private GameTile north;
    private GameTile south;
    private GameTile east;
    private GameTile west;
    private Item item;
    private boolean isVisited;
    private Obstacle obstacle;

    GameTile(String terrain, Item item, Obstacle obstacle) {
        this.terrain = TerminalUtils.Ansi.colorGreen(terrain);
        this.item = item;
        this.obstacle = obstacle;
    }

    public String getTerrain() {
        return terrain;
    }
    public Obstacle getObstacle() { return obstacle; }

    public String showTerrain() {
        return isVisited ? terrain : "********";
    }
    public String showObstacle() {
        if (obstacle == null) return "";
        return isVisited ? obstacle.toString() : "";
    }
    public String showItem() {
        if (item == null) return "";
        return isVisited ? item.toString() : "";
    }

    public boolean canGetItem(Player player) { return item != null && obstacle == null; }
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

    public void setVisited(boolean visited) { isVisited = visited; }

    public void clearObstacle(Item item) {
        if (obstacle == null) {
            System.out.println(TerminalUtils.Ansi.colorRed("There is no obstacle here"));
            return;
        }
        if (!obstacle.CanClearObstacle(item)) {
            System.out.printf("Using the %s has no effect%n", item);
            return;
        }
        System.out.printf("The %s is defeated by the %s%n", obstacle, item);
        obstacle = null;
    }
}

