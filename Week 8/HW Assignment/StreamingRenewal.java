import java.util.*;

abstract class Plan {
    String name;
    String startDate;

    Plan(String name, String startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validity();
}

class Basic extends Plan {
    Basic(String name, String startDate) {
        super(name, startDate);
    }

    int validity() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, String startDate) {
        super(name, startDate);
    }

    int validity() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, String startDate) {
        super(name, startDate);
    }

    int validity() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();
            Plan p;

            switch (type) {
                case "BASIC" -> p = new Basic(name, date);
                case "STANDARD" -> p = new Standard(name, date);
                default -> p = new Premium(name, date);
            }

            System.out.println(name + ": " +
                java.time.LocalDate.parse(date).plusDays(p.validity()));
        }
    sc.close();
    }
}