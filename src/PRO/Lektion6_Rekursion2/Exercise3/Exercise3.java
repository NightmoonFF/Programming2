package PRO.Lektion6_Rekursion2.Exercise3;

import Utility.DataGen;
import Utility.Styling;

import java.util.ArrayList;

public class Exercise3 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 3                                                                                              │
    │                                                                                                            │
    │    Write a recursive method public boolean isPalindrome(String s) that tells                               │
    │    whether a string s is a palindrome. The string s contains only letters.                                 │
    │    The recursive definition of whether a string s is a palindrome:                                         │
    │                                                                                                            │
    │    	Simple case true, if s.length() <=1                                                                    │
    │    	                                                                                                       │
    │    	Recursive case c0=cn-1 and c1…cn-2 is a palindrome                                                     │
    │    	(s is given by s = c0c1…cn-2cn-1)                                                                      │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    /**
     * case sensitive!
     *
     * @param s input string
     * @return True if word is palindrome
     */
    public static boolean isPalindrome(String s) {

        if (s.length() <= 1) { return true; }

        /*
         * c0=cn-1 and c1...cn-2 is a palindrome
         * (s is given by s = c0c1...cn-2cn-1)
         *
         * n må betyde længden?
         */
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            s = s.substring(1, s.length() - 1);
            return isPalindrome(s);
        }

        return false;
    }

    public static void print() {

        ArrayList<String> wordList = new ArrayList();
        wordList.addAll(DataGen.getFirstNameList());
        wordList.addAll(DataGen.getPlaceList());

        for (int i = 0; i < wordList.size(); i++) {
            String originalString = wordList.get(i);
            String lowercaseString = originalString.toLowerCase();
            wordList.set(i, lowercaseString);
        }

        int count = 0;
        for (String word : wordList) {
            if (isPalindrome(word)) {
                System.out.println(Styling.color(word, Styling.Color.GREEN, true) + " - is a palindrome!");
                count++;
            }
        }
        System.out.println("-".repeat(50));
        System.out.println(Styling.color("Result: ", Styling.Color.WHITE, false));
        System.out.println(Styling.color(String.valueOf(count), Styling.Color.GREEN, true) + " entries were palindromes!");
        System.out.println(Styling.color((String.valueOf(wordList.size() - count)), Styling.Color.ORANGE, true) + " were not!");
    }

}
