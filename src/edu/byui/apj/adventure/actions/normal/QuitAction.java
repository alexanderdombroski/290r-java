package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

public class QuitAction extends AbstractAction {
    public static final String DESCRIPTION = "(Q)uit the game";

    public QuitAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) {
        return true;
    }

    @Override
    public void doAction(Player player) {
        System.out.println();
        System.out.println("Alas, the adventure has ended. Fare thee well!");
        System.exit(0);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
