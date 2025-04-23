import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class DataWriter implements Runnable {
    private OutputStream outputStream;

    public DataWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                String data = "Data " + i + "\n";
                synchronized (outputStream) {
                    outputStream.write(data.getBytes());
                    System.out.println("Writer wrote: " + data.trim());
                    outputStream.notify(); // Notify the reader that data is available
                }
                Thread.sleep(100); // Simulate some processing time
            }
            synchronized (outputStream) {
                outputStream.write("END\n".getBytes()); // Signal end of data
                outputStream.notify();
            }
        } catch (IOException e) {
            System.err.println("Error in writer thread: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Writer thread interrupted.");
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                System.err.println("Error closing output stream: " + e.getMessage());
            }
        }
    }
}

class DataReader implements Runnable {
    private InputStream inputStream;

    public DataReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[32];
            int bytesRead;
            String receivedData = "";
            while (true) {
                synchronized (inputStream) {
                    while (inputStream.available() == 0) {
                        inputStream.wait(); // Wait for data to be available
                    }
                    bytesRead = inputStream.read(buffer);
                    if (bytesRead == -1) {
                        break; // End of stream
                    }
                    receivedData = new String(buffer, 0, bytesRead);
                }
                System.out.println("Reader read: " + receivedData.trim());
                if (receivedData.trim().equals("END")) {
                    break;
                }
                Thread.sleep(50); // Simulate some processing time
            }
        } catch (IOException e) {
            System.err.println("Error in reader thread: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Reader thread interrupted.");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.err.println("Error closing input stream: " + e.getMessage());
            }
        }
    }
}

public class PipedStreamCommunication {

    public static void main(String[] args) {
        try (PipedOutputStream pipedOutputStream = new PipedOutputStream();
             PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream)) {

            DataWriter writer = new DataWriter(pipedOutputStream);
            DataReader reader = new DataReader(pipedInputStream);

            Thread writerThread = new Thread(writer);
            Thread readerThread = new Thread(reader);

            System.out.println("Starting communication between writer and reader threads");
            writerThread.start();
            readerThread.start();

            // Wait for threads to finish
            writerThread.join();
            readerThread.join();

            System.out.println("Communication finished.");

        } catch (IOException e) {
            System.err.println("Error creating piped streams: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted.");
        }
    }
}