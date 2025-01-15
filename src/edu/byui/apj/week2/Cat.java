package edu.byui.apj.week2;

public class Cat {
    private final String name;
    private final String breed;
    public int age;
    private final boolean isFriendly;

    public Cat(String name, String breed, int age, boolean isFriendly) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.isFriendly = isFriendly;
    }

    public void speak() {
        System.out.println(isFriendly ? "Meow" : "Hiss!");
    }

    public String toString() {
        return String.format(
                "Name: %s Breed: %s Age: %d Friendly? %b",
                name, breed, age, isFriendly
        );
    }
}
