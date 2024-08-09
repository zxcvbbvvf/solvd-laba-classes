package zoo;

public class ZooAnimal extends Zoo {
    String sound;

    public ZooAnimal(int enclousureNumber, String animalType, String sound) {
        super(enclousureNumber, animalType);
        this.sound = sound;
    }

    @Override
    public void printZoo() {
        System.out.println("Enclousure number: " + enclousureNumber);
        System.out.println("Animal type: " + animalType);
        System.out.println("Sound the animal makes: " + sound);
    }
}
