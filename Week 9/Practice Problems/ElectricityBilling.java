import java.util.Scanner;

abstract class Connection {
double units;


Connection(double units) {
    this.units = units;
}

abstract double bill();


}

class HomeConnection extends Connection {
HomeConnection(double units) {
super(units);
}


double bill() {
    if (units <= 100)
        return units * 5;
    return 500 + (units - 100) * 7;
}


}

class ShopConnection extends Connection {
ShopConnection(double units) {
super(units);
}


double bill() {
    return units * 8 + 100;
}


}

class FactoryConnection extends Connection {
FactoryConnection(double units) {
super(units);
}


double bill() {
    return Math.max(units * 6, 1000);
}


}

public class ElectricityBilling {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
Connection[] connections = new Connection[n];
double total = 0;


    for (int i = 0; i < n; i++) {
        String type = sc.next();
        double units = sc.nextDouble();

        switch (type) {
            case "HOME":
                connections[i] = new HomeConnection(units);
                break;
            case "SHOP":
                connections[i] = new ShopConnection(units);
                break;
            case "FACTORY":
                connections[i] = new FactoryConnection(units);
                break;
        }
    }

    for (Connection c : connections) {
        System.out.printf("%s: %.2f%n",
            c.getClass().getSimpleName()
                .replace("Connection", "").toUpperCase(),
            c.bill());
        total += c.bill();
    }

    System.out.printf("Total: %.2f%n", total);
    sc.close();
}


}
