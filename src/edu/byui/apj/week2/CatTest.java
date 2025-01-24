package edu.byui.apj.week2;

class CatTest {
    public static void main(String[] args) {
        // See Cat Start Info
        Cat[] cats = {
                new Cat("Ranger", "American Shorthair", (byte) 7, true),
                new Cat("Bandit", "American Shorthair", (byte) 7, true),
                new Cat("Mellow", "Ragdoll", 3, false)
        };
        for (Cat cat : cats) {
            System.out.println(cat);
            cat.speak();
        }

        // Change Ranger's Age
        cats[0].age = 1000;
        System.out.println(cats[0]);

        // Null test
        cats[0] = null;
        System.out.println(cats[0]);
        // Null Pointer Exception
        // cats[0].speak();
    }
}
