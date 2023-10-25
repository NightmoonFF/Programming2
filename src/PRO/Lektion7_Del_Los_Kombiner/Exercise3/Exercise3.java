package PRO.Lektion7_Del_Los_Kombiner.Exercise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercise3 {
    /*
        ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
        │                                                                                                            │
        │    Exercise 3                                                                                              │
        │                                                                                                            │
        │    The paper on Divide-Solve-Combine contains most of the code necessary to do a merge sort.               │
        │    The implementation of the method merge() is missing.                                                    │
        │    Write the merge() method.                                                                               │
        │    Test your merge sort on [8, 56, 45, 34, 15, 12, 34, 44].                                                │
        │                                                                                                            │
        └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
    */
    private  static void mergesort(ArrayList<Integer> list, int low, int high){
        if(low<high)
        {
            int middle = (low + high) / 2;
            mergesort(list, low, middle);
            mergesort(list, middle + 1, high);
            merge(list, low, middle, high);
        }
    }

    public static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        // Index for the left sublist
        int leftIndex = low;
        // Index for the right sublist
        int rightIndex = middle + 1;

        // Merge the two sublists into the temporary list
        while (leftIndex <= middle && rightIndex <= high) {
            if (list.get(leftIndex) <= list.get(rightIndex)) {
                temp.add(list.get(leftIndex));
                leftIndex++;
            } else {
                temp.add(list.get(rightIndex));
                rightIndex++;
            }
        }

        // Copy the remaining elements from the left sublist, if any
        while (leftIndex <= middle) {
            temp.add(list.get(leftIndex));
            leftIndex++;
        }

        // Copy the remaining elements from the right sublist, if any
        while (rightIndex <= high) {
            temp.add(list.get(rightIndex));
            rightIndex++;
        }

        // Copy the merged elements back to the original list
        for (int i = 0; i < temp.size(); i++) {
            list.set(low + i, temp.get(i));
        }

    }

    public static void mergesort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    public static void print(){
        ArrayList<Integer> elements = new ArrayList<>(Arrays.asList(8, 56, 45, 34, 15, 12, 34, 44));

        for(int i = 0; i < elements.size(); i++){
            System.out.print(elements.get(i) + "\t");
        }

        mergesort(elements);

        System.out.println();

        for(int i = 0; i < elements.size(); i++){
            System.out.print(Utility.Styling.txtWhite("⮟\t"));
        }

        System.out.println();

        for(int i = 0; i < elements.size(); i++){
            System.out.print(elements.get(i) + "\t");
        }
    }


}
