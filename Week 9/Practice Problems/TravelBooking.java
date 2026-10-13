import java.util.Scanner;

abstract class TravelMode {
static final double BOOKING_FEE = 50.0;
double distance;


TravelMode(double distance) {
    this.distance = distance;
}

abstract double fare();

double total() {
    return fare() + BOOKING_FEE;
}


}

class BusTravel extends TravelMode {
BusTravel(double distance) {
super(distance);
}


double fare() {
    return distance * 2;
}


}

class TrainTravel extends TravelMode {
TrainTravel(double distance) {
super(distance);
}


double fare() {
    return distance * 1.5;
}


}

class FlightTravel extends TravelMode {
FlightTravel(double distance) {
super(distance);
}


double fare() {
    return 2500 + distance * 4;
}


}

public class TravelBooking {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
TravelMode[] bookings = new TravelMode[n];


    for (int i = 0; i < n; i++) {
        String mode = sc.next();
        double distance = sc.nextDouble();

        switch (mode) {
            case "BUS":
                bookings[i] = new BusTravel(distance);
                break;
            case "TRAIN":
                bookings[i] = new TrainTravel(distance);
                break;
            case "FLIGHT":
                bookings[i] = new FlightTravel(distance);
                break;
        }
    }

    for (TravelMode t : bookings) {
        System.out.printf("%s: %.2f%n",
            t.getClass().getSimpleName()
                .replace("Travel", "").toUpperCase(),
            t.total());
    }

    sc.close();
}


}
