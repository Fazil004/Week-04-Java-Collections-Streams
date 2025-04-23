import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputToFile {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = null;

        try {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String ageStr = reader.readLine();
            int age = Integer.parseInt(ageStr);

            System.out.print("Enter your favorite programming language: ");
            String favoriteLanguage = reader.readLine();

            writer = new FileWriter("user_info.txt");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + favoriteLanguage + "\n");

            System.out.println("Information saved to user_info.txt");

        } catch (IOException e) {
            System.err.println("Error reading from console: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid age format. Please enter a number.");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}