package com.sovld.student.charles_borabon.oop_approach.Employee_Management;

import java.util.Objects;

public class Director extends Manager {
    private double bonus;

    public Director(String name, int id, double salary, String department, double bonus) {
        super(name, id, salary, department);
        this.bonus = bonus;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Director [Name=" + name + ", ID=" + id + ", Salary=" + salary + ", Department=" + this.getDepartment() + ", Bonus=" + bonus + "]";
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Director)) return false;
        if (!super.equals(obj)) return false;
        Director director = (Director) obj;
        return Double.compare(director.bonus, bonus) == 0;
    }
}