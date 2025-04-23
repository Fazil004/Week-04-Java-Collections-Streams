import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {

    public static void countWords(String filePath) {
        Map<String, Integer> wordCounts = new HashMap<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words, removing punctuation and converting to lowercase
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort words by frequency in descending order
            List<Map.Entry<String, Integer>> sortedWords = wordCounts.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toList());

            System.out.println("Total number of words: " + wordCounts.values().stream().mapToInt(Integer::intValue).sum());
            System.out.println("\nTop 5 most frequent words:");
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
                if (count == 5) {
                    break;
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
            System.out.println("Usage: java WordCounter <file_path>");
            return;
        }

        String filePath = args[0];
        System.out.println("Counting words in file: " + filePath + "...");
        countWords(filePath);
        System.out.println("Word counting complete.");
    }
}