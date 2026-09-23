public class ATMPINValidator {

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        // Sample Tests
        checkPinLength("482");   // Invalid output
        checkPinLength("4820");  // Valid output
    }
}