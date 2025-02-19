package edu.byui.apj.adventure;

public enum Terrain {

    FOREST("The Mysterious Forest"),
    RIVER("The Wide River"),
    LAKE("The Sparkling Lake"),
    MOUNTAINS("The Jagged Mountains"),
    DESERT("The Winding Desert");

    private final String description;

    Terrain(String description) {
        this.description = TerminalUtils.Ansi.colorGreen(description);
    }

    public String getDescription() {
        return description;
    }
}
