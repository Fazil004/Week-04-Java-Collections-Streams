import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionHandler {

    public static void main(String[] args) {
        String filename = "data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contents of " + filename + ":");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found: " + filename);

        }
    }
}