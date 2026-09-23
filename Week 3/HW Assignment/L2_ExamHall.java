class ExamHall {
    String hallName;
    int seatsFilled;
}

public class L2_ExamHall {
    public static void main(String[] args) {
        // Create two ExamHall objects
        ExamHall hallA = new ExamHall();
        ExamHall hallB = new ExamHall();

        // Assign different hall names
        hallA.hallName = "Block-3 Hall A";
        hallB.hallName = "Block-3 Hall B";

        // Increment seatsFilled for hallA only, 4 separate times
        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;
        hallA.seatsFilled++;

        // Print both halls' seatsFilled values
        System.out.println(hallA.hallName + " seats Filled: " + hallA.seatsFilled);
        System.out.println(hallB.hallName + " seats Filled: " + hallB.seatsFilled);
    }
}