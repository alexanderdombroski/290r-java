package edu.byui.apj.adventure.enemies;

import edu.byui.apj.adventure.Item;

public class Scorpion extends Enemy {

    private static final int MIN_HIT_POINTS = 3;
    private static final int MAX_HIT_POINTS = 4;

    public Scorpion(String name, String description, Item item) {
        super(name, description, item, MIN_HIT_POINTS, MAX_HIT_POINTS);
    }

    void initProbabilityMap() {
        hitProbability.put(Attack.SLASH, 50);
        hitProbability.put(Attack.THRUST, 30);
        hitProbability.put(Attack.SMASH, 70);
    }


}
