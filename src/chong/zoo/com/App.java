// Chong Yang
// zooVersion01.java
//

package chong.zoo.com;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to my Zoo Program!");

        // creates the animal name lists
        String filePath = "animalNames.txt";
        //reads and creates a list from the animalNames.txt
        AnimalNameListsWrapper animalLists = Utilities.createAnimalNameLists(filePath);

        // Initialize the habitats for the animals
        Habitat hyenaHabitat = new Habitat("Hyena Habitat");
        Habitat lionHabitat = new Habitat("Lion Habitat");
        Habitat tigerHabitat = new Habitat("Tiger Habitat");
        Habitat bearHabitat = new Habitat("Bear Habitat");

        // Animal counters
        int hyenaNameIndex = 0, lionNameIndex = 0, tigerNameIndex = 0, bearNameIndex = 0;
        int hyenaIDCounter = 1, lionIDCounter = 1, tigerIDCounter = 1, bearIDCounter = 1;

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("arrivingAnimals.txt"));
            String line;

            // Process each arriving animal
            while ((line = reader.readLine()) != null) {
                String[] arrayOfStrPartsOnComma = line.split(", ");
                String[] arrayOfStrPartsOnSpace = arrayOfStrPartsOnComma[0].split(" ");
                String[] arrayOfStrPartsOnSpace02 = arrayOfStrPartsOnComma[1].split(" ");

                int animalAge = Integer.parseInt(arrayOfStrPartsOnSpace[0]);
                String animalWeight = arrayOfStrPartsOnComma[3].split(" ")[0];
                int weight = Integer.parseInt(animalWeight);
                String animalSpecies = arrayOfStrPartsOnSpace[4];
                String animalSex = arrayOfStrPartsOnSpace[3];
                String animalColor = arrayOfStrPartsOnComma[2];
                String animalOrigin01 = arrayOfStrPartsOnComma[4];
                String animalOrigin02 = arrayOfStrPartsOnComma[5];
                String animalBirthSeason = arrayOfStrPartsOnSpace02[2];

                // Calculate birthdate
                String birthDate = Utilities.calcAnimalBirthDate(animalAge, animalBirthSeason);

                if (animalSpecies.equals("hyena")) {
                    String hyenaName = animalLists.getHyenaNameList().get(hyenaNameIndex++);
                    String hyenaID = "Hy" + String.format("%02d", hyenaIDCounter++); //keeps tracks and adds animal counter
                    Hyena hyena = new Hyena(animalSex, animalAge, Integer.parseInt(animalWeight), hyenaName, hyenaID, birthDate, animalColor, animalOrigin01 + animalOrigin02);

                    // Add the hyena to the hyena habitat
                    hyenaHabitat.addAnimal(hyena);
                } else if (animalSpecies.equals("lion")) {
                    String lionName = animalLists.getLionNameList().get(lionNameIndex++);
                    String lionID = "Li" + String.format("%02d", lionIDCounter++);
                    Lion lion = new Lion(animalSex, animalAge, Integer.parseInt(animalWeight), lionName, lionID, birthDate, animalColor, animalOrigin01 + animalOrigin02);

                    // Add the lion to the lion habitat
                    lionHabitat.addAnimal(lion);
                } else if (animalSpecies.equals("tiger")) {
                    String tigerName = animalLists.getTigerNameList().get(tigerNameIndex++);
                    String tigerID = "Ti" + String.format("%02d", tigerIDCounter++);
                    Tiger tiger = new Tiger(animalSex, animalAge, Integer.parseInt(animalWeight), tigerName, tigerID, birthDate, animalColor, animalOrigin01 + animalOrigin02);

                    // Add the tiger to the tiger habitat
                    tigerHabitat.addAnimal(tiger);
                } else if (animalSpecies.equals("bear")) {
                    String bearName = animalLists.getBearNameList().get(bearNameIndex++);
                    String bearID = "Be" + String.format("%02d", bearIDCounter++);
                    Bear bear = new Bear(animalSex, animalAge, Integer.parseInt(animalWeight), bearName, bearID, birthDate, animalColor, animalOrigin01 + animalOrigin02);

                    // Add the bear to the bear habitat
                    bearHabitat.addAnimal(bear);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
;
       // Prints animals in their habitat

        hyenaHabitat.displayAnimals();
        lionHabitat.displayAnimals();
        tigerHabitat.displayAnimals();
        bearHabitat.displayAnimals();

        //prints out the total numbers of animal

        System.out.println("\nTotal number of animals in the zoo: " + Animal.numOfAnimal);
        System.out.println("Hyenas: " + hyenaHabitat.animals.size());
        System.out.println("Lions: " + lionHabitat.animals.size());
        System.out.println("Tigers: " + tigerHabitat.animals.size());
        System.out.println("Bears: " + bearHabitat.animals.size());



    }
}
