public class Queue<T> {
    private Object[] array;
    private int head = 0, tail = 0, count = 0;

    public Queue(int capacity) {
        array = new Object[capacity];
    }

    public void enqueue(T x) {
        if (count == array.length) grow();
        array[tail] = x;
        tail = (tail + 1) % array.length;
        count++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (count == 0) throw new RuntimeException("Queue empty");
        T val = (T) array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        count--;
        return val;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void grow() {
        Object[] old = array;
        array = new Object[old.length * 2];
        for (int i = 0; i < count; i++) {
            array[i] = old[(head + i) % old.length];
        }
        head = 0;
        tail = count;
    }
}
