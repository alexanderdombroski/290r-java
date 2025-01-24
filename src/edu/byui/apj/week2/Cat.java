package edu.byui.apj.week2;

class Cat {
    private final String name;
    private final String breed;
    int age;
    private final boolean isFriendly;

    Cat(String name, String breed, int age, boolean isFriendly) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.isFriendly = isFriendly;
    }

    void speak() {
        System.out.println(isFriendly ? "Meow" : "Hiss!");
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s Breed: %s Age: %d Friendly? %b",
                name, breed, age, isFriendly
        );
    }
}
