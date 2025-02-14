package edu.byui.apj.week6;

import java.util.*;

class Superhero implements Comparable<Superhero> {
    private String name;
    private int powerLevel;
    private final List<String> powers = new ArrayList<>();

    public Superhero(String name, int powerLevel, List<String> powers) {
        this.name = name;
        this.powerLevel = powerLevel;
        this.powers.addAll(powers);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Superhero && ((Superhero) obj).name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Superhero o) {
        return Integer.compare(this.powerLevel, o.powerLevel);
    }

    public static void main(String[] args) {
        ArrayList<Superhero> heros = new ArrayList<>(Arrays.asList(
            new Superhero("Bruno", 5, Arrays.asList("Freeze Ray", "Power Punch")),
            new Superhero("Dollface", 5, Arrays.asList("Glamour", "Power Punch")),
            new Superhero("Beefeater", 7, Arrays.asList("Super Jump", "Power Punch", "Flying", "Eye Lasers")),
            new Superhero("Weaksauce", 2, Arrays.asList("Keening Whine", "Freeze Ray")),
            new Superhero("Dominator", 10, Arrays.asList("Power Punch", "Flying", "Eye Lasers", "Glamour", "Super Jump"))
        ));

        System.out.println("\nHeroes: By Power");
        heros.sort(null);
        heros.forEach(System.out::println);

        Comparator<Superhero> byName = new Comparator<Superhero>() {
            @Override
            public int compare(Superhero o1, Superhero o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        System.out.println("\nHeroes: By Name");
        heros.sort(byName);
        heros.forEach(System.out::println);

        Map<Integer, List<Superhero>> heroGroups = new HashMap<>();
        for (Superhero hero : heros) {
            if (!heroGroups.containsKey(hero.powerLevel)) {
                heroGroups.put(hero.powerLevel, new ArrayList<>());
            }
            heroGroups.get(hero.powerLevel).add(hero);
        }
        System.out.println("\nHeroes: Power 5");
        System.out.println(heroGroups.get(5));

        Set<String> powers = new HashSet<>();
        heros.forEach(hero -> powers.addAll(hero.powers));
        System.out.println("\nPowers:");
        System.out.println(powers);

    }
}
