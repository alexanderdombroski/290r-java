package edu.byui.apj.week4.pets;

import java.util.ArrayList;
import java.util.List;

public class VetSimulation {
    static void giveShots(List<AbstractPet> pets) {
        pets.forEach(AbstractPet::doVaccination);
    }

    public static void main(String[] args) {
        Cat mittens = new Cat("Mittens");
        Cat rusty = new Cat("Rusty");
        Dog jack = new Dog("Jack");
        Dog mia = new Dog("Mia");

        List<AbstractPet> pets = new ArrayList<>(List.of(mittens, rusty, jack, mia));
        giveShots(pets);
        pets.forEach(System.out::println);
    }

}
