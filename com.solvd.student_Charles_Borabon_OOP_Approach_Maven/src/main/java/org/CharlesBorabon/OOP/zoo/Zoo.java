package org.CharlesBorabon.OOP.zoo;

public class Zoo {
    int enclousureNumber;
    String animalType;

    public Zoo(int enclousureNumber, String animalType) {
        this.enclousureNumber = enclousureNumber;
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return "This is the main zoo class.";
    }
}
