package org.CharlesBorabon.OOP_Part2.zoo;

public class Zoo implements ZooMethods {
    private int enclousureNumber;
    static int enclousureCount = 1;
    static int zooCount = 0;

    public Zoo() {
        if (enclousureCount > UPPER_BOUND) {
            throw new IllegalArgumentException("The number of enclousures has reached the maximum.");
        }
        this.enclousureNumber = enclousureCount;
        enclousureCount++;
        zooCount++;
    }

    @Override
    public int getEnclousureNumber() {
        return this.enclousureNumber;
    }

    public static int getZooCount() {
        return zooCount;
    }

    @Override
    public String toString() {
        return "This is the main zoo class.";
    }
}
