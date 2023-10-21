package PRO.Lektion7_Del_Los_Kombiner.Exercise2;

import Utility.Styling;
import java.util.ArrayList;
import java.util.Random;

public class Exercise2{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Write a recursive method that counts the elements with value 0 in a List<Integer>. Use the              │
    │    template from Divide-Solve-Combine.                                                                     │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    /**
     * Recursion helper method
     * Only called by countZero(ArrayList<Integer>)
     */
    static private int countZero(ArrayList<Integer> list, int l, int h){
        if (l > h) {
            return 0;
        }

        int m = (l + h) / 2;

        // Recursive calls on left and right halves
        int zeroCountA = countZero(list, l, m - 1);
        int zeroCountB = countZero(list, m + 1, h);

        // Check the current index and add 1 if it's zero
        int currentCount = (list.get(m) == 0) ? 1 : 0;

        // Combine the results and return
        return zeroCountA + zeroCountB + currentCount;
    }
    static public int countZero(ArrayList<Integer> list){
        return countZero(list, 0, list.size() - 1);
    }
    static public void print(){
        ArrayList<Integer> elements = new ArrayList<>();
        elements.add(0);
        for(int i = 0; i < 15; i++){
            elements.add(new Random().nextInt(0, 5));

            if(elements.get(i) == 0){
                System.out.print(Utility.Styling.txtWhite(elements.get(i).toString()) + " ");
            }
            else{
                System.out.print(elements.get(i) + " ");
            }
        }

        System.out.println();
        System.out.print(
                Styling.color(
                        "Number of 0's: ",
                        Styling.Color.WHITE,
                        true));
        System.out.println(
                Styling.color(
                        String.valueOf(countZero(elements)),
                        Styling.Color.GREEN,
                        true));
    }

}
