import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SetToSortedList {
    
    public List<Integer> convertSetToSortedList(Set<Integer> integerSet) {
        List<Integer> integerList = new ArrayList<>(integerSet);

        Collections.sort(integerList);

        return integerList;
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>();
        inputSet.add(5);
        inputSet.add(3);
        inputSet.add(9);
        inputSet.add(1);

        SetToSortedList solution = new SetToSortedList();
        List<Integer> sortedList = solution.convertSetToSortedList(inputSet);
        System.out.println("Input: " + inputSet + " --> Output: " + sortedList);
        

        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(15);
        anotherSet.add(2);
        anotherSet.add(20);
        anotherSet.add(7);
        anotherSet.add(2);
        List<Integer> anotherSortedList = solution.convertSetToSortedList(anotherSet);
        System.out.println("Input: " + anotherSet + " --> Output: " + anotherSortedList);
        

        Set<Integer> emptySet = new HashSet<>();
        List<Integer> emptySortedList = solution.convertSetToSortedList(emptySet);
        System.out.println("Input: " + emptySet + " --> Output: " + emptySortedList);
    }
}