package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }


    public String readFromFile(String filename) throws IOException{
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            return null; // Handle file not found as a specific case
        }
        return content.toString().trim();
    }

    public boolean doesFileExist(String filename) {
        return Files.exists(Paths.get(filename));
    }
}