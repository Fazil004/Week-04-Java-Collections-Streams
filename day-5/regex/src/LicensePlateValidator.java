public class LicensePlateValidator {
    public static boolean validateLicensePlate(String licensePlate) {
        return licensePlate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        System.out.println("AB1234: " + validateLicensePlate("AB1234"));
        System.out.println("A12345: " + validateLicensePlate("A12345"));
    }
}