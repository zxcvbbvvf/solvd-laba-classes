package com.solvd.student.charles_borabon.collections_and_generics.Employee_Management;

public final class Intern extends Employee {

    public Intern(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " is working as an intern.");
    }
}