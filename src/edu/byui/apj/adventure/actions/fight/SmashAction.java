package edu.byui.apj.adventure.actions.fight;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.enemies.Attack;

public class SmashAction extends FightAction {
    public static final String DESCRIPTION = "S(M)ash with the Sword";

    public SmashAction(String actionKey) {
        super(actionKey);
    }
    @Override
    public void doAction(Player player) {
        doAction(player, Attack.SMASH);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
