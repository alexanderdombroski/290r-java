package edu.byui.apj.week4.pets;

class Cat extends AbstractPet implements Huggable {
    Cat(String name) {
        super(name);
    }

    @Override
    public void hug() {
        System.out.println("Hugging " + getName());
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
