package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

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
