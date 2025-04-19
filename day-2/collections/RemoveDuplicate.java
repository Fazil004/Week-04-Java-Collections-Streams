import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class RemoveDuplicate {
  
    public List<Integer> removeDuplicatesOrdered(List<Integer> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        Set<Integer> uniqueElements = new LinkedHashSet<>(list);

        return new ArrayList<>(uniqueElements);
    }

    public static void main(String[] args) {
        List<Integer> inputList = List.of(3, 1, 2, 2, 3, 4);
        RemoveDuplicate solution = new RemoveDuplicate();
        List<Integer> result = solution.removeDuplicatesOrdered(inputList);
        System.out.println("Input: " + inputList + " --> Output: " + result);

    }
}