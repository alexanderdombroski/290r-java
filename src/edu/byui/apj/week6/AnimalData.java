package edu.byui.apj.week6;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalData {
    public static List<Animal> getAnimals() {
        return Arrays.asList(
                new Animal("Leo", "Lion", "Carnivore", 5, 180.0),
                new Animal("Ellie", "Elephant", "Herbivore", 10, 4000.0),
                new Animal("Rocky", "Rhino", "Herbivore", 7, 2500.0),
                new Animal("Zara", "Zebra", "Herbivore", 3, 300.0),
                new Animal("Carl", "Cheetah", "Carnivore", 4, 60.0),
                new Animal("Penny", "Penguin", "Carnivore", 2, 30.0),
                new Animal("Ozzy", "Orangutan", "Omnivore", 15, 80.0),
                new Animal("Barry", "Bear", "Omnivore", 8, 200.0),
                new Animal("Fiona", "Fox", "Omnivore", 3, 7.0),
                new Animal("Gerald", "Giraffe", "Herbivore", 6, 1200.0),
                new Animal("Manny", "Monkey", "Omnivore", 4, 15.0)
        );
    }

    public static void main(String[] args){
        List<Animal> animals = getAnimals();

//        Filter and Collect:
//        Create a list of all carnivores.
//        Print the names of these animals.
        List<Animal> carnivores = getAnimals().stream().filter(animal -> animal.getDiet().equals("Carnivore")).toList();
        carnivores.forEach(carnivore -> System.out.println(carnivore.getName()));

//        Average Weight:
//        Calculate the average weight of all herbivores.
//        Print the result.
//        Use OptionalDouble to handle the case where there are no herbivores (just in case you modify the data).
        OptionalDouble averageHerbivoreWeight = getAnimals().stream()
                .filter(animal -> animal.getDiet().equals("Herbivore"))
                .mapToDouble(Animal::getWeight)
                .average();
        if (averageHerbivoreWeight.isPresent()) {
            double weight = averageHerbivoreWeight.getAsDouble();
            System.out.println("The average weight of herbivores is " + weight);
        } else {
            System.out.println("There are no herbivores");
        }

//        Find Oldest Animal:
//        Find the oldest animal in the list.
//        Print its name and age.
//        Use Optional<Animal> to handle the case where the list is empty.
        Optional<Animal> oldestAnimal = animals.stream()
                .max(Comparator.comparingInt(Animal::getAge));
        if (oldestAnimal.isPresent()) {
            Animal animal = oldestAnimal.get();
            System.out.println("Oldest animal: " + animal.getName() + ", Age: " + animal.getAge());
        } else {
            System.out.println("The list of animals is empty.");
        }

//        Species Count:
//        Count the number of animals of each species.
//        Print the species name and count. (Hint: Use groupingBy and counting collectors).
        Map<String, Long> speciesCounts = animals.stream()
                .collect(Collectors.groupingBy(Animal::getSpecies, Collectors.counting()));

        speciesCounts.forEach((species, count) ->
                System.out.println("Species: " + species + ", Count: " + count));

//        Weight Sorting:
//        Sort the animals by weight in descending order.
//        Print the name and weight of the top 3 heaviest animals.
        animals.stream()
                .sorted(Comparator.comparingDouble(Animal::getWeight).reversed()) // Sort by weight descending
                .limit(3) // Take only the top 3
                .forEach(animal -> System.out.println("Name: " + animal.getName() + ", Weight: " + animal.getWeight()));

    }
}