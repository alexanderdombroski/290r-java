package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

public class TravelSouthAction extends AbstractAction {
    public static final String DESCRIPTION = "Travel (S)outh";

    public TravelSouthAction(String key) { super(key); }

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
        return DESCRIPTION;
    }
}
