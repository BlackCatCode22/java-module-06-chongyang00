package chong.zoo.com;

import java.util.ArrayList;

public class Habitat {
    private String habitatName;
    ArrayList<Animal> animals; // Holds animals in this habitat

    // Constructor
    public Habitat(String habitatName) {
        this.habitatName = habitatName;
        this.animals = new ArrayList<>();
    }

    // Add animal to the habitat
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Display all animals in this habitat neatly
    public void displayAnimals() {
        System.out.println("\nHabitat: " + habitatName);
        System.out.println("=================================================================================");
        for (Animal animal : animals) {
            System.out.println(" Name: " + animal.getAnimalName() +
                    " ID: " + animal.getAnimalID() +
                    " Species: " + animal.getClass().getSimpleName() +
                    " Age: " + animal.getAge() +
                    " Sex: " + animal.getSex() +
                    " Color: " + animal.getAnimalColor() +
                    " Weight: " + animal.getWeight() + " lbs" +
                    " Birthdate: " + animal.getAnimalBirthday() +
                    " Origin: " + animal.getAnimalOrigin());
        }
        System.out.println("=================================================================================");
    }
}
