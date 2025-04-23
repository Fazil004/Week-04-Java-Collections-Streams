import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedFileCopy {

    private static final int BUFFER_SIZE = 4096;

    public static void copyFileUnbuffered(String sourcePath, String destinationPath) {
        long startTime = System.nanoTime();
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(sourcePath);
            outputStream = new FileOutputStream(destinationPath);

            int bytesRead;
            while ((bytesRead = inputStream.read()) != -1) {
                outputStream.write(bytesRead);
            }

        } catch (IOException e) {
            System.err.println("Error during unbuffered file copy: " + e.getMessage());
        } finally {
            closeStreams(inputStream, outputStream);
        }
        long endTime = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void copyFileBuffered(String sourcePath, String destinationPath) {
        long startTime = System.nanoTime();
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath), BUFFER_SIZE);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationPath), BUFFER_SIZE);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.err.println("Error during buffered file copy: " + e.getMessage());
        } finally {
            closeStreams(bufferedInputStream, bufferedOutputStream);
        }
        long endTime = System.nanoTime();
        System.out.println("Buffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void closeStreams(InputStream inputStream, OutputStream outputStream) {
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

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java BufferedFileCopy <source_file_path> <destination_file_path>");
            return;
        }

        String sourceFile = args[0];
        String destinationFile = args[1];

        // Create a dummy large file for testing if it doesn't exist
        java.io.File source = new java.io.File(sourceFile);
        if (!source.exists() || source.length() < 100 * 1024 * 1024) {
            System.out.println("Creating a dummy 100MB file for testing...");
            try (FileOutputStream fos = new FileOutputStream(sourceFile)) {
                byte[] buffer = new byte[1024];
                for (int i = 0; i < 100 * 1024; i++) { // Write 100 * 1024 KB = 100 MB
                    fos.write(buffer);
                }
            }
        }

        System.out.println("Starting file copy with unbuffered streams:");
        copyFileUnbuffered(sourceFile, destinationFile + "_unbuffered");

        System.out.println("\nStarting file copy with buffered streams:");
        copyFileBuffered(sourceFile, destinationFile + "_buffered");
    }
}