package PRO.Lektion9_JavaCollectionsFramework.Exercise1;

import java.util.Arrays;
import java.util.HashSet;

public class Exercise1 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    Create a class named UseMethodsWithHashSet – the class must have a main() method.                       │
    │                                                                                                            │
    │    A) Create in main() a set that can contain integers.                                                    │
    │    B) Add the numbers 34, 12, 23, 45, 67, 34, 98 to the set.                                               │
    │    C) Print the set.                                                                                       │
    │    D) Add the number 23 to the set.                                                                        │
    │    E) Print the set.                                                                                       │
    │    F) Remove the number 67 from the set.                                                                   │
    │    G) Print the set.                                                                                       │
    │    H) Check whether the set contains the number 23.                                                        │
    │    I) Print the count of numbers in the set.                                                               │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {

        HashSet<Integer> intSet = new HashSet<>(Arrays.asList(34, 12, 23, 45, 67, 34, 98));
        System.out.println(intSet);
        intSet.add(23);
        System.out.println(intSet);
        intSet.remove(67);
        System.out.println(intSet);
        // It does
        System.out.println(intSet.size());
    }

}
