package Lab3_HashTable;

public class MyHashtable {
    public int capacity;
    public int elementSize;
    // TODO: Create a hash table (a list, a list of a linkedlist, an array, etc.)
    private int array[];
    // public List<Integer> table;


    public MyHashtable(int capacity) {
        this.capacity = capacity;
        this.elementSize = 0;
        this.array = new int[capacity];
        // table = new List<Integer>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getElementSize() {
        return elementSize;
    }

    public void setElementSize(int elementSize) {
        this.elementSize = elementSize;
    }

    //This is a helper function for allocate an array while in Rehash.
    private void allocateArray(int arraySize) {
        array = new int[arraySize];
    }

    //This is really important helper function for finding empty position in the array using quadratic probing.
    //This method uses iterative approach for quadratic probing that we have seen in the lecture.
    //the probing is continuing until finds an empty or finds a duplicate value.
    private int findPos(int x) {
        int offset = 1;
        int currentPos = hashFunction(x);

        while (array[currentPos] != 0 && array[currentPos] != x) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    // Adding new value.
    //Most work already done in findPos method.
    //in this method we simply insert the value into the array
    //also check the load factor at the end. if the element size are greater than half of the array size, rehash.
    public void insert(int x) {
        int currentPos = findPos(x);
        array[currentPos] = x;

        if (++elementSize > array.length / 2) {
            rehash();
        }
    }

    // Searching a value in hash table
    public boolean contains(int x) {
        int currentPos = findPos(x);
        if (currentPos==x) return true;
        return false;
    }

    // Printing all values
    public void printTable() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("index " + i + ": " + array[i]);
        }
    }

    // Hash function. returned the value (x mod array.size) if it is smaller than zero,
    // this will be special case that we have seen in the class. that means integer value can not store that data so returns - value.
    private int hashFunction(int x) {
        int hashVal = x % array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    // Rehashing the hashtable
    //copy the current array reference into a new array
    //allocate a new array with double the size of the current array
    //by doing that, our hash function result will change.
    //after that insert every not 0 element into the new resized array.
    private void rehash() {
        int[] oldArray = array;
        allocateArray(oldArray.length * 2);
        elementSize = 0;
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != 0) {
                insert(oldArray[i]);
            }
        }
    }
}
