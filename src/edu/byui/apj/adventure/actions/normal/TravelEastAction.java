package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

public class TravelEastAction extends AbstractAction {
    public static final String DESCRIPTION = "Travel (E)ast";

    public TravelEastAction(String key) { super(key); }

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
        return DESCRIPTION;
    }
}
