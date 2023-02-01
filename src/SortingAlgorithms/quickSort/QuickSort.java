package SortingAlgorithms.quickSort;

public class QuickSort {

    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public int median3(int[] a, int left, int right) {
        int center = (left + right) / 2;

        if (a[left] > a[center])
            swapReferences(a, left, center);

        if (a[left] > a[right])
            swapReferences(a, left, right);

        if (a[center] > a[right])
            swapReferences(a, center, right);

        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private void swapReferences(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    private void quickSort(int[] a, int left, int right) {
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
                    while (a[++i] < pivot)
                        ;

                    while (a[--j] > pivot)
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
    public void insertionSort(int[] a,int left,int right){
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

