class Employee {
    String empName;
    double salary;
    boolean permanent;
}

public class L3_DefaultValues {
    public static void main(String[] args) {
        // Create an Employee object without setting any fields
        Employee emp = new Employee();

        // Print default values immediately after object creation
        System.out.println("Name: " + emp.empName);
        System.out.println("Salary: " + emp.salary);
        System.out.println("Permanent: " + emp.permanent);
    }
}