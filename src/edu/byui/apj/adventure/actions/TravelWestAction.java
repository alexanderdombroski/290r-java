package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public class TravelWestAction extends AbstractAction {
    public static final String DESCRIPTION = "Travel (W)est";

    public TravelWestAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) {
        return player.getLocation().getWest() != null;
    }

    @Override
    public void doAction(Player player) {
        player.travel("W");
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
