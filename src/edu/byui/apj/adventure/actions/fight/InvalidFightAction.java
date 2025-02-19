package edu.byui.apj.adventure.actions.fight;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.enemies.Attack;
import edu.byui.apj.adventure.enemies.Enemy;

import java.util.Set;

public class InvalidFightAction extends FightAction {
    public static final Set<String> validOptions = Set.of("S", "T", "M", "F");

    public InvalidFightAction(String actionKey) {
        super("STMF");
    }

    @Override
    public boolean validKey(String test) {
        return !validOptions.contains(test);
    }

    @Override
    public void doAction(Player player) {
        System.out.println("Not an option right now.");
    }

    @Override
    public String getActionDescription() { return ""; }
    @Override
    public boolean canDoAction(Player player) { return false; }
    @Override
    public void attack(Player player, Enemy enemy, Attack attack) {}
}
