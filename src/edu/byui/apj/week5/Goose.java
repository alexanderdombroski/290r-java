package edu.byui.apj.week5;

public class Goose extends Animal {
    private String gender = "female";
    private boolean hasMate;

    // Constructors
    public Goose() {
        this("Fred", false);
    }
    public Goose(String name) {
        super(name);
        hasMate = false;
    }
    public Goose(String name, boolean hasMate) {
        this(name);
        this.hasMate = hasMate;
    }
    public Goose(String name, String gender, boolean hasMate) {
        this(name, hasMate);
        this.gender = gender;
    }

    // Methods
    public void doGooseStuff() {
        honk();
    }

    public void honk() {
        System.out.println("Honk!");
        Thread.dumpStack();
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Gender: %s | hasMate: %b", getName(), gender, hasMate);
    }
}
