package edu.byui.apj.adventure.actions.fight;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.enemies.Attack;

public class ThrustAction extends FightAction {
    public static final String DESCRIPTION = "(T)hrust with the Sword";

    public ThrustAction(String actionKey) {
        super(actionKey);
    }

    @Override
    public void doAction(Player player) {
        doAction(player, Attack.THRUST);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
