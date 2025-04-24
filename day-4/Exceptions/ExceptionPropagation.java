public class ExceptionPropagation {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive.");
        }
        return amount * rate * years;
    }

    public static void main(String[] args) {
        double principal = 1000;
        double interestRate = 0.05;
        int timeYears = 3;

        try {
            double interest = calculateInterest(principal, interestRate, timeYears);
            System.out.println("Calculated interest: " + interest);

            double invalidPrincipal = -500;
            double invalidRate = 0.08;
            int validYears = 2;
            calculateInterest(invalidPrincipal, invalidRate, validYears); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid input: " + e.getMessage());
        }
    }
}