import java.util.HashSet;
import java.util.Set;

class SetOperationTwo {
    
    public <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> difference = new HashSet<>(set1); 
        difference.addAll(set2);

        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);            

        difference.removeAll(intersection);        

        return difference;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        SetOperationTwo solution = new SetOperationTwo();
        Set<Integer> symmetricDiff = solution.symmetricDifference(set1, set2);
        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " --> Symmetric Difference: " + symmetricDiff);

        Set<String> setA = new HashSet<>();
        setA.add("apple");
        setA.add("banana");
        setA.add("cherry");

        Set<String> setB = new HashSet<>();
        setB.add("banana");
        setB.add("date");
        setB.add("elderberry");

        Set<String> symmetricDiffString = solution.symmetricDifference(setA, setB);
        System.out.println("Set1: " + setA + ", Set2: " + setB + " --> Symmetric Difference: " + symmetricDiffString);
    }
}