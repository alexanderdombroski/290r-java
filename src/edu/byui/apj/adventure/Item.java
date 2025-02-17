package edu.byui.apj.adventure;

public class Item {
    private final String name;
    private final String description;
    public static Item AMULET_OF_POWER = new Item("Amulet of Power", "At last - the amulet you seek.");
    public static Item SWORD_OF_JUSTICE = new Item("Sword of Justice", "You wield the sword of justice with a flair.");

    Item(String name, String description) {
        this.name = TerminalUtils.Ansi.colorBlue(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
