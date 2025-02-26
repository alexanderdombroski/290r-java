package edu.byui.apj.adventure.actions.fight;

import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.TerminalUtils;
import edu.byui.apj.adventure.enemies.Attack;
import edu.byui.apj.adventure.enemies.Enemy;

public class FleeAction extends FightAction {
    public static final String DESCRIPTION = "(F)lee in terror";

    public FleeAction(String actionKey) {
        super(actionKey);
    }

    @Override
    public void attack(Player player, Enemy enemy, Attack attack) {}

    @Override
    public boolean canDoAction(Player player) {
        return true;
    }

    @Override
    public void doAction(Player player) {
        System.out.println(TerminalUtils.Ansi.colorYellow("Player is fleeing!"));
        player.setFleeing(true);

        var obstacle = player.getLocation().getObstacle();
        if (obstacle.isEmpty()) return;
        if (obstacle.get() instanceof Enemy enemy) {
            enemy.counterAttack(player);
            TerminalUtils.sleep(300);
        }
    }

    @Override
    public String getActionDescription() {
        return DESCRIPTION;
    }
}
