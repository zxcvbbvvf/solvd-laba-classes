package management;

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
        return "ID: " + id + "\n"
             + "Name: " + name + "\n"
             + "Department: " + department + "\n"
             + "Position: " + position;
    }
}
