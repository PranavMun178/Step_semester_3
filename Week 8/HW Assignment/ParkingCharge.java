import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double charge() {
        return hours * 10;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double charge() {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double charge() {
        return Math.max(100, hours * 50);
    }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle v;

            switch (type) {
                case "BIKE" -> v = new Bike(hours);
                case "CAR" -> v = new Car(hours);
                default -> v = new Truck(hours);
            }

            double charge = v.charge();
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    sc.close(); 
    }
}