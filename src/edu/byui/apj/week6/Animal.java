package edu.byui.apj.week6;

public class Animal {
    private final String name;
    private final String species;
    private final String diet; // Carnivore, Herbivore, Omnivore
    private final int age;
    private final double weight; // in kg

    public Animal(String name, String species, String diet, int age, double weight) {
        this.name = name;
        this.species = species;
        this.diet = diet;
        this.age = age;
        this.weight = weight;
    }

    // Getters (and setters if you want to allow modification)
    public String getName() { return name;}
    public String getSpecies() { return species;}
    public String getDiet() { return diet;}
    public int getAge() { return age;}
    public double getWeight() { return weight;}

    @Override
    public String toString() {
        return "Name: " + name + ", Species: " + species + ", Diet: " + diet +
                ", Age: " + age + ", Weight: " + weight;
    }
}