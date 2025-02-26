package edu.byui.apj.adventure.actions.normal;

import edu.byui.apj.adventure.GameLoader;
import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.TerminalUtils;
import edu.byui.apj.adventure.actions.AbstractAction;

import java.util.Optional;

public class LoadGameAction extends AbstractAction {
    public static final String DESCRIPTION = "(L)oad the game";

    public LoadGameAction(String key) { super(key); }

    @Override
    public boolean canDoAction(Player player) { return true; }
    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }

    @Override
    public void doAction(Player player) {
        Optional<Player> loadedPlayer = GameLoader.loadPlayer();
        if (loadedPlayer.isPresent()) {
            player.loadFrom(loadedPlayer.get());
            System.out.println(TerminalUtils.Ansi.colorGreen("Game loaded successfully!"));
        } else {
            System.out.println(TerminalUtils.Ansi.colorYellow("Unable to load the game!"));
        }
    }
}
