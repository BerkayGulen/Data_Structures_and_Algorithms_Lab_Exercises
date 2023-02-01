package Lab4_BinaryHeaps;

import java.util.Arrays;


public class Heap {
    private int currentSize;
    private int[] heapArray;

    // Constructors
    public Heap() {
        setCurrentSize(0);
        heapArray = new int[1];
    }

    public Heap(int capacity) {
        setCurrentSize(0);
        heapArray = new int[capacity + 1];
    }

    // Heap Operations
    public int[] buildHeap(int[] array) {
        // Builds the heap from an array that you have provided
        this.heapArray = array;
        currentSize = array.length - 1;
        for (int i = currentSize / 2; i > -1; i--) {
            percolateDown(i);
        }
        return heapArray;

    }
    public void buildHeap2(int value) {
        // Builds the heap from an array that you have provided
      percolateDown(value);

    }

    public int deleteMin() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int minItem = getMinValue();
        heapArray[1] = heapArray[currentSize--];
        percolateDown(1);
        return minItem;
    }


    private void percolateDown(int hole) {
        int child;
        int tmp = heapArray[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && heapArray[child + 1] < heapArray[child]) {
                child++;
            }
            if (heapArray[child] < tmp) {
                heapArray[hole] = heapArray[child];
            } else {
                break;
            }
        }
        heapArray[hole] = tmp;
    }

    public int getMinValue() {
        return heapArray[1];
    }


    public int getHeight() {
        return (int) Math.ceil(Math.log(currentSize + 1) / Math.log(2)) - 1;

    }


    public void insert(int value) {
        // Inserts an integer element to the binary min heap
        if (currentSize == heapArray.length - 1)
            enlargeArray(heapArray.length + 1);

        int hole = ++currentSize;

        percolateUp(value, hole);
    }

    private void percolateUp(int value, int hole) {
        // Organizes the elements of the heap and percolate up the elements for not violating heap properties
        for (heapArray[0] = value; value < heapArray[hole / 2]; hole = hole / 2) {
            heapArray[hole] = heapArray[hole / 2];
        }

        heapArray[hole] = value;
    }


    // Helper Methods
    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private void enlargeArray(int newSize) {
        // Enlarges array to the new size
        int[] old = heapArray;
        heapArray = new int[newSize];

        for (int i = 1; i < old.length; i++)
            heapArray[i] = old[i];
    }

    public void printHeap() {
        int height = getHeight();

        for (int i = 1, len = currentSize+1; i < len; i++) {
            int x = heapArray[i];
            int level = log2(i) + 1;
            int spaces = (height - level + 2) * 2;

            System.out.print(stringOfSize(spaces, ' '));
            System.out.print(x);

            if((int)Math.pow(2, level) - 1 == i) System.out.println();
        }
        System.out.println();

    }
    private String stringOfSize(int size, char ch) {
        char[] a = new char[size];
        Arrays.fill(a, ch);
        return new String(a);
    }

    // log with base 2
    private int log2(int x) {
        return (int)(Math.log(x) / Math.log(2)); // = log(x) with base 10 / log(2) with base 10
    }

    // Getters and Setters
    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int[] getHeapArray() {
        return heapArray;
    }

    public void setHeapArray(int[] heapArray) {
        this.heapArray = heapArray;
    }

}