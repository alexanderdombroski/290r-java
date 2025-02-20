package edu.byui.apj.week7;

import java.io.*;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.List;

class AnimalSerializer {
    public static void saveAnimals(List<Animal> animals) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animals.ser"))) {
            oos.writeObject(animals);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (FileLockInterruptionException e) {
            System.out.println("File is being used and can't be opened.");
        } catch (IOException e) {
            System.out.println("File IO Exception\n" + e);
        } catch (Exception e) {
            System.out.println("Some other exception occurred\n" + e);
        }
    }
    public static List<Animal> loadAnimals() {
        List<Animal> animals = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animals.ser"))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?> objList) {
                for (Object animal : objList) {
                    if (animal instanceof Animal a) {
                        animals.add(a);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (FileLockInterruptionException e) {
            System.out.println("File is being used and can't be opened.");
        } catch (Exception e) {
            System.out.println("Some other exception occurred\n" + e);
        }
        return animals;
    }


    // CSV functions
    public static void saveAnimalsToCSV(List<Animal> animals) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("animals.csv"))) {
            buffer.write("AnimalType,AnimalName,Age\n");
            for (Animal animal : animals) {
                buffer.write(animal.toCSV());
                buffer.newLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (FileLockInterruptionException e) {
            System.out.println("File is being used and can't be opened.");
        } catch (Exception e) {
            System.out.println("Some other exception occurred\n" + e);
        }
        System.out.println("Saved in animals.csv");
    }
    public static List<Animal> loadAnimalsFromCSV() {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader("animals.csv"))) {
            buffer.readLine(); // Skip first line
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.strip().split(",");
                if (fields[0].equals("Cat")) {
                    animals.add(new Cat(fields));
                } else if (fields[0].equals("Dog")) {
                    animals.add(new Dog(fields));
                } else {
                    throw new RuntimeException("Unknown animal found in animals.csv");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (FileLockInterruptionException e) {
            System.out.println("File is being used and can't be opened.");
        } catch (Exception e) {
            System.out.println("Some other exception occurred\n" + e);
        }
        return animals;
    }
}
