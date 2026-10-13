import java.util.Scanner;

abstract class Parcel {
double weight, value;


Parcel(double weight, double value) {
    this.weight = weight;
    this.value = value;
}

abstract double charge();

double insurance() {
    return 0;
}

double total() {
    return charge() + insurance();
}


}

interface Insurable {
double insurance();
}

class StandardParcel extends Parcel {
StandardParcel(double weight, double value) {
super(weight, value);
}


double charge() {
    return 40 + 10 * weight;
}


}

class ExpressParcel extends Parcel implements Insurable {
ExpressParcel(double weight, double value) {
super(weight, value);
}


double charge() {
    return 80 + 15 * weight;
}

public double insurance() {
    return value * 0.02;
}


}

class FragileParcel extends Parcel implements Insurable {
FragileParcel(double weight, double value) {
super(weight, value);
}


double charge() {
    return 40 + 10 * weight + 50;
}

public double insurance() {
    return value * 0.02;
}


}

public class ParcelShippingDesk {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
Parcel[] parcels = new Parcel[n];
String[] types = new String[n];
double grandTotal = 0;


    for (int i = 0; i < n; i++) {
        types[i] = sc.next();
        double weight = sc.nextDouble();
        double value = sc.nextDouble();

        switch (types[i]) {
            case "STANDARD":
                parcels[i] = new StandardParcel(weight, value);
                break;
            case "EXPRESS":
                parcels[i] = new ExpressParcel(weight, value);
                break;
            case "FRAGILE":
                parcels[i] = new FragileParcel(weight, value);
                break;
        }
    }

    for (int i = 0; i < n; i++) {
        Parcel p = parcels[i];

        System.out.printf(
            "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
            types[i], p.charge(), p.insurance(), p.total());

        grandTotal += p.total();
    }

    System.out.printf("Grand Total: %.2f%n", grandTotal);
    sc.close();
}


}
