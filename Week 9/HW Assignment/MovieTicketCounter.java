import java.util.Scanner;

abstract class MovieTicket {
static final double FEE = 20.0;
int count;


MovieTicket(int count) {
    this.count = count;
}

abstract double price();

double total() {
    return (price() + FEE) * count;
}


}

class RegularTicket extends MovieTicket {
RegularTicket(int count) {
super(count);
}


double price() {
    return 150;
}


}

class PremiumTicket extends MovieTicket {
PremiumTicket(int count) {
super(count);
}


double price() {
    return 250;
}


}

class ReclinerTicket extends MovieTicket {
ReclinerTicket(int count) {
super(count);
}


double price() {
    return 400;
}


}

public class MovieTicketCounter {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
MovieTicket[] tickets = new MovieTicket[n];
double total = 0;


    for (int i = 0; i < n; i++) {
        String type = sc.next();
        int count = sc.nextInt();

        switch (type) {
            case "REGULAR":
                tickets[i] = new RegularTicket(count);
                break;
            case "PREMIUM":
                tickets[i] = new PremiumTicket(count);
                break;
            case "RECLINER":
                tickets[i] = new ReclinerTicket(count);
                break;
        }
    }

    for (MovieTicket t : tickets) {
        System.out.printf("%s: %.2f%n",
            t.getClass().getSimpleName()
                .replace("Ticket", "").toUpperCase(),
            t.total());
        total += t.total();
    }

    System.out.printf("Total: %.2f%n", total);
    sc.close();
}


}
