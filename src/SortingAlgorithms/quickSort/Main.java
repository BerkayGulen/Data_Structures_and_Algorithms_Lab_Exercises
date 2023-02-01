package SortingAlgorithms.quickSort;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int array[] = {3, 1, 4, 1, 5, 9, 6, 5, 3, 5};
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            int result = r.nextInt(1000);
            a.add(result);
        }

        QuickSort quickSort = new QuickSort();
        ArrayListVersion arrayListVersion = new ArrayListVersion();
//        quickSort.quickSort(randomIntsArray);
        quickSort.quickSort(array);
        arrayListVersion.quickSort(a);


        for (int x : array) {
            System.out.print(x + " ");
        }

    }

}
