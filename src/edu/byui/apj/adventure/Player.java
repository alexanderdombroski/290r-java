package edu.byui.apj.adventure;

import java.util.ArrayList;
import java.util.stream.Collectors;

class Player {
    private GameTile location;
    private final ArrayList<Item> inventory = new ArrayList<>();

    void init(GameTile myLocation) {
        location = myLocation;
        location.setVisited(true);
    }

    void travel(String direction) {
        if (location == null) return;
        switch (direction) {
            case "N" -> {
                if (location.getNorth() != null) location = location.getNorth();
                else System.out.println("Cannot move that way");
            }
            case "S" -> {
                if (location.getSouth() != null) location = location.getSouth();
                else System.out.println("Cannot move that way");
            }
            case "E" -> {
                if (location.getEast() != null) location = location.getEast();
                else System.out.println("Cannot move that way");
            }
            case "W" -> {
                if (location.getWest() != null) location = location.getWest();
                else System.out.println("Cannot move that way");
            }
            default -> System.out.printf("Unknown Direction %s; Cannot Move%n", direction);
        }
        location.setVisited(true);
    }

    public GameTile getLocation() {
        return location;
    }

    public void showInventory() {
        System.out.print("Your Inventory: ");
        System.out.println(inventory.stream().map(Item::toString).collect(Collectors.joining(", ")));
    }

    public void getItem(GameTile location) {
        if (location.hasItem()) {
            inventory.add(location.getItem());
            System.out.print(location.getItem());
            System.out.println(" was added to the inventory!");
            location.removeItem();
        } else {
            System.out.println("There is nothing to get here.");
        }
    }
}
