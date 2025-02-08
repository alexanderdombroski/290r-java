package edu.byui.apj.adventure;

public class Item {
    private final String name;

    Item(String name) {
        this.name = TerminalUtils.Ansi.colorBlue(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
