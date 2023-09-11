package Lektion6_Rekursion;

import Utility.ConsoleStyling;
import Utility.Dispatchable;
import Utility.StringLists.StringList;

import java.util.ArrayList;
import java.util.Random;

public class Assignments implements Dispatchable {

    //region Exercise 1
    private ArrayList<Integer> evenNumbersHelper(ArrayList<Integer> numberList, int i){
        i--;
        if(i == 0){
            return numberList;
        }
        if(numberList.get(i) % 2 == 0){
            return evenNumbersHelper(numberList, i);
        }
        else{
            numberList.remove(i);
            System.out.print(ConsoleStyling.color(String.valueOf(i), ConsoleStyling.Color.PINK, true) + ", ");
            return evenNumbersHelper(numberList, i);
        }
    }
    public int evenNumbers(ArrayList<Integer> numberList){
        int count = 0;
        ArrayList<Integer> evenNumberList = evenNumbersHelper(numberList, numberList.size());

        for(int number : evenNumberList){
            count++;
            System.out.print(ConsoleStyling.color(String.valueOf(number), ConsoleStyling.Color.GREEN, true ) + ", ");
        }

        System.out.println();
        return count;
    }
    public void printExercise1(){
        ArrayList<Integer> nList = new ArrayList<>();
        Random random = new Random();

        // Add 10 random numbers to list
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(100);
            nList.add(randomNumber);
        }
        System.out.println(ConsoleStyling.color("Opgave 1:", ConsoleStyling.Color.WHITE, true));
        System.out.println(
                ConsoleStyling.color("Total: ", ConsoleStyling.Color.YELLOW, true) +
                evenNumbers(nList)
        );
    }
    //endregion

    // region Exercise 2
    public int binominal(int n, int m){
        //Termineringsregel:
        //Kn,0 = 1 eller Kn,n = 1
        if ( m == 0 || m == n){
            return 1;
        }

        //Rekkurensregel:
        //Kn,m = Kn-1,m + Kn-1,m-1, 0 < m < n
        //K = resultat(metoden)
        //metode(n-1, m) + metode(n-1, m-1) - indtil at 0 er mindre end m, eller n er mindre end n
        return binominal(n - 1, m) + binominal(n - 1, m - 1);
    }
    public void printExercise2(){
        //TODO: allow for parameter inputs, that it asks for after selecting
        int limit = 10;

        //region Header
        System.out.println(ConsoleStyling.color("Table of K("+ limit + "," + limit + ")", ConsoleStyling.Color.YELLOW, true));
        System.out.printf("%-4s", "m");
        for(int i = 0; i < limit; i++){
                System.out.printf("%-7d", i);
        }
        System.out.println();
        System.out.print("n |");
        for(int i = 0; i < limit; i++){
            System.out.print("--------");
        }
        System.out.println();
        //endregion

        //Går nedad n
        for(int n = 0; n < limit; n++){
            System.out.print( n + " | ");
            //Går henad m
            for(int m = 0; m < limit; m++){
                if(m > n){
                    System.out.printf("%-7s", "-");
                }
                else { System.out.printf("%-7d", binominal(n, m)); }
            }
            System.out.println();
        }
    }
    //endregion

    //region Exercise 3
    /**
     * case sensitive!
     * @param s
     * @return True if word is palindrome
     */
    public boolean isPalindrome(String s){

        if(s.length() <= 1) { return true; }
        /**
         * c0=cn-1 and c1...cn-2 is a palindrome
         * (s is given by s = c0c1...cn-2cn-1)
         *
         * n må betyde længden?
         */
        if(s.charAt(0) == s.charAt(s.length() - 1)){
            s = s.substring(1, s.length() - 1);
            return isPalindrome(s);
        }

        return false;
    }

    public void printExercise3(){

        ArrayList<String> wordList = new ArrayList();
        wordList.addAll(StringList.getFirstNameList());
        wordList.addAll(StringList.getPlaceList());

        for (int i = 0; i < wordList.size(); i++) {
            String originalString = wordList.get(i);
            String lowercaseString = originalString.toLowerCase();
            wordList.set(i, lowercaseString);
        }

        int count = 0;
        for (String word : wordList){
            if(isPalindrome(word)){
                System.out.println( ConsoleStyling.color(word, ConsoleStyling.Color.GREEN, true) + " - is a palindrome!" );
                count++;
            }
        }
        System.out.println("-".repeat(50));
        System.out.println( ConsoleStyling.color( "Result: ", ConsoleStyling.Color.WHITE, false));
        System.out.println( ConsoleStyling.color( String.valueOf(count), ConsoleStyling.Color.GREEN, true) + " entries were palindromes!");
        System.out.println( ConsoleStyling.color( (String.valueOf(wordList.size() - count) ), ConsoleStyling.Color.ORANGE, true) + " were not!");
    }
    //endregion



}
