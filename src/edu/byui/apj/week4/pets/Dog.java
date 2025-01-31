package edu.byui.apj.week4.pets;

class Dog extends AbstractPet {
    Dog(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return String.format("%s says Woof!", getName());
    }
}
