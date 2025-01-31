package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public class ShowMapAction extends AbstractAction {
    @Override
    public boolean canDoAction(Player player) {
        return true;
    }

    @Override
    public void doAction(Player player) {
        player.showMap();
    }

    @Override
    public String getActionDescription() {
        return "Show (M)ap";
    }
}
