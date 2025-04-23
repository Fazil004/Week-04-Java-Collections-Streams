import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LargeFileErrorReader {

    public static void findErrorLines(String filePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
            String line;
            long lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing reader: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java LargeFileErrorReader <file_path>");
            return;
        }

        String filePath = args[0];
        System.out.println("Scanning file: " + filePath + " for lines containing 'error' (case insensitive)...");
        findErrorLines(filePath);
        System.out.println("Scanning complete.");
    }
}