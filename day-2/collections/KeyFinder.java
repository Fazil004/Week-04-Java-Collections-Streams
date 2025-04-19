import java.util.HashMap;
import java.util.Map;

class KeyFinder {
    public static String findKeyWithHighestValue(Map<String, Integer> inputMap) {
        if (inputMap == null || inputMap.isEmpty()) {
            return null;
        }

        String maxKey = null;
        Integer maxValue = null;

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            String currentKey = entry.getKey();
            Integer currentValue = entry.getValue();

            if (maxValue == null || currentValue > maxValue) {
                maxValue = currentValue;
                maxKey = currentKey;
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 15);
        System.out.println("Input: " + map1 + " → Output: " + findKeyWithHighestValue(map1));

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("X", 5);
        map2.put("Y", 5);
        map2.put("Z", 3);
        System.out.println("Input: " + map2 + " → Output: " + findKeyWithHighestValue(map2)); // Output could be X or Y

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("One", 1);
        System.out.println("Input: " + map3 + " → Output: " + findKeyWithHighestValue(map3));

        Map<String, Integer> emptyMap = new HashMap<>();
        System.out.println("Input: " + emptyMap + " → Output: " + findKeyWithHighestValue(emptyMap));

        Map<String, Integer> map4 = null;
        System.out.println("Input: " + map4 + " → Output: " + findKeyWithHighestValue(map4));
    }
}