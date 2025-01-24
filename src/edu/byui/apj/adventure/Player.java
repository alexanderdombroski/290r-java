package edu.byui.apj.adventure;

class Player {
    GameTile location;

    void init(GameTile myLocation) {
        location = myLocation;
    }

    void travel(String direction) {
        if (location == null) return;
        switch (direction) {
            case "N" -> {
                if (location.north != null) location = location.north;
                else System.out.println("Cannot move that way");
            }
            case "S" -> {
                if (location.south != null) location = location.south;
                else System.out.println("Cannot move that way");
            }
            case "E" -> {
                if (location.east != null) location = location.east;
                else System.out.println("Cannot move that way");
            }
            case "W" -> {
                if (location.west != null) location = location.west;
                else System.out.println("Cannot move that way");
            }
            default -> System.out.printf("Unknown Direction %s; Cannot Move%n", direction);
        }
    }
}
