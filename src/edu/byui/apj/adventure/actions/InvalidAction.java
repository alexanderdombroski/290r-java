package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

import java.util.Set;

public class InvalidAction extends AbstractAction {
    Set<String> validOptions = Set.of("G", "I", "M", "N", "E", "S", "W", "Q");

    @Override
    public boolean canDoAction(Player player) {
        return false;
    }

    @Override
    public void doAction(Player player) {
        System.out.println("That is not a valid option.");
    }

    @Override
    public String getActionDescription() {
        return "";
    }

    @Override
    public boolean validKey(String test) {
        return !validOptions.contains(test);
    }
}
