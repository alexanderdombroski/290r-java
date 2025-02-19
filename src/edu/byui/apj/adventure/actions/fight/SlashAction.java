package edu.byui.apj.adventure.actions.fight;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.enemies.Attack;

public class SlashAction extends FightAction {
    public static final String DESCRIPTION = "(S)lash with the Sword";

    public SlashAction(String actionKey) {
        super(actionKey);
    }

    @Override
    public void doAction(Player player) {
        doAction(player, Attack.SLASH);
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
