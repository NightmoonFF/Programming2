package PRO.Lektion6_Rekursion2.Exercise5;

import javax.sound.midi.Soundbank;
import java.util.Objects;

public class Exercise5{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 5                                                                                              │
    │                                                                                                            │
    │    In this exercise you will have to programme a method that can print all anagrams of a word.             │
    │    An anagram of a word is another word containing exactly the same letters as the original word           │
    │    but in another order.                                                                                   │
    │    Example: The word cat has the following anagrams:                                                       │
    │    cat                                                                                                     │
    │    cta                                                                                                     │
    │    act                                                                                                     │
    │    atc                                                                                                     │
    │    tca                                                                                                     │
    │    tac                                                                                                     │
    │    (Not all the words above are in the English dictionary, but that doesn’t matter here.)                  │
    │    You will have to write a recursive method that prints a word and all its anagrams.                      │
    │                                                                                                            │
    │    A way to solve this problem recursively is illustrated here:                                            │
    │    The word is cat. First split the word in the prefix c and the word at. Print c concatenated             │
    │    with all anagrams of at. Then split the word in a and ct. Print a concatenated with all                 │
    │    anagrams of ct. At last split the word in t and ca. Print t concatenated with all anagrams of           │
    │    ca. Every time you remove a letter from the word, you append the letter to the prefix.                  │
    │    The method’s signature is:                                                                              │
    │    public void printAnagrams(String prefix, String word)                                                   │
    │    To start the method with the word cat use printAnagrams(””,”cat”).                                      │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printAnagrams(String prefix, String word){

        if(word.length() <= 1){

            // when letters from word has been moved over to prefix so that only one is left,
            // print the prefix, then the remaining letter (word, which contains 1 left)
            System.out.println(Utility.Styling.txtOrange(prefix) + word);
        }
        else{

            // Iterate over each letter in the word
            for (int i = 0; i < word.length(); i++) {

                // the active letter, such as "c" in the first iteration of cat.
                // the next root-level iteration (after recursions with c) would be "a", then "t"
                String activeLetter = word.substring(i, i + 1);

                // the remaining letters, after the active letter has been excluded
                String remainingLetters = word.substring(0, i) + word.substring(i + 1);

                // find anagrams for the remaining letters.
                // moves the active letter from word over to prefix
                printAnagrams(prefix + activeLetter, remainingLetters);
            }
        }
    }

    public static void print(){
        printAnagrams("", "cat");
    }
}