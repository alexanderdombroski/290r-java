package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

public class ShowMapAction extends AbstractAction {
    public static final String DESCRIPTION = "Show (M)ap";

    public ShowMapAction(String key) { super(key); }

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
        return DESCRIPTION;
    }
}
