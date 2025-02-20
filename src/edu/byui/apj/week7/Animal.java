package edu.byui.apj.week7;

import java.io.Serializable;

abstract class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getType();

    public String getName() { return name; }
    public int getAge() { return age; }

    public String toCSV() {
        return String.format("%s,%s,%s", getType(), name, age);
    }

    @Override
    public String toString() {
        return getType() + ": " + name + " (" + age + " years old)";
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    public Dog(String[] args) {
        super(args[1], Integer.parseInt(args[2]));
    }

    @Override
    public String getType() {
        return "Dog";
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    public Cat(String[] args) {
        super(args[1], Integer.parseInt(args[2]));
    }

    @Override
    public String getType() {
        return "Cat";
    }
}