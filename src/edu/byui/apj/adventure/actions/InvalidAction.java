package edu.byui.apj.adventure.actions;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.TerminalUtils;

import java.util.Set;

public class InvalidAction extends AbstractAction {
    public static final Set<String> validOptions = Set.of("G", "I", "M", "N", "E", "S", "W", "Q", "U");

    public InvalidAction(String key) { super(key); }


    @Override
    public boolean canDoAction(Player player) {
        return false;
    }

    @Override
    public void doAction(Player player) {
        System.out.println(TerminalUtils.Ansi.colorRed("That is not a valid option."));
        TerminalUtils.sleep(500);
    }

    @Override
    public String getActionDescription() {
        return "";
    }

    @Override
    public boolean validKey(String test) {
        return !validOptions.contains(test);
    }
}
