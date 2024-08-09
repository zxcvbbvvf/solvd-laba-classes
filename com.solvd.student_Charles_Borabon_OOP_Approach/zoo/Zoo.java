package zoo;

public class Zoo {
    int enclousureNumber;
    String animalType;

    public Zoo(int enclousureNumber, String animalType) {
        this.enclousureNumber = enclousureNumber;
        this.animalType = animalType;
    }

    public void printZoo() {
        System.out.println("This is the main zoo class.");
    }
}
