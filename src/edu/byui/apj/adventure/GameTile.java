package edu.byui.apj.adventure;

import java.io.Serializable;
import java.util.Optional;

public class GameTile implements Serializable {
    private final Terrain terrain;
    private GameTile north;
    private GameTile south;
    private GameTile east;
    private GameTile west;
    private Item item;
    private boolean isVisited;
    private Obstacle obstacle;

    GameTile(Terrain terrain, Item item, Obstacle obstacle) {
        this.terrain = terrain;
        this.item = item;
        this.obstacle = obstacle;
    }

    public Terrain getTerrain() {
        return terrain;
    }
    public Optional<Obstacle> getObstacle() { return Optional.ofNullable(obstacle); }
    public void setObstacle(Obstacle obstacle) { this.obstacle = obstacle; }

    public String showTerrain() {
        return isVisited ? terrain.name() : "********";
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
            System.out.printf("Using the %s %s%n", item, TerminalUtils.Ansi.colorYellow("has no effect"));
            return;
        }
        System.out.printf("The %s is defeated by the %s%n", obstacle, item);
        obstacle = null;
    }
    public boolean canClearObstacle(Item item) {
        if (obstacle == null) return false;
        return obstacle.CanClearObstacle(item);
    }
}

