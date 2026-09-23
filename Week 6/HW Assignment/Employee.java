class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns using constructor chaining (this)
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0); // Chains to 3-arg constructor
        this.isIntern = true;
    }

    // Method to print profile
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        // Permanent Employee
        Employee emp1 = new Employee("E101", "Divya", 65000);
        emp1.printProfile();

        // Intern
        Employee emp2 = new Employee("E102", "Arjun");
        emp2.printProfile();
    }
}