package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.GameLoader;
import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.actions.AbstractAction;

public class QuitAction extends AbstractAction {
    public static final String DESCRIPTION = "(Q)uit the game";

    public QuitAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) {
        return true;
    }

    @Override
    public void doAction(Player player) {
        GameLoader.showMessage("quit.txt", "It's over. You quit.");
        System.exit(0);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
