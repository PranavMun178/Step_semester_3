import java.util.Scanner;

abstract class Appliance {
double hours;


Appliance(double hours) {
    this.hours = hours;
}

abstract double power();

double units() {
    return power() * hours / 1000;
}

double cost() {
    return units() * 8;
}


}

interface SaverMode {
double savedUnits();
}

class Fridge extends Appliance {
Fridge(double hours) {
super(hours);
}


double power() {
    return 150;
}


}

class AirConditioner extends Appliance implements SaverMode {
AirConditioner(double hours) {
super(hours);
}


double power() {
    return 1500;
}

public double savedUnits() {
    return units() * 0.75;
}


}

class Television extends Appliance {
Television(double hours) {
super(hours);
}


double power() {
    return 100;
}


}

class WashingMachine extends Appliance implements SaverMode {
WashingMachine(double hours) {
super(hours);
}


double power() {
    return 500;
}

public double savedUnits() {
    return units() * 0.75;
}


}

public class HomeApplianceEnergyReport {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
double total = 0;


    for (int i = 0; i < n; i++) {
        String type = sc.next();
        double hours = sc.nextDouble();

        boolean saver = sc.hasNext("SAVER");
        if (saver) {
            sc.next();
        }

        Appliance appliance;

        switch (type) {
            case "FRIDGE":
                appliance = new Fridge(hours);
                break;
            case "AC":
                appliance = new AirConditioner(hours);
                break;
            case "TV":
                appliance = new Television(hours);
                break;
            default:
                appliance = new WashingMachine(hours);
        }

        if (saver && !(appliance instanceof SaverMode)) {
            System.out.println(
                type + ": saver mode not supported");
            continue;
        }

        double units = appliance.units();

        if (saver) {
            SaverMode mode = (SaverMode) appliance;
            units = mode.savedUnits();
        }

        double cost = units * 8;

        System.out.printf(
            "%s: Units=%.2f Cost=%.2f%n",
            type, units, cost);

        total += cost;
    }

    System.out.printf("Total Cost: %.2f%n", total);
    sc.close();
}


}
