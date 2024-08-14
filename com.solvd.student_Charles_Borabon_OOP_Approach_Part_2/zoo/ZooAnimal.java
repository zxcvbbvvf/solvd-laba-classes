package zoo;

public class ZooAnimal extends Zoo implements ZooAnimalMethods {
    private final String sound;
    private final String animalType;
    private int animalTypeCount = 0;
    static int animalCount = 0;

    public ZooAnimal(String animalType, String sound, int animalTypeCount) {
        this.animalType = animalType;
        this.sound = sound;
        this.animalTypeCount = animalTypeCount;
        animalCount += animalTypeCount;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    @Override
    public int getAnimalTypeCount() {
        return this.animalTypeCount;
    }

    @Override
    public String getSound() {
        return this.sound;
    }

    @Override
    public String getAnimalType() {
        return this.animalType;
    }

    @Override
    public String toString() {
        return "Enclousure number: " + this.getEnclousureNumber() + "\n"
             + "Animal type: " + this.getAnimalType() + "\n"
             + "Number of animals of this type: " + this.getAnimalTypeCount() + "\n"
             + "Sound the animal makes: " + this.getSound();
    }

    // override hashCode and equals methods
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getEnclousureNumber();
        result = prime * result + ((this.getAnimalType() == null) ? 0 : this.getAnimalType().hashCode());
        result = prime * result + ((this.getSound() == null) ? 0 : this.getSound().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ZooAnimal other = (ZooAnimal) obj;
        if (this.getEnclousureNumber() != other.getEnclousureNumber()) {
            return false;
        }
        if (animalType == null) {
            if (other.getAnimalType() != null) {
                return false;
            }
        } else if (!this.getAnimalType().equals(other.getAnimalType())) {
            return false;
        }
        if (this.sound == null) {
            if (other.sound != null) {
                return false;
            }
        } else if (!this.getSound().equals(other.getSound())) {
            return false;
        }
        return true;
    }
}
