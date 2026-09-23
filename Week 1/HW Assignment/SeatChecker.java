public class SeatChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean hasDuplicate = false;

        // Compare each element with every element that comes after it
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    hasDuplicate = true;
                    break; // Stop comparing current seat once duplicate is found
                }
            }
        }

        // If no duplicates were detected during the loops
        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] input1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(input1); 
        // Output: Duplicate Seat Number Found: 102

        // Test Case 2
        int[] input2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(input2); 
        // Output: No Duplicate Seats Found
    }
}