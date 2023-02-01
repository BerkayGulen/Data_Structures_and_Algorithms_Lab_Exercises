package SortingAlgorithms.quickSort;

import java.util.Random;
import java.util.stream.IntStream;

public class MainClass {
    public static void main(String[] args) {
        int[]  randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();


        quickSort(randomIntsArray);
        for (int i : randomIntsArray) {
            System.out.print(i+" ");
        }
    }

    public static void quickSort(int[] intArray) {
        recQuickSort(intArray, 0, intArray.length - 1);
    }

    public static void recQuickSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            insertionSort(intArray, left, right);
        else {
//            int partition = partitionIt(intArray, left, right, median);
            partitionIt(intArray,left,right);
//            recQuickSort(intArray, partition + 1, right);
        }
    }
    public static int medianOf3(int[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center])
            swapReferences(intArray, left, center);

        if (intArray[left] > intArray[right])
            swapReferences(intArray, left, right);

        if (intArray[center] > intArray[right])
            swapReferences(intArray, center, right);

        swapReferences(intArray, center, right - 1);
        return intArray[right - 1];
    }

    private static void swapReferences(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
    public static void partitionIt(int[] intArray, int left, int right) {
        int pivot = medianOf3(intArray, left, right);
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (intArray[++leftPtr] < pivot)
                ;
            while (intArray[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swapReferences(intArray, leftPtr, rightPtr);
        }
        swapReferences(intArray, leftPtr, right - 1);
        recQuickSort(intArray, left, leftPtr - 1);
        recQuickSort(intArray, leftPtr + 1, right);
    }

    public static void manualSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (intArray[left] > intArray[right])
                swapReferences(intArray, left, right);
            return;
        } else {
            if (intArray[left] > intArray[right - 1])
                swapReferences(intArray, left, right - 1);
            if (intArray[left] > intArray[right])
                swapReferences(intArray, left, right);
            if (intArray[right - 1] > intArray[right])
                swapReferences(intArray, right - 1, right);
        }
    }
    public static void insertionSort(int[] a,int left,int right){
        for (int firstUnsortedIndex = left; firstUnsortedIndex <= right; firstUnsortedIndex++) {
            int newElement = a[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && a[i - 1] > newElement; i--) {
                a[i] = a[i - 1];
            }
            a[i] = newElement;
        }
    }


}