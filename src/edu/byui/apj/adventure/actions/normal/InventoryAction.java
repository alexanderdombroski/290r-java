package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.TerminalUtils;
import edu.byui.apj.adventure.actions.AbstractAction;

public class InventoryAction extends AbstractAction {
    public static final String DESCRIPTION = "Show (I)nventory";

    public InventoryAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) {
        return true;
    }

    @Override
    public void doAction(Player player) {
        player.showInventory();
        TerminalUtils.sleep(800);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
