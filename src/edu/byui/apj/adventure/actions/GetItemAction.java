package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public class GetItemAction extends AbstractAction {
    @Override
    public boolean canDoAction(Player player) {
        return player.getLocation().hasItem();
    }

    @Override
    public void doAction(Player player) {
        player.getItem();
    }

    @Override
    public String getActionDescription() {
        return "(G)et the item";
    }
}
