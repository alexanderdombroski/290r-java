package edu.byui.apj.week3;

import java.util.ArrayList;

public class AnimalTracker {
    public static void main(String[] args) {
        // Init List
        ArrayList<Animal> animals = new ArrayList<>(5);
        animals.add(new Animal("George", 6));
        animals.add(new Animal("Fluffly", 3));
        animals.add(new Animal("Rover", 17));
        animals.add(new Animal("Pork Chop", 5));
        animals.add(new Animal("Garfield", 1));

        // Print all animals
        animals.forEach(System.out::println);
        System.out.println();

        // Count animal properties > 5
        int greaterThanFiveCount = 0;
        for (Animal animal : animals) {
            if (animal.getAge() > 5 && animal.getName().length() > 5) greaterThanFiveCount++;
        }
        System.out.printf("%d animals 5+ years and named longer than 5%n", greaterThanFiveCount);

        // Remove Rover
        animals.remove(2);
        System.out.println(animals);

        // Print Oldest Animal (except for rover)
        animals.stream()
            .reduce((a1, a2) -> a1.getAge() > a2.getAge() ? a1 : a2)
            .ifPresent(System.out::println);
    }
}
