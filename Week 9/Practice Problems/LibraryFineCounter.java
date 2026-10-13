import java.util.Scanner;

abstract class LibraryItem {
String title;
int daysLate;


LibraryItem(String title, int daysLate) {
    this.title = title;
    this.daysLate = daysLate;
}

abstract double fine();


}

class BookItem extends LibraryItem {
BookItem(String title, int daysLate) {
super(title, daysLate);
}


double fine() {
    return daysLate * 2.0;
}


}

class DVDItem extends LibraryItem {
DVDItem(String title, int daysLate) {
super(title, daysLate);
}


double fine() {
    return Math.min(daysLate * 5.0, 50.0);
}


}

class MagazineItem extends LibraryItem {
MagazineItem(String title, int daysLate) {
super(title, daysLate);
}

double fine() {
    return daysLate * 1.0;
}

}

public class LibraryFineCounter {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
LibraryItem[] items = new LibraryItem[n];
double total = 0;

    for (int i = 0; i < n; i++) {
        String type = sc.next();
        String title = sc.next();
        int days = sc.nextInt();

        switch (type) {
            case "BOOK":
                items[i] = new BookItem(title, days);
                break;
            case "DVD":
                items[i] = new DVDItem(title, days);
                break;
            case "MAGAZINE":
                items[i] = new MagazineItem(title, days);
                break;
        }
    }

    for (LibraryItem item : items) {
        System.out.printf("%s: %.2f%n",
            item.title, item.fine());
        total += item.fine();
    }

    System.out.printf("Total Fines: %.2f%n", total);
    sc.close();
}

}
