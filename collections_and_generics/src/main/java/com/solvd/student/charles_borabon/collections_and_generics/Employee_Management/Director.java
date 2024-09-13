package com.solvd.student.charles_borabon.collections_and_generics.Employee_Management;

public class Director extends Manager {
    private double bonus;

    public Director(String name, int id, double salary, String department, double bonus) {
        super(name, id, salary, department);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println(name + " is directing the department " + getDepartment());
    }

    @Override
    public String toString() {
        return "Director [Name=" + name + ", ID=" + id + ", Salary=" + salary + ", Bonus=" + bonus + "]";
    }
}