package PRO.Lektion6_Rekursion2.Exercise2;

import Utility.Styling;

public class Exercise2{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Write a recursive method public int binomial(int n, int m) that calculates the                          │
    │    binomial coefficient Kn,m for the positive numbers m and n, with 0 <= m <= n.                           │
    │    The recursive definition is:                                                                            │
    │    	Simple cases Kn,0 = 1 eller Kn,n = 1                                                                   │
    │    	Recursive case Kn,m = Kn-1,m + Kn-1,m-1, 0<m<n                                                         │
    │                                                                                                            │
    │    Test your method: make a table like the following                                                       │
    │    Table of K(n,m)                                                                                         │
    │    m 0 1 2 3 4 5 6 7                                                                                       │
    │    n --------------------------------------------------------------                                        │
    │    0 | 1                                                                                                   │
    │    1 | 1 1                                                                                                 │
    │    2 | 1 2 1                                                                                               │
    │    3 | 1 3 3 1                                                                                             │
    │    4 | 1 4 6 4 1                                                                                           │
    │    5 | 1 5 10 10 5 1                                                                                       │
    │    6 | 1 6 15 20 15 6 1                                                                                    │
    │    7 | 1 7 21 35 35 21 7 1                                                                                 │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/
    public static int binominal(int n, int m){
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
    public static void print(){
        //TODO: allow for parameter inputs, that it asks for after selecting
        int limit = 10;

        //region Header
        System.out.println(Styling.color("Table of K("+ limit + "," + limit + ")", Styling.Color.YELLOW, true));
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



}
