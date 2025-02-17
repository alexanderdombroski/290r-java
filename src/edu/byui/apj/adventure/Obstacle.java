package edu.byui.apj.adventure;

import java.util.Optional;

public class Obstacle {
    private final String name;
    private final String description;
    private final Item required;

    public Obstacle(String name, String description, Item required) {
        this.name = TerminalUtils.Ansi.colorRed(name);
        this.required = required;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public boolean CanClearObstacle(Item item) {
        return required.equals(item);
    }

    public Optional<Item> getRequired() {
        return Optional.ofNullable(required);
    }

    @Override
    public String toString() {
        return name;
    }
}
