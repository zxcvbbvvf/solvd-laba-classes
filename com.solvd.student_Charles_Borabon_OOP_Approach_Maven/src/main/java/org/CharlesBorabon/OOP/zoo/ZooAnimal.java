package org.CharlesBorabon.OOP.zoo;

public class ZooAnimal extends Zoo {
    String sound;

    public ZooAnimal(int enclousureNumber, String animalType, String sound) {
        super(enclousureNumber, animalType);
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Enclousure number: " + this.enclousureNumber + "\n"
             + "Animal type: " + this.animalType + "\n"
             + "Sound the animal makes: " + this.sound;
    }

    // override hashCode and equals methods
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.enclousureNumber;
        result = prime * result + ((this.animalType == null) ? 0 : this.animalType.hashCode());
        result = prime * result + ((this.sound == null) ? 0 : this.sound.hashCode());
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
        if (this.enclousureNumber != other.enclousureNumber) {
            return false;
        }
        if (animalType == null) {
            if (other.animalType != null) {
                return false;
            }
        } else if (!this.animalType.equals(other.animalType)) {
            return false;
        }
        if (this.sound == null) {
            if (other.sound != null) {
                return false;
            }
        } else if (!this.sound.equals(other.sound)) {
            return false;
        }
        return true;
    }
}
