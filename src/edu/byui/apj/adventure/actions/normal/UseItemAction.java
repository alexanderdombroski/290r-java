package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.Item;
import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.TerminalUtils;
import edu.byui.apj.adventure.actions.AbstractAction;

import java.util.Optional;

public class UseItemAction extends AbstractAction {
    public static final String DESCRIPTION = "(U)se an item";

    public UseItemAction(String key) {
        super(key);
    }

    @Override
    public boolean canDoAction(Player player) {
        return !player.isInventoryEmpty();
    }

    @Override
    public void doAction(Player player) {
        Optional<Item> item = player.selectInventoryItem();
        if (item.isEmpty()) return;

        // Use item
        System.out.println("Using the item!");
        TerminalUtils.sleep(400);
        System.out.println(item.get().getDescription());
        player.getLocation().clearObstacle(item.get());
        TerminalUtils.sleep(600);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
