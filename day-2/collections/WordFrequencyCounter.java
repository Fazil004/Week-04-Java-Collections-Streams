import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return wordFrequencies;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java WordFrequencyCounter <file_path>");
            return;
        }
        String filePath = args[0];
        Map<String, Integer> frequencyMap = countWordFrequency(filePath);
        System.out.println("Word Frequencies:");
        frequencyMap.forEach((word, count) -> System.out.println(word + "=" + count));
    }
}