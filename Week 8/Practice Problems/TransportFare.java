import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double fare();
}

class Bus extends Transport {
    Bus(double d) {
        super(d);
    }

    double fare() {
        return Math.min(10, 2 + 0.1 * distance);
    }
}

class Train extends Transport {
    Train(double d) {
        super(d);
    }

    double fare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double factor;

    Metro(double d, double f) {
        super(d);
        factor = f;
    }

    double fare() {
        return (1.5 + 0.2 * distance) * factor;
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport t;

            if (type.equals("BUS"))
                t = new Bus(distance);
            else if (type.equals("TRAIN"))
                t = new Train(distance);
            else
                t = new Metro(distance, sc.nextDouble());

            double fare = t.fare();
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}