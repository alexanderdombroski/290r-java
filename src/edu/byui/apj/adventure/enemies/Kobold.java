package edu.byui.apj.adventure.enemies;

import edu.byui.apj.adventure.Item;

public class Kobold extends Enemy {

    private static final int MIN_HIT_POINTS = 1;
    private static final int MAX_HIT_POINTS = 2;

    public Kobold(String name, String description, Item required) {
        super(name, description, required, MIN_HIT_POINTS, MAX_HIT_POINTS);
    }

    void initProbabilityMap() {
        hitProbability.put(Attack.SLASH, 70);
        hitProbability.put(Attack.THRUST, 50);
        hitProbability.put(Attack.SMASH, 30);
    }

}