package Utility;

import java.util.Comparator;

public class Sort {

    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {

        // Iterate whole list (i)
        for (int i = 0; i < list.length - 1; i++) {
            // Iterate remaining elements after it (j)
            for (int j = i + 1; j < list.length; j++) {
                // compare current remaining element (j) to original (i)
                if (comparator.compare(list[j], list[i]) < 0) {
                    // If it is not identical, then swap
                    if (j != i) {
                        swap(list, i, j);
                    }
                }
            }
        }

    }

    private static <T> void swap(T[] a, int i, int j) {

        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
