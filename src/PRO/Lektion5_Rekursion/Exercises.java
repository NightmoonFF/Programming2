package PRO.Lektion5_Rekursion;

import Utility.ConsoleStyling;

import java.io.File;
import java.util.Random;

public class Exercises {

    /**
     * Excersise 1
     *
     * Calculates n!, n > 0
     * The recursive definition is:
     * BASE CASE:  1! = 1
     * RECURSIVE CASE: n! = n*(n-1)!, n>0
     */
    public static int factorial(int n){

        // Termineringsregel - Base Case
        if(n == 1){
            // "1! = 1", dvs, da vi udregner faktor,
            // så når metoden ramer faktor 1 er resultatet 1
            // dvs hvis n = 1, er resultatet 1
            return 1;
        }
        //Rekurrensregel - Recursive Case
        else{
            // n! = n * (n-1)!, n>0
            // dvs ignore n!=
            // det i midten er så det der skal udregnes
            // obs på udråbstegnet, dvs:
            // at det her er faktor, altså metoden vi programmerer: (n * (n - 1)!)
            // og så det sidste, så længe at n > 0, idk, giver ingen mening
            // er det ikke bare termineringsregelen? Hvorfor skrive det igen her
            int result = n * factorial(n - 1);
            return result;
        }
    }
    public static void PrintExercise1(){
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(10) + 2;
        System.out.println("Factorial of " + randomNumber + ":");

        int result = Exercises.factorial(randomNumber);

        System.out.println(result);
    }


    /**
    * Exercise 2
    * Write a recursive method public int power(int n, int p) that calculates np,p>=0.
    * The recursive definition is
    *    n0 = 1
    *    np = np-1*n, p>0
    * Write another recursive method public int power2(int n, int p) that calculates
    * np, p>=0 too, but this time with the definition:
    *    n0 = 1
    *    np = np-1*n, p>0 and p is uneven
    *    np = (n*n)p div 2, p>0 and p is even
    */
    public static int power(int n, int p){

        //Base case
        //n0 = 1
        if(p == 1){  //if the power is 1, result would be the same?
            return n; //so the result would be the input value
        }
        //Rekursive case
        //np = np-1*n, p>0
        //value^power - 1 * value, so long as power is at least 1
        else {
            //Breakdown:
            //np = np-1*n, p>0
            //np = np-1 * n  <--same as-->  2³ = 2² * 2
            //np = thisMethod(n, p-1) * n
            int np = power(n, p - 1) * n;
            return np;
        }
    }
    public static int power2(int n, int p){
        // n0 = 1
        if(p <= 1) { return n; }
        else{
            // even, because the low bit will always be set on an odd number
            if( (p & 1) == 0){
                // np = np-1*n, p>0 and p is uneven
                int np = power(n*n, p) / 2;
                return np;
            }
            else {
                // np = (n*n)p div 2, p>0 and p is even
                int np = power(n, p - 1) * n;
                return np;
            }
        }
    }
    public static void PrintExercise2(){
        System.out.println("5 to the power of 2: ");
        System.out.println(power(5, 2));
        System.out.println("8 to the power of 3: ");
        System.out.println(power(8, 3));
        System.out.println("4 to the power of 3");
        System.out.println(power2(4, 3));
    }


    /**
     * Exercise 3
     * Write a recursive method public int prod(int a, int b) that calculates a*b (a
     * and b are non-negative integer numbers >= 0). The method has to use the following recursive
     * definition of multiplication (use of java’s * oprator is not allowed):
     *   a * b = (a-1) * b + b
     *   1 * b = b
     *   0 * b = 0
     * Now suppose that your machine is capable of doubling and halving integer numbers.
     * Write a recursive method public int prodRus(int a, int b) that calculates a*b
     * using the following recursive definition of multiplication:
     *   a * b = (a div 2) * (2*b) if a is even and a >= 2
     *   a * b = (a-1) * b + b if a is odd and a >= 1
     *   0 * b = 0
     * Which of the two methods is the faster one and why?
     */
    public static int prod(int a, int b){
        if (a < 0 || b < 0) {throw new IllegalArgumentException("Input 'a' and 'b' must both be a non-negative number"); }

        // 0 * b = 0
        if (a == 0) { return 0; }
        // 1 * b = b
        else if (a == 1) { return b; }
        // a * b = (a-1) * b + b
        else { return prod(a - 1, b) + b; }
    }
    public static int prodRus(int a, int b){
        if (a == 0) { return 0; }
        else if ( ((a & 1) == 0) && a >= 2){
            return prod( (a / 2), prod(2, b) );
        }
        else { return prod(a - 1, b) + b; }
    }
    public static void PrintExercise3(){
        double startTime = System.nanoTime();
        System.out.println("prod(21, 47): ");
        System.out.println(prod(21, 47));
        double endTime = System.nanoTime();
        System.out.println("Executed in: " + ((endTime - startTime)) + "nanoseconds");

        startTime = System.nanoTime();
        System.out.println("prodRus(21, 47): ");
        System.out.println(prodRus(21, 47));
        endTime = System.nanoTime();
        System.out.println("Executed in: " + ((endTime - startTime)) + " nanoseconds");


    }


    /**
     * Exercise 4
     * In this exercise you must write a recursive method
     * public String reverse(String s)
     * that returns s with the characters in reverse order. Example: reverse(”RANSLIRPA”) is
     * ”APRILSNAR”.
     * First you have to write down the recursive definition, and then you must program the method.
     */
    public static String reverse(String s){
        /**
         * Base:
         * s[0] = s if length <= 1
         * Rekursive:
         * s = s[length(s) − 1] + reverse( s[1 : length(s) − 1] ) + s[0]
         * --------------------------------------------------------------
         * Explanation:
         * s[length(s) - 1] = the character at position equal to total characters - 1 (the last char)
         * s[1 : length(s) - 1] = the range of chars from s[1] to s[length(s) - 1] (s excluding first and last char)
         * s[0] = the first character
         * --------------------------------------------------------------
         * Laymans terms:
         * pick a word.
         * write down the last letter, then the first letter of the word far apart. (last first, since it's reversed)
         * Between those, write down the 2nd last letter, then the 2nd letter of the word (exclude letters from before)
         * repeat until there is either one letter left, or no letters left. If one is left, write down the final one.
         * (the final one left would be the same both normal order and reversed order, since its exactly in the middle)
         * Example with "Apple":
         * E   A
         * EL PA
         * ELPPA
         */
        if (s.length() <= 1) { return s; }
        else{
            return s.charAt(s.length() - 1) + reverse(s.substring(1, s.length() - 1)) + s.charAt(0);
        }

    }
    public static void PrintExercise4(){
        System.out.println("Reverse of RANSLIRPA:");
        System.out.println(reverse("RANSLIRPA"));

    }


    /**
     * Exercise 5
     * Make a method that recursively traverses through all directories contained in the folder given
     * by the path parameter and prints the names of all directories found:
     * public static void scanDir(String path)
     * Hint: Create a File object from the path and use the list() and isDirectory() methods in the File
     * class.
     * Make a method that can also write the level of the directory before the directory name (level
     * of the start directory is 1)
     */
    public static void scanDir(String path){
        scanDirHelper(path, 0);
    }
    private static void scanDirHelper(String path, int level){
        //TODO: some directories are not indented? Otherwise almost works as intended
        File root = new File(path);
        if(level == 0) { System.out.println(ConsoleStyling.color(root.getName(), ConsoleStyling.Color.WHITE, true)); }

        for(File f : root.listFiles()) {
            if (!f.isDirectory()) {
                if (level == 0) {
                    System.out.println("  ".repeat(level) + " └─" + f.getName());
                } else {
                    System.out.println("  ".repeat(level) + " └─" + f.getName());
                }
            }
        }
        for(File f : root.listFiles()){
            if (f.isDirectory()){
                if(level == 0){
                    System.out.println(ConsoleStyling.color("  ".repeat(level) + f.getName(), ConsoleStyling.Color.WHITE, true));
                    scanDirHelper(f.getPath(), level + 1);
                } else{
                    System.out.println(ConsoleStyling.color("  ".repeat(level) + f.getName(), ConsoleStyling.Color.WHITE, true));
                    scanDirHelper(f.getPath(), level + 1);
                }
            }
        }
    }


    /**
     * Exercise 6
     * Write a recursive method that implements Euclid's algorithm for finding the greatest common
     * divisor of two integers (both >= 2). The greatest common divisor is the largest integer that
     * divides both values (with no remainder).
     * Greatest common divisor gcd(b,a) is defined by:
     *      gcd(a, b) = b if b <= a and b divides a
     *      gcd(a, b) = gcd(b, a) if a < b
     *      gcd(a, b) = gcd(b, a % b) otherwise
     */
    public static void PrintExercise6(){
        //TODO:
    }


    /**
     * Exercise 7
     * A domino block is sized 2*1. An n-strip is a board sized 2*n. Make a method that calculates
     * the number of ways an n-strip can be covered with domino blocks.
     * Hint: First you must find the recursive formula for the function
     * f(n) = number of ways an n-strip can be covered with domino blocks.
     */
    public static void PrintExercise7(){
        //TODO:
    }

}
