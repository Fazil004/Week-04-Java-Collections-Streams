import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void copyFile(String sourcePath, String destinationPath) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(sourcePath);
            outputStream = new FileOutputStream(destinationPath);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully from " + sourcePath + " to " + destinationPath);

        } catch (IOException e) {
            System.err.println("Error during file operation: " + e.getMessage());
            if (e.getMessage().startsWith("No such file or directory")) {
                System.err.println("Source file not found: " + sourcePath);
            }
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileCopy <source_file_path> <destination_file_path>");
            return;
        }

        String sourceFile = args[0];
        String destinationFile = args[1];

        copyFile(sourceFile, destinationFile);
    }
}