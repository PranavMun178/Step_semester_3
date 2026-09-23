public class IsbnValidator {

    // Step 1: Normalize - Trim spaces and uppercase only the first 3 letters
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed; // Too short to split safely
        }

        String publisherPart = trimmed.substring(0, 3).toUpperCase();
        String remainingPart = trimmed.substring(3);

        return publisherPart + remainingPart;
    }

    // Step 2: Validate and Format
    public static String validateAndFormat(String code) {
        // 1. Check length
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        // 2. Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // 3. Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // 4. Build formatted string if all checks pass
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(publisher).append("] ")
          .append("YEAR: ").append(year).append(" | ")
          .append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test Case 1: Valid raw code
        String raw1 = "  pen2026004251 ";
        String normalized1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(normalized1));
        // Output: [PEN] YEAR: 2026 | CATALOG: 004251

        // Test Case 2: Non-letter publisher code
        String raw2 = "12N2026004251";
        String normalized2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(normalized2));
        // Output: Invalid: publisher code must be 3 letters
    }
}