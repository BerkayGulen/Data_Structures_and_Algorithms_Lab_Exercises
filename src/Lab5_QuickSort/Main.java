package Lab5_QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        QuickSort quickSort = new QuickSort();

        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            int result = r.nextInt(1000);
            a.add(result);
        }
        ArrayList<Integer> benchmarkArrayList = new ArrayList<>(a);
        //create array for Arrays.sort
        int[] arr = new int[benchmarkArrayList.size()];
        for (int i = 0; i < benchmarkArrayList.size(); i++) {
            arr[i] = benchmarkArrayList.get(i);
        }

        System.out.println("Un-Sorted Version ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
        //***************************************************************************************

        long startTime = System.nanoTime();
        quickSort.quickSort(a);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        //***************************************************************************************

        System.out.println("Sorted Version ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
        System.out.println("Elapsed Time for custom quick sort: " + elapsedTime);


        //***************************************************************************************


        long startTime2 = System.nanoTime();
        Arrays.sort(arr);
        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime2 - startTime2;
//        ***************************************************************************************

        System.out.println();
        System.out.println("Elapsed Time for java sort: " + elapsedTime2);

    }

    // our algorithm seems to be faster than java sort algorithm. the reason behind this could be, java uses extra conditions and checks for sorting. our algorithm is simple and faster.
    //choosing last element as a pivot is worst case. it runs at n^2.


}
