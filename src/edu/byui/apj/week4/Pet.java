package edu.byui.apj.week4;

class Pet {
    private String name;
    protected boolean isVaccinated = false;

    Pet(String name) {
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
    }



}
