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

    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        int leftIndex = startIndex;
        int rightIndex = midIndex+1;

        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
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
