import java.util.HashSet;
import java.util.Set;

class SetOperation {
    public <T> Set<T> unionOfSets(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1); 
        unionSet.addAll(set2);
        return unionSet;
    }

    public <T> Set<T> intersectionOfSets(Set<T> set1, Set<T> set2) {
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2); 
        return intersectionSet;
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

        SetOperation solution = new SetOperation();

        Set<Integer> union = solution.unionOfSets(set1, set2);
        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " --> Union: " + union);
        

        Set<Integer> intersection = solution.intersectionOfSets(set1, set2);
        System.out.println("Set1: " + set1 + ", Set2: " + set2 + " --> Intersection: " + intersection);
    }
}