package management;

public final class Employee extends Management implements EmployeeMethods {
    private String department;
    private String position;
    static int employeeCount = 0;

    public Employee(String name, String department, String position) {
        super(name);
        this.department = department;
        this.position = position;
        employeeCount++;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public String getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "\n"
             + "Name: " + this.getName() + "\n"
             + "Department: " + this.getDepartment() + "\n"
             + "Position: " + this.getPosition();
    }
}
