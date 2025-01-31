package edu.byui.apj.week4.pets;

import java.util.Objects;

abstract class AbstractPet implements Pet {
    private String name;
    protected boolean isVaccinated = false;

    AbstractPet(String name) {
        setName(name);
    }

    // Getters/Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String speak() {
        return "***";
    }
    public void doVaccination() {
        System.out.println("Vaccinating " + name);
        isVaccinated = true;
        System.out.println(speak());
        if (this instanceof Huggable o) o.hug();
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof AbstractPet p) && p.name.equals(name) && p.isVaccinated == isVaccinated;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, isVaccinated);
    }
    @Override
    public String toString() {
        return String.format("name: %s | vaccinated? %s", name, isVaccinated ? "yes" : "no");
    }
}
