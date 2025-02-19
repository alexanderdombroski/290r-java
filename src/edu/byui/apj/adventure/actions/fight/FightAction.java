package edu.byui.apj.adventure.actions.fight;

import edu.byui.apj.adventure.Item;
import edu.byui.apj.adventure.Obstacle;
import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.TerminalUtils;
import edu.byui.apj.adventure.actions.AbstractAction;
import edu.byui.apj.adventure.enemies.Attack;
import edu.byui.apj.adventure.enemies.Enemy;

import java.util.Optional;

public abstract class FightAction extends AbstractAction {

    public FightAction(String actionKey) {
        super(actionKey);
    }

    public void attack(Player player, Enemy enemy, Attack attack) {
        enemy.attack(player, attack);
        if (player.isAlive()) enemy.counterAttack(player);
    }

    @Override
    public boolean canDoAction(Player player) {
        return player.hasItem(Item.SWORD_OF_JUSTICE);
    }

    protected void doAction(Player player, Attack attack) {
        Optional<Obstacle> obstacle = player.getLocation().getObstacle();
        if (obstacle.isEmpty()) return;

        if (obstacle.get() instanceof Enemy enemy) {
            enemy.attack(player, attack);
            TerminalUtils.sleep(200);
            if (enemy.isAlive()) enemy.counterAttack(player);
            TerminalUtils.sleep(200);
        } else {
            System.out.println(TerminalUtils.Ansi.colorYellow("Obstacle is not an enemy."));
        }
    }
}
