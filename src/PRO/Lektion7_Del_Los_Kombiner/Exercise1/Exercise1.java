package PRO.Lektion7_Del_Los_Kombiner.Exercise1;

import Utility.Styling;

import java.util.ArrayList;
import java.util.Random;

public class Exercise1{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    Write a recursive method that totals all the elements in a List<Integer>. Use the template from         │
    │    Divide-Solve-Combine (Del, løs og kombiner)                                                             │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/
    /**
     * Helper method: has the parameters needed for recursion
     * P represents the problem to be solved
     * l represents the lower bound of the range within the list that you are currently processing (typically the start index).
     * h represents the upper bound of the range within the list that you are currently processing (typically the end index).
     * m represents the midpoint in the range of [l, h]
     */
    static private int returnTotalHelper(ArrayList<Integer> list, int l, int h){
        if(l == h){
            return list.get(l);
        } else{

            int m = (l + h) / 2;  //Calculates the midpoint

            //the purpose of the midpoint is to find:
            int totalA = returnTotalHelper(list, l, m); // 1. the total in the left half of the range [1, m]
            int totalB = returnTotalHelper(list, m + 1, h); // 2. the total in the right half of the range [m + 1, h]

            return totalB + totalA; //
        }
    }
    static private int returnTotal(ArrayList<Integer> list){
        return returnTotalHelper(list, 0, list.size() - 1);
    }
    static public void print(){
        ArrayList<Integer> elements = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            elements.add(new Random().nextInt(1, 5));
            System.out.print(elements.get(i) + " ");
        }
        System.out.println();
        System.out.println(
                Styling.color("Total: ", Styling.Color.WHITE, true) +
                        Styling.color(String.valueOf(returnTotal(elements)), Styling.Color.GREEN, true));
    }


/*_   _       _
 | \ | | ___ | |_ ___  ___ _
 |  \| |/ _ \| __/ _ \/ __(_)
 | |\  | (_) | ||  __/\__ \_
 |_| \_|\___/ \__\___||___(_)
*/
    /*
"DIVIDE, SOLVE, COMBINE" TEMPLATE:
Metode: Løs(P)
Hvis p er simpelt, så returner L = løsning
Ellers
Opdel P i P1 og P2
L1 = Løs(P1)
L2 = Løs(P2)
L = Kombinér(L1,L2)
Returner L;
--------------------------------------------------------------------------------------------
DET BASALE TILFÆLDE:
det lavest nedbrydelige punkt.
Det vil sige tilfældet, når man er kommet hele vejen ned i træet så langt som man kan.
         []
         /\
       [] []
      /\  /\
    [][] [][]
    |
    |
så når man kommer her til, er det det basale tilfælde.
Fx hvis man skal finde antallet af 0 værdier, så vil det basale tilfælde jo være,
at man kigger på om low er nul.
*/

    /*
    cGPT:
    Hvis "low" repræsenterer startindekset for dit problemområde, og "high" repræsenterer slutindekset,
     så ja, i en rekursiv algoritme, hvor du arbejder med hele listen, vil "low" på et eller andet tidspunkt gå igennem alle elementer i listen.
    Dette er en karakteristisk egenskab ved rekursive algoritmer, der arbejder på hele problemet ved gradvist at opdele det i mindre dele.
    Lad os tage dit eksempel med at tælle nulværdier i en liste som reference:
    I starten er "low" lig med indeks 0, og "high" er lig med indeks for det sidste element i listen.
    I din rekursive opdeling, halverer du normalt problemområdet ved at justere "low" og "high" indekserne,
     så du behandler kun den første eller sidste halvdel af listen i hvert rekursive kald.
    Dette fortsætter, indtil du når det basale tilfælde, hvor "low" og "high" er ens, hvilket betyder,
     at du har kun et enkelt element tilbage at vurdere.
     */
    private int divideSolveCombineTemplate(ArrayList<Integer> list, int low, int high) {

        /*
          (Hvis p er simpelt, så returner L = løsning)

          This is the first step in the template and serves as a termination condition for the recursive algorithm.
          It checks if the problem P is simple enough to be directly solved without further division.
          If P is simple, you return a solution L (low) directly without dividing it further.

          OBS: this is not a universal formula, sometimes the condition might be low higher than high,
          or low lower than high, etc, as with any termination rules in recursivity

         */
        if (low == high) { //hvis hele listen er gået igennem?
            return list.get(low);
        } else {

            //Calculates the midpoint
            int midpoint = (low + high) / 2;

            // (Opdel P i P1 og P2)
            //
            //
            // the purpose of the midpoint is to find:
            // L1 = Løs(P1) - the result in the left half of the range [1, m]
            int L1 = divideSolveCombineTemplate(list, low, midpoint);
            // L2 = Løs(P2) - the result in the right half of the range [m + 1, h]
            int L2 = divideSolveCombineTemplate(list, midpoint + 1, high);

            // then, depending on what we want, we put in the logic of what problem to solve
            // fx:
            if( L1 > L2){
                return L1;
            }
            else{
                return L2;
            }
        }
    }


}
