import java.util.HashMap;
import java.util.Map;

class MapMerger {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            mergedMap.put(key, mergedMap.getOrDefault(key, 0) + value);
        }
        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        System.out.println("Map1: " + map1 + ", Map2: " + map2 + " → Output: " + mergeMaps(map1, map2));

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("X", 10);
        map3.put("Y", 20);
        Map<String, Integer> map4 = new HashMap<>();
        map4.put("Y", 5);
        map4.put("Z", 15);
        System.out.println("Map1: " + map3 + ", Map2: " + map4 + " → Output: " + mergeMaps(map3, map4));

        Map<String, Integer> emptyMap1 = new HashMap<>();
        Map<String, Integer> nonEmptyMap = new HashMap<>();
        nonEmptyMap.put("P", 7);
        System.out.println("Map1: " + emptyMap1 + ", Map2: " + nonEmptyMap + " → Output: " + mergeMaps(emptyMap1, nonEmptyMap));

        Map<String, Integer> nonEmptyMap2 = new HashMap<>();
        nonEmptyMap2.put("Q", 9);
        Map<String, Integer> emptyMap2 = new HashMap<>();
        System.out.println("Map1: " + nonEmptyMap2 + ", Map2: " + emptyMap2 + " → Output: " + mergeMaps(nonEmptyMap2, emptyMap2));

        Map<String, Integer> emptyMap3 = new HashMap<>();
        Map<String, Integer> emptyMap4 = new HashMap<>();
        System.out.println("Map1: " + emptyMap3 + ", Map2: " + emptyMap4 + " → Output: " + mergeMaps(emptyMap3, emptyMap4));
    }
}