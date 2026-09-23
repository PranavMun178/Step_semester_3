class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            return true;
        } else {
            System.out.println("Change code rejected: Incorrect current code.");
            return false;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerMain {
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");
        
        boolean firstChange = locker.changeCode("1234", "5678");
        System.out.println("Change code with '1234' success: " + firstChange);
        
        boolean secondChange = locker.changeCode("0000", "9999");
        System.out.println("Change code with '0000' success: " + secondChange);
    }
}