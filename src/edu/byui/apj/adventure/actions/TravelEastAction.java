package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public class TravelEastAction extends AbstractAction {
    @Override
    public boolean canDoAction(Player player) {
        return player.getLocation().getEast() != null;
    }

    @Override
    public void doAction(Player player) {
        player.travel("E");
    }

    @Override
    public String getActionDescription() {
        return "Travel (E)ast";
    }
}
