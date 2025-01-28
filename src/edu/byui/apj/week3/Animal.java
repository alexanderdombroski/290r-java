package edu.byui.apj.week3;

class Animal {

    private String name;
    private int age = 0;

    int getAge() { return age; }
    void setAge(int age) { this.age = age; }
    String getName() { return name; }
    void setName(String name) { this.name = name; }


    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return String.format("Name: %s | Age: %s", name, age);
    }

}
