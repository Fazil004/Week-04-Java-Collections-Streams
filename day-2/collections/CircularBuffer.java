class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void enqueue(int item) {
        if (size == capacity) {
            head = (head + 1) % capacity;
        }
        buffer[tail] = item;
        tail = (tail + 1) % capacity;
        if (size < capacity) {
            size++;
        }
    }

    public Integer dequeue() {
        if (size == 0) {
            return null;
        }
        int item = buffer[head];
        head = (head + 1) % capacity;
        size--;
        return item;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return buffer[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int current = head;
        for (int i = 0; i < size; i++) {
            sb.append(buffer[current]);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = (current + 1) % capacity;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.enqueue(1);
        System.out.println("Buffer: " + buffer);
        buffer.enqueue(2);
        System.out.println("Buffer: " + buffer);
        buffer.enqueue(3);
        System.out.println("Buffer: " + buffer);
        buffer.enqueue(4);
        System.out.println("Buffer: " + buffer);
        buffer.enqueue(5);
        System.out.println("Buffer: " + buffer);

        System.out.println("Dequeue: " + buffer.dequeue());
        System.out.println("Buffer: " + buffer);
        System.out.println("Dequeue: " + buffer.dequeue());
        System.out.println("Buffer: " + buffer);
        buffer.enqueue(6);
        System.out.println("Buffer: " + buffer);
    }
}