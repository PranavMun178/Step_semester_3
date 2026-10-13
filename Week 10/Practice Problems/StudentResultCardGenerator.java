
import java.util.Locale;

class StudentRecord {
    String name;
    int[] marks;

    StudentRecord(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    char calculateGrade() {
        double avg = calculateAverage();

        if (avg >= 90) {
            return 'A';
        } else if (avg >= 75) {
            return 'B';
        } else if (avg >= 60) {
            return 'C';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void printResult() {
        System.out.printf(Locale.US, "%s: Average %.1f, Grade %c%n",
                name.toUpperCase(Locale.ROOT),
                calculateAverage(), calculateGrade());
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        StudentRecord s1 =
                new StudentRecord("Asha", new int[]{80, 90, 70});
        StudentRecord s2 =
                new StudentRecord("Ravi", new int[]{60, 55, 50});

        s1.printResult();
        s2.printResult();
    }
}
