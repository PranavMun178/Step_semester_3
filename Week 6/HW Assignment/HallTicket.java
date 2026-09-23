class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        // Create initial HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Assign second variable to point to the exact same object reference
        HallTicket copy = priya;

        // Change seat number using the second variable
        copy.seatNumber = 45;

        // Verify the change via the first variable
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);

        // Check reference equality
        System.out.println("copy == priya: " + (copy == priya));

        // Create a third, separate HallTicket object with matching values
        HallTicket separate = new HallTicket("Priya", 45);

        // Check reference equality against the separate object
        System.out.println("separate == priya: " + (separate == priya));
    }
}