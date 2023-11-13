package PRO.Lektion10_JCF_og_Lambda.Exercise6;

import Utility.Regex;
import Utility.Sort;
import Utility.Styling;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Exercise6 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 6                                                                                              │
    │                                                                                                            │
    │    [YL] opgave 20.21                                                                                       │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void runExercise() {

        userPrompt();
    }

    /*
    20.21 (Use Comparator) Write the following generic method using selection sort
    and a comparator:
    public static <E> void selectionSort(E[] list,
    Comparator<? super E> comparator)
    Write a test program that prompts the user to enter six strings, invokes the sort
    method to sort the six strings by their last character, and displays the sorted strings.
    Use Scanner’s next() method to read a string
     */
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        // Made it for my Utility Package:
        Sort.selectionSort(list, comparator);
    }

    private static void userPrompt() {

        System.out.println("Please input 6 words, separated with a space:");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(Regex.split(Regex.SplitType.allWhitespace));
        scanner.close();

        if (words.length == 1) {
            words = "HellA Z HellU HellI HellN AbrX HellAA hellX".split(Regex.split(Regex.SplitType.allWhitespace));
        }
        else if (words.length != 6) {
            System.out.println("Error: input must contain exactly 6 words or characters, separated with a space");
            return;
        }

        Comparator<String> ex6Comparator = Comparator.comparing(o -> o.substring(o.length() - 1));

        System.out.println(Arrays.toString(words));
        selectionSort(words, ex6Comparator);
        System.out.println(Styling.txtWhite("Sorted by the last character of the word:"));
        System.out.println(Arrays.toString(words));
    }

}
