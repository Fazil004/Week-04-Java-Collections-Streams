public class SSNValidator {
    public static boolean validateSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        System.out.println("123-45-6789: " + validateSSN("123-45-6789"));
        System.out.println("123456789: " + validateSSN("123456789"));
    }
}
