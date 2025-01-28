package edu.byui.apj.week4;

import java.util.ArrayList;
import java.util.List;

public class VetSimulation {
    static void giveShots(List<Pet> pets) {
        pets.forEach(Pet::doVaccination);
    }

    public static void main(String[] args) {
        Cat mittens = new Cat("Mittens");
        Cat rusty = new Cat("Rusty");
        Dog jack = new Dog("Jack");
        Dog mia = new Dog("Mia");

        List<Pet> pets = new ArrayList<>(List.of(mittens, rusty, jack, mia));
        giveShots(pets);

    }

}
