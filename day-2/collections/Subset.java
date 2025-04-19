import java.util.HashSet;
import java.util.Set;

class Subset {
    
    public <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Subset solution = new Subset();
        boolean isSubset1 = solution.isSubset(set1, set2);
        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " --> Is Subset: " + isSubset1);
        

        Set<String> setA = new HashSet<>();
        setA.add("apple");
        setA.add("banana");

        Set<String> setB = new HashSet<>();
        setB.add("banana");
        setB.add("orange");
        setB.add("apple");

        boolean isSubset2 = solution.isSubset(setA, setB);
        System.out.println("Set1: " + setA + ", Set2: " + setB + " --> Is Subset: " + isSubset2);
        

        Set<Integer> setC = new HashSet<>();
        setC.add(5);
        setC.add(6);

        Set<Integer> setD = new HashSet<>();
        setD.add(6);
        setD.add(7);

        boolean isSubset3 = solution.isSubset(setC, setD);
        System.out.println("Set1: " + setC + ", Set2: " + setD + " --> Is Subset: " + isSubset3);
        

        Set<Integer> emptySet = new HashSet<>();
        Set<Integer> nonEmptySet = new HashSet<>();
        nonEmptySet.add(1);

        boolean isSubset4 = solution.isSubset(emptySet, nonEmptySet);
        System.out.println("Set1: " + emptySet + ", Set2: " + nonEmptySet + " --> Is Subset: " + isSubset4);

        boolean isSubset5 = solution.isSubset(nonEmptySet, emptySet);
        System.out.println("Set1: " + nonEmptySet + ", Set2: " + emptySet + " --> Is Subset: " + isSubset5);
    }
}