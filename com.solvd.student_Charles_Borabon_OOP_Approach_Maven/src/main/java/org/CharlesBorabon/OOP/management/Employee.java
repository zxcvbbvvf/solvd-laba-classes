package org.CharlesBorabon.OOP.management;

public class Employee extends Management {
    String department;
    String position;

    public Employee(String name, String department, String position) {
        super(name);
        this.department = department;
        this.position = position;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n"
             + "Name: " + this.name + "\n"
             + "Department: " + this.department + "\n"
             + "Position: " + this.position;
    }
}
