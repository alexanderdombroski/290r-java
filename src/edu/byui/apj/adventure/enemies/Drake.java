package edu.byui.apj.adventure.enemies;

import edu.byui.apj.adventure.Item;

public class Drake extends Enemy {

    private static final int MIN_HIT_POINTS = 2;
    private static final int MAX_HIT_POINTS = 3;

    public Drake(String name, String description, Item item) {
        super(name, description, item, MIN_HIT_POINTS, MAX_HIT_POINTS);
    }

    void initProbabilityMap() {
        hitProbability.put(Attack.SLASH, 30);
        hitProbability.put(Attack.THRUST, 70);
        hitProbability.put(Attack.SMASH, 50);
    }

}