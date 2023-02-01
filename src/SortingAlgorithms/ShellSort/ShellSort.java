package SortingAlgorithms.ShellSort;

public class ShellSort {
    public static void main(String[] args) {
        int array[] = {3, 1, 6, 2, 5, 8, 7, 4, 9};

        for (int gap = array.length / 2; gap > 0; gap /=2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j-gap];
                    j -= gap;
                }
                array[j] = newElement;
            }

        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
