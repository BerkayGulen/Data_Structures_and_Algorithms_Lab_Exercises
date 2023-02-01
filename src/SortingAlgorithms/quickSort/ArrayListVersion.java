package SortingAlgorithms.quickSort;

import java.util.ArrayList;

public class ArrayListVersion {

    public void quickSort(ArrayList<Integer> a) {
        quickSort(a, 0, a.size() - 1);
    }

    public int median3(ArrayList<Integer> a, int left, int right) {
        int center = (left + right) / 2;

        if (a.get(left) > a.get(center))
            swapReferences(a, left, center);

        if (a.get(left) > a.get(right))
            swapReferences(a, left, right);

        if (a.get(center) > a.get(right))
            swapReferences(a, center, right);

        swapReferences(a, center, right - 1);
        return a.get(right-1);
    }

    private void swapReferences(ArrayList<Integer> a, int index1, int index2) {
        int temp = a.get(index1);
        a.set(index1,a.get(index2));
        a.set(index2,temp);
    }

    private void quickSort(ArrayList<Integer> a, int left, int right) {
        int size = right - left + 1;
        int cutOffValue = 30;
        if (size <= cutOffValue) {
            insertionSort(a, left, right);

        } else {
            if (left <= right) {
                int pivot = median3(a, left, right);
                int i = left;
                int j = right - 1;
                while (true) {
                    while (a.get(++i) < pivot)
                        ;

                    while (a.get(--j) > pivot)
                        ;

                    if (i >= j) {
                        break;
                    } else {
                        swapReferences(a, i, j);
                    }
                }
                swapReferences(a, i, right - 1);
                quickSort(a, left, i - 1);
                quickSort(a, i + 1, right);
            }
        }
    }
    public void insertionSort(ArrayList<Integer> a,int left,int right){
        for (int firstUnsortedIndex = left; firstUnsortedIndex <= right; firstUnsortedIndex++) {
            int newElement = a.get(firstUnsortedIndex);
            int i;
            for (i = firstUnsortedIndex; i > 0 && a.get(i-1) > newElement; i--) {
                a.set(i,a.get(i-1));
            }
            a.set(i,newElement);
        }
    }


}

