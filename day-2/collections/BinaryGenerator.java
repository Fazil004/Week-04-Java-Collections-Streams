import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

class BinaryGenerator {
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        result.add("1");
        for (int i = 1; i < n; i++) {
            String current = queue.remove();
            String s1 = current + "0";
            String s2 = current + "1";
            queue.add(s1);
            queue.add(s2);
            result.add(s1);
            if (result.size() < n) {
                result.add(s2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n1 = 5;
        List<String> binaryNumbers1 = generateBinaryNumbers(n1);
        System.out.println("N=" + n1 + " --> Output: " + binaryNumbers1);

        int n2 = 10;
        List<String> binaryNumbers2 = generateBinaryNumbers(n2);
        System.out.println("N=" + n2 + " --> Output: " + binaryNumbers2);

        int n3 = 0;
        List<String> binaryNumbers3 = generateBinaryNumbers(n3);
        System.out.println("N=" + n3 + " --> Output: " + binaryNumbers3);

        int n4 = 1;
        List<String> binaryNumbers4 = generateBinaryNumbers(n4);
        System.out.println("N=" + n4 + " --> Output: " + binaryNumbers4);
    }
}