package edu.byui.apj.week3;

class Cat {
    private String name = "Unknown";
    private String breed = "Stray";
    private int age = 0;
    private boolean isFriendly = false;
    private int feedCount = 0;

    String getName() { return name; }
    void setName(String name) { this.name = name; }

    String getBreed() { return breed; }
    void setBreed(String breed) { this.breed = breed; }

    int getAge() { return age; }
    void setAge(int age) { this.age = age; }

    boolean isFriendly() { return isFriendly; }
    void setFriendly(boolean friendly) { isFriendly = friendly; }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        System.out.println(cat1 == cat2);
        System.out.println(cat1.equals(cat2));

        for (String food : new String[] {"fish", "milk", "cat food", "leftovers", "mouse"}) {
            cat1.feed(food);
        }
        System.out.println(cat1);
    }

    @Override
    public boolean equals(Object obj) {
        // In the equals method, cast o to a Cat. If this cat name is equal to the cat name of the object passed in, return true.
        return obj instanceof Cat && ((Cat) obj).name.equals(name);
    }

    public int feed(String food) {
        feedCount += 1;
        if (feedCount <= 3) {
            System.out.printf("The cat ate the %s.%n", food);
        } else {
            System.out.println("This cat cannot eat another bite!");
        }
        isFriendly = true;
        return feedCount;
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
