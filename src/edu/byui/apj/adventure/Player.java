package edu.byui.apj.adventure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player implements Serializable {
    private GameTile location;
    private GameMap gameMap;
    private final ArrayList<Item> inventory = new ArrayList<>();
    private int hitPoints = 5;
    private boolean fleeing;

    public Player(GameMap gameMap) {
        this.gameMap = gameMap;
        location = gameMap.getStartLocation();
        location.setVisited(true);
    }

    public boolean isFleeing() { return fleeing; }
    public void setFleeing(boolean fleeing) { this.fleeing = fleeing; }
    public boolean isAlive() {
        return hitPoints > 0;
    }
    public void reduceHitPoints(int points) {
        hitPoints -= points;
    }
    public int getHitPoints() { return hitPoints; }

    public void travel(String direction) {
        if (location == null) return;
        switch (direction) {
            case "N" -> {
                if (location.getNorth() != null) location = location.getNorth();
                else System.out.println(TerminalUtils.Ansi.colorRed("Cannot move that way"));
            }
            case "S" -> {
                if (location.getSouth() != null) location = location.getSouth();
                else System.out.println(TerminalUtils.Ansi.colorRed("Cannot move that way"));
            }
            case "E" -> {
                if (location.getEast() != null) location = location.getEast();
                else System.out.println(TerminalUtils.Ansi.colorRed("Cannot move that way"));
            }
            case "W" -> {
                if (location.getWest() != null) location = location.getWest();
                else System.out.println(TerminalUtils.Ansi.colorRed("Cannot move that way"));
            }
            default -> System.out.println(TerminalUtils.Ansi.colorRed(String.format("Unknown Direction %s; Cannot Move", direction)));
        }
        location.setVisited(true);
    }

    public GameTile getLocation() {
        return location;
    }

    public void showInventory() {
        System.out.print("Your Inventory: ");
        if (isInventoryEmpty()) {
            System.out.println(TerminalUtils.Ansi.colorYellow("Inventory is Empty."));
            return;
        }
        System.out.println(inventory.stream().map(Item::toString).sorted().collect(Collectors.joining(", ")));
    }
    public boolean hasItem(Item item) {
        return inventory.contains(item);
    }

    /**
     * Allows the user to select an inventory item.
     * @return An item or empty optional
     */
    public Optional<Item> selectInventoryItem() {
        if (inventory.isEmpty()) {
            System.out.println("You have an empty inventory.");
            return Optional.empty();
        }
        AtomicInteger i = new AtomicInteger(1);
        inventory.forEach(item -> System.out.printf("%d. %s%n", i.getAndIncrement(), item));
        System.out.printf("%s. None of these%n", i.get());
        int response = TerminalUtils.getValidInt("Which item will you use? ", 1, inventory.size() + 1);
        if (response == i.get()) return Optional.empty();
        return Optional.of(inventory.get(response - 1));
    }

    public boolean isInventoryEmpty() { return inventory.isEmpty(); }
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void getItem() {
        if (!location.hasItem()) {
            System.out.println("There is nothing to get here.");
            return;
        }
        if (!location.canGetItem(this)) {
            System.out.println("You cannot get that item yet");
            return;
        }
        inventory.add(location.getItem());
        System.out.print(location.getItem());
        System.out.println(" was added to the inventory!");
        location.removeItem();
    }
    public void showMap() {
        gameMap.showMap(location);
    }
    public void loadFrom(Player player) {
        this.location = player.location; // Important: Assign the *reference*
        this.inventory.clear(); // Clear existing inventory
        this.inventory.addAll(player.inventory); // Add all items from the loaded player object.
        this.hitPoints = player.hitPoints;
        this.fleeing = player.fleeing;
        this.gameMap = player.gameMap;
        Item.updateStaticItems(this);
    }

    public final Item getWinningItem() {
        return gameMap.getWinningItem();
    }
}
