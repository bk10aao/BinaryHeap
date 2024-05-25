@SuppressWarnings("unchecked")
public class BinaryHeap <Key extends Comparable <Key>> {
    private final Key[] binaryHeap;
    private int size = 0;

    public BinaryHeap(int capacity) {
        binaryHeap = (Key[]) new Comparable[capacity + 1];
    }

    public void insert(Key x) {
        binaryHeap[++size] = x;
        swim(size);
    }

    public Key deleteMaximum() {
        Key max = binaryHeap[1];
        exchange(1, size--);
        sink(1);
        binaryHeap[size + 1] = null;
        return max;
    }

    private void exchange(int i, int j) {
        Key t = binaryHeap[i];
        binaryHeap[i] = binaryHeap[j];
        binaryHeap[j] = t;
    }

    private boolean less(int i, int j) {
        return binaryHeap[i].compareTo(binaryHeap[j]) > 0;
    }

    private void sink(int k) {
        while(k * 2 <= size) {
            int j = k * 2;
            if(j < size && less(j, j + 1))
                j++;
            if(!less(k, j))
                break;
            exchange(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while(k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }
}
