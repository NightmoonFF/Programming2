package Lektion5_Rekursion;

public class Excersises {

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



}
