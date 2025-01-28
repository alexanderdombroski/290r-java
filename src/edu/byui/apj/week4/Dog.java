package edu.byui.apj.week4;

class Dog extends Pet {
    Dog(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return String.format("%s says Woof!", getName());
    }
}
