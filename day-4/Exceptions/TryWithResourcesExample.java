import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

    public static void main(String[] args) {
        String filename = "info.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                System.out.println("First line of " + filename + ": " + firstLine);
            } else {
                System.out.println(filename + " is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
            // You can also log the exception for debugging
            // e.printStackTrace();
        }
    }
}