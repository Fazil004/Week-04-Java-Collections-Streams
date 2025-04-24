import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter the index to access: ");
            int index = scanner.nextInt();

            try {
                int element = numbers[index];
                System.out.print("Enter the divisor: ");
                int divisor = scanner.nextInt();
                try {
                    if (divisor == 0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }
                    double result = (double) element / divisor;
                    System.out.println("Result of division: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid array index!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter integers.");
        } finally {
            scanner.close();
        }
    }
}