package edu.byui.apj.adventure;

import java.io.Serializable;

public class Item implements Serializable {
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

    public static void updateStaticItems(Player player) {
        for (Item item : player.getInventory()) {
            if (item.name.equals(TerminalUtils.Ansi.colorBlue("Amulet of Power"))) Item.AMULET_OF_POWER = item;
            if (item.name.equals(TerminalUtils.Ansi.colorBlue("Sword of Justice"))) Item.SWORD_OF_JUSTICE = item;
            System.out.println(item.name);
        }
    }

}
