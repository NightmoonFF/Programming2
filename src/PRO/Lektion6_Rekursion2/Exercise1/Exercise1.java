package PRO.Lektion6_Rekursion2.Exercise1;

import Utility.Styling;

import java.util.ArrayList;
import java.util.Random;

public class Exercise1{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    Make a method that returns the count of even numbers in a list given as parameter. Use a                │
    │    recursive helper method to calculate the count.                                                         │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    //TODO: Does not work, it returned "3" as an even number.

    private static ArrayList<Integer> evenNumbersHelper(ArrayList<Integer> numberList, int i){
        i--;
        if(i == 0){
            return numberList;
        }
        if(numberList.get(i) % 2 == 0){
            return evenNumbersHelper(numberList, i);
        }
        else{
            numberList.remove(i);
            System.out.print(Styling.color(String.valueOf(i), Styling.Color.PINK, true) + ", ");
            return evenNumbersHelper(numberList, i);
        }
    }
    public static int evenNumbers(ArrayList<Integer> numberList){
        int count = 0;
        ArrayList<Integer> evenNumberList = evenNumbersHelper(numberList, numberList.size());

        for(int number : evenNumberList){
            count++;
            System.out.print(Styling.color(String.valueOf(number), Styling.Color.GREEN, true ) + ", ");
        }

        System.out.println();
        return count;
    }
    public static void print(){
        ArrayList<Integer> nList = new ArrayList<>();
        Random random = new Random();

        // Add 10 random numbers to list
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);
            nList.add(randomNumber);
        }

        System.out.println(
                Styling.color("Total: ", Styling.Color.YELLOW, true) +
                        evenNumbers(nList)
        );
    }



}
