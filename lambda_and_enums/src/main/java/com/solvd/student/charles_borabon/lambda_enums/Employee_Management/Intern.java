package com.solvd.student.charles_borabon.lambda_enums.Employee_Management;

public final class Intern extends Employee {

    public Intern(String name, int id, double salary, int age) {
        super(name, id, salary, age);
    }

    @Override
    public void work() {
        System.out.println(name + " is working as an intern.");
    }
}