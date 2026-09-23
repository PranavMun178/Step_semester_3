class CompanyEmployee {
    // Instance fields
    String empName;
    double salary;

    // Static fields shared by all instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor increments static count on object creation
    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method accessing only static fields
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        // Create three employee instances
        CompanyEmployee e1 = new CompanyEmployee("Divya", 65000);
        CompanyEmployee e2 = new CompanyEmployee("Arjun", 50000);
        CompanyEmployee e3 = new CompanyEmployee("Priya", 55000);

        // Call static method directly through the Class name
        CompanyEmployee.printCompanyInfo();
    }
}