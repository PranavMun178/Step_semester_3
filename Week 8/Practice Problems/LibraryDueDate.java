import java.util.*;
import java.time.*;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int days();
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int days() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int days() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int days() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        LocalDate current = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).replace("\"", "");

            LibraryItem item;

            switch (type) {
                case "BOOK" -> item = new Book(title);
                case "DVD" -> item = new DVD(title);
                default -> item = new Magazine(title);
            }

            System.out.println(title + ": " + current.plusDays(item.days()));
        }

        sc.close();
    }
}