package edu.byui.apj.week4;

class Cat extends Pet {
    Cat(String name) {
        super(name);
    }

    @Override
    public String speak() {
        return String.format("%s says %s!", getName(), isVaccinated ? "Meow" : "Hiss");
    }

    @Override
    public void setName(String name) {
        super.setName(name + " the Cat");
    }
}
