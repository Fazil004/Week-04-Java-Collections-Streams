import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ImageToByteArray {

    public static byte[] imageToByteArray(String imagePath) throws IOException {
        try (InputStream inputStream = new FileInputStream(imagePath);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }

    public static void byteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
             OutputStream outputStream = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static boolean areFilesIdentical(String filePath1, String filePath2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(Paths.get(filePath1));
        byte[] file2Bytes = Files.readAllBytes(Paths.get(filePath2));
        return Arrays.equals(file1Bytes, file2Bytes);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ImageToByteArray <input_image_path> <output_image_path>");
            return;
        }

        String inputImagePath = args[0];
        String outputImagePath = args[1];

        try {
            byte[] imageData = imageToByteArray(inputImagePath);
            System.out.println("Image converted to byte array. Size: " + imageData.length + " bytes.");

            byteArrayToImage(imageData, outputImagePath);
            System.out.println("Byte array written to " + outputImagePath);

            boolean identical = areFilesIdentical(inputImagePath, outputImagePath);
            if (identical) {
                System.out.println("Verification successful: " + outputImagePath + " is identical to " + inputImagePath);
            } else {
                System.out.println("Verification failed: " + outputImagePath + " is NOT identical to " + inputImagePath);
            }

        } catch (IOException e) {
            System.err.println("Error during image processing: " + e.getMessage());
        }
    }
}