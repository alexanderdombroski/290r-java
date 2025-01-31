package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public class TravelSouthAction extends AbstractAction {
    @Override
    public boolean canDoAction(Player player) {
        return player.getLocation().getSouth() != null;
    }

    @Override
    public void doAction(Player player) {
        player.travel("S");
    }

    @Override
    public String getActionDescription() {
        return "Travel (S)outh";
    }
}
