package warehouse;

public class Employee implements Comparable<Object> {
    private int employeeNumber;
    private String name;
    private String position;
    private float salary;

    public Employee(int employeeNumber, String name, String position, float salary) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber: " + employeeNumber +
                ", name: '" + name + '\'' +
                ", position: '" + position + '\'' +
                ", annualSalary: €" + salary +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.employeeNumber, ((Employee) o).getEmployeeNumber());
    }
}
