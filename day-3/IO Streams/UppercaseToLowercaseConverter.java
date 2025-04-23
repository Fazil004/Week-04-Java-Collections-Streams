import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UppercaseToLowercaseConverter {

    public static void convertToUpperToLower(String sourcePath, String destinationPath) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(sourcePath, StandardCharsets.UTF_8));
            writer = new BufferedWriter(new FileWriter(destinationPath, StandardCharsets.UTF_8));

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase(character));
            }

            System.out.println("File converted successfully from " + sourcePath + " to " + destinationPath);

        } catch (IOException e) {
            System.err.println("Error during file conversion: " + e.getMessage());
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

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java UppercaseToLowercaseConverter <source_file_path> <destination_file_path>");
            return;
        }

        String sourceFile = args[0];
        String destinationFile = args[1];

        convertToUpperToLower(sourceFile, destinationFile);
    }
}