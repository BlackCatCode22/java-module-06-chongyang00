package chong.zoo.com;

public class Tiger extends chong.zoo.com.Animal {
    // Create a static int that keep track of the number of hyenas created.
    static int numOfTigers = 0;

    // Create a constructor.
    public Tiger(){
        super();
        numOfTigers++;
    }

    // Create a constructor that will have all the fields I want.
    public Tiger(String sex, int age, int weight, String animalName,
                 String animalID, String animalBirthDate, String animalColor,
                 String animalOrigin){
        super(sex, age, weight, animalName, animalID, animalBirthDate, animalColor, animalOrigin);
        numOfTigers++;
    }



}
