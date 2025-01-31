package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public interface Action {
    boolean canDoAction(Player player);
    void doAction(Player player);
    String getActionDescription();
    void setActionKey(String key);
    boolean validKey(String test);
}
