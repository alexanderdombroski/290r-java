package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;

public class TravelNorthAction extends AbstractAction {
    public static final String DESCRIPTION = "Travel (N)orth";

    public TravelNorthAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) {
        return player.getLocation().getNorth() != null;
    }

    @Override
    public void doAction(Player player) {
        player.travel("N");
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
