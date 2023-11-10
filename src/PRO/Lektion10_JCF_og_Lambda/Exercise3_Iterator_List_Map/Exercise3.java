package PRO.Lektion10_JCF_og_Lambda.Exercise3_Iterator_List_Map;

import Utility.Styling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Exercise3 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 3                                                                                              │
    │                                                                                                            │
    │    a) Lav en liste med 8 tal. Udskriv listen vha. en iterator.                                             │
    │    b) Lav en map med parrene (2,4), (3,9), (4, 16), (5, 25) og (6,36). Udskriv parrene vha. en             │
    │    iterator på keys (brug printf() til at få en pæn udskrift med paranteser omkring talparrene)            │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {

        // A)
        System.out.println(Styling.txtWhite("Exercise A:"));
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        numbers.iterator().forEachRemaining(System.out::println);

        // B)
        System.out.println(Styling.txtWhite("\nExercise B:"));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2, 4);
        map.put(3, 9);
        map.put(4, 16);
        map.put(5, 25);
        map.put(6, 36);
        map.entrySet().iterator().forEachRemaining(e -> System.out.printf("(%s) ", e.getKey() + ", " + e.getValue()));

    }

}
