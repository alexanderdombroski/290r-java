package edu.byui.apj.adventure.enemies;

import edu.byui.apj.adventure.Item;
import edu.byui.apj.adventure.Obstacle;
import edu.byui.apj.adventure.Player;
import edu.byui.apj.adventure.TerminalUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Enemy extends Obstacle {

    protected int hitPoints;
    protected Map<Attack, Integer> hitProbability = new HashMap<>();
    protected final Random random = new Random();
    protected int playerHitProbability = 20;

    public Enemy(String name, String description, Item required, int minHitPoints, int maxHitPoints) {
        super(name, description, required);
        hitPoints = random.nextInt(minHitPoints, maxHitPoints + 1);
        initProbabilityMap();
    }

    abstract void initProbabilityMap();

    public void attack(Player player, Attack attack) {
        if (getRequired().isEmpty() || player.hasItem(getRequired().get())) {
            // Otherwise, roll for hit by picking a random number between 1 and 100.
            int attackValue = random.nextInt(1, 101);
            // Get the probability number from the map using the attack enum as the key
            // If the number rolled is less than the number print a message that the enemy was hit and subtract a hit point
            if (attackValue < hitProbability.get(attack)) {
                System.out.println(TerminalUtils.Ansi.colorGreen("Enemy was hit!"));
                hitPoints -= 1;
            } else {
                // Otherwise, print a message that the attack was unsuccessful.
                System.out.println(TerminalUtils.Ansi.colorRed("Attack Unsuccessful"));
            }

        } else {
            // If the player does not have the required item for this
            // enemy print a message that they cannot attack because they lack the specified item.
            System.out.printf(TerminalUtils.Ansi.colorRed("You cannot attack because you do not have %s %n"), getRequired().get().getName());
        }
    }

    public void counterAttack(Player player) {
        int roll = random.nextInt(100);
        if (roll < playerHitProbability){
            System.out.println("The "+getName()+ TerminalUtils.Ansi.colorRed(" attacks and scores a HIT on you."));
            player.reduceHitPoints(1);
        }
        else{
            System.out.println("The "+getName()+ TerminalUtils.Ansi.colorYellow(" attacks but luckily it was a MISS."));
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public int getHitPoints(){
        return hitPoints;
    }
}