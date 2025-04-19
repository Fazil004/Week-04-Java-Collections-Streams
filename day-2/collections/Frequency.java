import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Frequency {
    public Map<String, Integer> findFrequency(List<String> strings) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        List<String> inputList = List.of("apple", "banana", "apple", "orange");
        Frequency solution = new Frequency();
        Map<String, Integer> frequency = solution.findFrequency(inputList);
        System.out.println(frequency);
    }
}

