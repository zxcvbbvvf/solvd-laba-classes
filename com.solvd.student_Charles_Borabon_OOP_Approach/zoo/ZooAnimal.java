package zoo;

public class ZooAnimal extends Zoo {
    String sound;

    public ZooAnimal(int enclousureNumber, String animalType, String sound) {
        super(enclousureNumber, animalType);
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Enclousure number: " + enclousureNumber + "\n"
             + "Animal type: " + animalType + "\n"
             + "Sound the animal makes: " + sound;
    }

    // override hashCode and equals methods
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + enclousureNumber;
        result = prime * result + ((animalType == null) ? 0 : animalType.hashCode());
        result = prime * result + ((sound == null) ? 0 : sound.hashCode());
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
        if (enclousureNumber != other.enclousureNumber) {
            return false;
        }
        if (animalType == null) {
            if (other.animalType != null) {
                return false;
            }
        } else if (!animalType.equals(other.animalType)) {
            return false;
        }
        if (sound == null) {
            if (other.sound != null) {
                return false;
            }
        } else if (!sound.equals(other.sound)) {
            return false;
        }
        return true;
    }
}