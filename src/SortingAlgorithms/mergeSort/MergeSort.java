package SortingAlgorithms.mergeSort;

import java.util.ArrayList;

public class MergeSort {
    public void mergeSort(ArrayList<Integer> a) {
        ArrayList<Integer> tempArray = new ArrayList<>(a);
        mergeSort(tempArray, a, 0, a.size() - 1);

    }

    private void mergeSort(ArrayList<Integer> a, ArrayList<Integer> tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(tempArray, a, left, center);
            mergeSort(tempArray, a, center + 1, right);
            merge(a, tempArray, left, center + 1, right);

        }
    }

    private void merge(ArrayList<Integer> a, ArrayList<Integer> tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a.get(leftPos) <= a.get(rightPos)) {
                tempArray.set(tmpPos++, a.get(leftPos++));
            } else {
                tempArray.set(tmpPos++, a.get(rightPos++));
            }
        }

        while (leftPos <= leftEnd) {
            tempArray.set(tmpPos++, a.get(leftPos++));
        }
        while (rightPos <= rightEnd) {
            tempArray.set(tmpPos++, a.get(rightPos++));
        }


    }
}
