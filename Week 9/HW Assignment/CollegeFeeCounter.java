import java.util.Scanner;

abstract class StudentFee {
String name;


StudentFee(String name) {
    this.name = name;
}

abstract double tuition();

boolean usesBus() {
    return false;
}

double totalFee() {
    return tuition() + (usesBus() ? 12000 : 0);
}


}

class DayScholar extends StudentFee {
DayScholar(String name) {
super(name);
}


double tuition() {
    return 40000;
}

boolean usesBus() {
    return true;
}


}

class Hosteller extends StudentFee {
Hosteller(String name) {
super(name);
}


double tuition() {
    return 40000 + 60000;
}


}

class ScholarshipStudent extends StudentFee {
ScholarshipStudent(String name) {
super(name);
}


double tuition() {
    return 20000;
}

boolean usesBus() {
    return true;
}


}

public class CollegeFeeCounter {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
StudentFee[] students = new StudentFee[n];
double total = 0;


    for (int i = 0; i < n; i++) {
        String type = sc.next();
        String name = sc.next();

        switch (type) {
            case "DAY_SCHOLAR":
                students[i] = new DayScholar(name);
                break;
            case "HOSTELLER":
                students[i] = new Hosteller(name);
                break;
            case "SCHOLAR":
                students[i] = new ScholarshipStudent(name);
                break;
        }
    }

    for (StudentFee s : students) {
        System.out.printf("%s: %.2f%n",
            s.name, s.totalFee());
        total += s.totalFee();
    }

    System.out.printf("Total Collected: %.2f%n", total);
    sc.close();
}


}
