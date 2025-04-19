import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MapInverter {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 1);
        System.out.println("Input: " + map1);
        Map<Integer, List<String>> invertedMap1 = invertMap(map1);
        System.out.println("Output: " + invertedMap1);

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(10, "X");
        map2.put(20, "Y");
        map2.put(30, "X");
        map2.put(40, "Z");
        System.out.println("Input: " + map2);
        Map<String, List<Integer>> invertedMap2 = invertMap(map2);
        System.out.println("Output: " + invertedMap2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("one", "value");
        map3.put("two", "another");
        map3.put("three", "value");
        System.out.println("Input: " + map3);
        Map<String, List<String>> invertedMap3 = invertMap(map3);
        System.out.println("Output: " + invertedMap3);

        Map<String, Integer> emptyMap = new HashMap<>();
        System.out.println("Input: " + emptyMap);
        Map<Integer, List<String>> invertedEmptyMap = invertMap(emptyMap);
        System.out.println("Output: " + invertedEmptyMap);
    }
}