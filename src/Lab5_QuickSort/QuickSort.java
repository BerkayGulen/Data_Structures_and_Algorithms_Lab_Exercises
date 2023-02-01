package Lab5_QuickSort;

import java.util.ArrayList;

public class QuickSort {
    public void quickSort(ArrayList<Integer> input) {
        quickSort(input, 0, input.size());
    }

    private void quickSort(ArrayList<Integer> input, int left, int right) {
        int j = 0;
        if (right - left < 2) {
        } else {
            int pivot = input.get(left);
            int i = left;
            j = right;

            while (i < j) {

                while (i < j && input.get(--j) >= pivot) ;
                if (i < j) {
                    input.set(i, input.get(j));
                }

                while (i < j && input.get(++i) <= pivot) ;
                if (i < j) {
                    input.set(j, input.get(i));
                }

            }
            input.set(j, pivot);
            quickSort(input, left, j);
            quickSort(input, j + 1, right);
        }

    }

}

