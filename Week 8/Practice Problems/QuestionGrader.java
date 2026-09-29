import java.util.*;
import java.util.regex.*;

abstract class Question {
    int points;

    Question(int points) {
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    String correct, student;

    MCQ(String c, String s, int p) {
        super(p);
        correct = c;
        student = s;
    }

    double grade() {
        return student.equals(correct) ? points : 0;
    }
}

class TF extends Question {
    String correct, student;

    TF(String c, String s, int p) {
        super(p);
        correct = c;
        student = s;
    }

    double grade() {
        return student.equals(correct) ? points : 0;
    }
}

class Essay extends Question {
    String correct, student;

    Essay(String c, String s, int p) {
        super(p);
        correct = c;
        student = s;
    }

    double grade() {
        int count = 0;

        for (String key : correct.split(",")) {
            if (student.toLowerCase().contains(key.trim().toLowerCase()))
                count++;
        }

        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;
        Pattern p = Pattern.compile(
            "^(\\w+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+(\\d+)$"
        );

        for (int i = 0; i < n; i++) {
            Matcher m = p.matcher(sc.nextLine());

            if (m.matches()) {
                String type = m.group(1);
                String correct = m.group(3);
                String student = m.group(4);
                int points = Integer.parseInt(m.group(5));

                Question q;

                if (type.equals("MCQ"))
                    q = new MCQ(correct, student, points);
                else if (type.equals("TF"))
                    q = new TF(correct, student, points);
                else
                    q = new Essay(correct, student, points);

                double score = q.grade();
                System.out.printf("%s: %.2f%n", type, score);
                total += score;
            }
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}