package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.GameLoader;
import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

public class SaveGameAction extends AbstractAction {
    public static final String DESCRIPTION = "Sa(V)e the game";

    public SaveGameAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) { return true; }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }

    @Override
    public void doAction(Player player) {
        GameLoader.savePlayer(player);
    }
}
