import java.util.Scanner;

public class MultipleCatchBlocks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null; // Initially null

        try {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            array = new int[size];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();

            int value = array[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Error: Array is not initialized!");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}