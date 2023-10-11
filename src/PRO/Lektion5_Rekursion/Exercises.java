package PRO.Lektion5_Rekursion;

import Utility.MathUtil;

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

}
