package edu.byui.apj.week7;

import java.io.*;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AnimalManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.println("\n🐾 Animal Manager 🐾");
            System.out.println("1. Add Dog");
            System.out.println("2. Add Cat");
            System.out.println("3. Save Animals (Serialization)");
            System.out.println("4. Load Animals (Serialization)");
            System.out.println("5. Save Animals (CSV)");
            System.out.println("6. Load Animals (CSV)");
            System.out.println("7. Load Animals (Internet CSV)");
            System.out.println("8. Display Animals");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter dog name: ");
                    String dogName = scanner.nextLine();
                    System.out.print("Enter dog age: ");
                    int dogAge = scanner.nextInt();
                    animals.add(new Dog(dogName, dogAge));
                    break;
                case 2:
                    System.out.print("Enter cat name: ");
                    String catName = scanner.nextLine();
                    System.out.print("Enter cat age: ");
                    int catAge = scanner.nextInt();
                    animals.add(new Cat(catName, catAge));
                    break;
                case 3:
                    AnimalSerializer.saveAnimals(animals);
                    break;
                case 4:
                    animals = AnimalSerializer.loadAnimals();
                    break;
                case 5:
                    AnimalSerializer.saveAnimalsToCSV(animals);
                    break;
                case 6:
                    animals = AnimalSerializer.loadAnimalsFromCSV();
                    break;
                case 7:
                    animals = AnimalSerializer.loadAnimalsFromInternet();
                    break;
                case 8:
                    if (animals.isEmpty()) {
                        System.out.println("No animals found.");
                    } else {
                        animals.forEach(System.out::println);
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
