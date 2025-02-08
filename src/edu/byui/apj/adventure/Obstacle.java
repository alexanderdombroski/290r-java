package edu.byui.apj.adventure;

public class Obstacle {
    private final String name;
    private final Item required;

    public Obstacle(String name, Item required) {
        this.name = TerminalUtils.Ansi.colorRed(name);
        this.required = required;
    }

    public boolean CanClearObstacle(Item item) {
        return required.equals(item);
    }

    @Override
    public String toString() {
        return name;
    }
}
