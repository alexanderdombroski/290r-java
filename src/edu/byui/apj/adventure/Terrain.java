package edu.byui.apj.adventure;

import java.io.Serializable;

public enum Terrain implements Serializable {

    FOREST("The Mysterious Forest"),
    RIVER("The Wide River"),
    LAKE("The Sparkling Lake"),
    MOUNTAINS("The Jagged Mountains"),
    DESERT("The Winding Desert"),
    TOWN("A place of many people"),
    TUNDRA("A very snowy area");

    private final String description;

    Terrain(String description) {
        this.description = TerminalUtils.Ansi.colorGreen(description);
    }

    public String getDescription() {
        return description;
    }
}
