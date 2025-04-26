package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;

public class FileProcessorTest {

    private final FileProcessor fileProcessor = new FileProcessor();

    @TempDir
    Path tempDir; // JUnit will create and delete this temporary directory

    @Test
    void testWriteAndReadFromFile() throws IOException {
        // Use a file in the temporary directory
        String filename = tempDir.resolve("testfile.txt").toString();
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(filename, content);
        String readContent = fileProcessor.readFromFile(filename);
        assertEquals(content, readContent, "Content read should match content written");
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        String filename = tempDir.resolve("testfile.txt").toString();
        String content = "Some content";
        fileProcessor.writeToFile(filename, content);
        assertTrue(fileProcessor.doesFileExist(filename), "File should exist after writing");
    }

    @Test
    void testReadFromFile_fileNotFound() throws IOException {
        String nonExistentFile = tempDir.resolve("nonexistent.txt").toString();
        String readContent = fileProcessor.readFromFile(nonExistentFile);
        assertNull(readContent, "Reading a non-existent file should return null");
    }

    @Test
    void testWriteToFile_ioException() {
        //  Forcing an IOException during writing is difficult with a temp dir.
        //  This test demonstrates how you *would* test it if you could reliably force the exception.
        String filename = "/invalid/path/testfile.txt"; //  invalid path.
        String content = "Test content";
        assertThrows(IOException.class, () -> {
            fileProcessor.writeToFile(filename, content);
        });
    }
}