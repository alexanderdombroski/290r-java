package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public class QuitAction extends AbstractAction {

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
        return "(Q)uit the game";
    }
}
