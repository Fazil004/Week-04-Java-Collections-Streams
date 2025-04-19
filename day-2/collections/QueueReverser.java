import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class QueueReverser {
    public static <T> Queue<T> reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Input: " + queue);
        Queue<Integer> reversedQueue = reverseQueue(queue);
        System.out.println("Output: " + reversedQueue);

        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("A");
        stringQueue.add("B");
        stringQueue.add("C");
        System.out.println("Input: " + stringQueue);
        Queue<String> reversedStringQueue = reverseQueue(stringQueue);
        System.out.println("Output: " + reversedStringQueue);

        Queue<Integer> emptyQueue = new LinkedList<>();
        System.out.println("Input: " + emptyQueue);
        Queue<Integer> reversedEmptyQueue = reverseQueue(emptyQueue);
        System.out.println("Output: " + reversedEmptyQueue);
    }
}