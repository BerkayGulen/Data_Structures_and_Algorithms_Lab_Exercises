package SortingAlgorithms.mergeSort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int array[] = {3, 1, 6, 2, 5, 8, 7, 4, 9};
        ArrayList<Integer> a = new ArrayList<>();
        for (int x:array){
            a.add(x);
        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(a);
        for (int number:a){
            System.out.print(number+" ");
        }


    }
}
