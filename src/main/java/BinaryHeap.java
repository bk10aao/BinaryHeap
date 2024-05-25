@SuppressWarnings("unchecked")
public class BinaryHeap <Key extends Comparable <Key>> {
    private final Key[] binaryHeap;
    private int size = 0;

    public BinaryHeap(int capacity) {
        binaryHeap = (Key[]) new Comparable[capacity + 1];
    }

    public void insert(Key key) {
        binaryHeap[++size] = key;
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
        Key key = binaryHeap[i];
        binaryHeap[i] = binaryHeap[j];
        binaryHeap[j] = key;
    }

    private boolean less(int valueOne, int valueTwo) {
        return binaryHeap[valueOne].compareTo(binaryHeap[valueTwo]) > 0;
    }

    private void sink(int index) {
        while(index * 2 <= size) {
            int j = index * 2;
            if(j < size && less(j, j + 1))
                j++;
            if(!less(index, j))
                break;
            exchange(index, j);
            index = j;
        }
    }

    private void swim(int index) {
        while(index > 1 && less(index / 2, index)) {
            exchange(index, index / 2);
            index = index / 2;
        }
    }
}
