package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

public class GetItemAction extends AbstractAction {
    public static final String DESCRIPTION = "(G)et the item";

    public GetItemAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) {
        return player.getLocation().hasItem();
    }

    @Override
    public void doAction(Player player) {
        if (player.getLocation().canGetItem(player)) player.getItem();
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
