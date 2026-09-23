class HostelRoom {
    String roomNo;
    int occupied;
}

public class HostelTracker {
    public static void main(String[] args) {
        HostelRoom roomA = new HostelRoom();
        HostelRoom roomB = new HostelRoom();

        roomA.roomNo = "C-101";
        roomB.roomNo = "C-102";

        roomA.occupied++;
        roomA.occupied++;
        roomA.occupied++;

        System.out.println("C101 -occupied:\n" + roomA.occupied);
        System.out.println("C102 -occupied:\n" + roomB.occupied);
    }
}