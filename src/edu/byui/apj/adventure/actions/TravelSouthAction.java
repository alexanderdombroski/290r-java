package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

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
