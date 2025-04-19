import java.util.LinkedList;

class EndElement {
    public <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return null;
        }

        int size = list.size();
        if (n > size) {
            return null;
        }

        int indexFromStart = size - n;
        return list.get(indexFromStart);
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        int n = 2;
        EndElement solution = new EndElement();
        String nthElement = solution.findNthFromEnd(list, n);
        System.out.println("Input: " + list + ", N=" + n + " --> Output: " + nthElement);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        int n2 = 3;
        Integer nthElement2 = solution.findNthFromEnd(list2, n2);
        System.out.println("Input: " + list2 + ", N=" + n2 + " --> Output: " + nthElement2);

        LinkedList<Character> list3 = new LinkedList<>();
        list3.add('X');
        int n3 = 5;
        Character nthElement3 = solution.findNthFromEnd(list3, n3);
        System.out.println("Input: " + list3 + ", N=" + n3 + " --> Output: " + nthElement3);

        LinkedList<String> emptyList = new LinkedList<>();
        int n4 = 1;
        String nthElement4 = solution.findNthFromEnd(emptyList, n4);
        System.out.println("Input: " + emptyList + ", N=" + n4 + " --> Output: " + nthElement4);
    }
}