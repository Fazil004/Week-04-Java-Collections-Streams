import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionHandler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            if (denominator == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            double result = (double) numerator / denominator;
            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values only.");
        } finally {
            scanner.close();
        }
    }
}