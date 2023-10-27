package PRO.Lektion8_Generics.Exercise2_GenericMethod_HashSet;

import Utility.Styling;

import java.util.Arrays;
import java.util.HashSet;

/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Program a generic method that takes two sets as parameters (that is, objects of type                    │
    │    HashSet<E>) and returns the union of the two sets as a HashSet<T>. (Do not change the                   │
    │    parameters.)                                                                                            │
    │                                                                                                            │
    │    Program a similar method that returns the intersection of the two sets. And a method that               │
    │    returns the difference of the two sets (denoted A \ B or A – B in math).                                │
    │    Test your methods with 2 different type arguments.                                                      │
    │                                                                                                            │
    │    Program a generic method that takes three sets as parameters. The method must add the first             │
    │    two sets to the third set (do not change the parameters).                                               │
    │    Test your solution.                                                                                     │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/
public class Exercise2 {

    static HashSet<Integer> intSetA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
    static HashSet<Integer> intSetB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
    static HashSet<String> stringSetA = new HashSet<>(Arrays.asList("Apple", "Pear", "Mango", "Banana"));
    static HashSet<String> stringSetB = new HashSet<>(Arrays.asList("Apple", "Melon", "Orange", "Grape"));

    public static void print() {
        /*
        HashSet vs. ArrayList:
        ArrayLists allow duplicate values, while HashSets do not.
        ArrayLists maintain order of object insertion, while HashSets are not ordered
        ArrayLists support get(index) and can take null values, while HashSet cannot.
        */

        printHashSet(intSetA);
        printHashSet(intSetB);
        printHashSet(stringSetA);
        printHashSet(stringSetB);
        exA();
        exB();
        exC();
    }

    private static void exA() {

        System.out.println(Styling.txtWhite("\nExercise A: Union"));
        printHashSet(hashSetUnion(intSetA, intSetB));
        printHashSet(hashSetUnion(stringSetA, stringSetB));
    }

    private static void exB() {

        System.out.println(Styling.txtWhite("\nExercise B: Intersection"));
        printHashSet(hashSetIntersection(intSetA, intSetB));
        printHashSet(hashSetIntersection(stringSetA, stringSetB));
        System.out.println(Styling.txtWhite("\nExercise B: Difference"));
        printHashSet(hashSetDifference(intSetA, intSetB));
        printHashSet(hashSetDifference(stringSetA, stringSetB));
    }

    //TODO: this seems too simple to be the intended task
    private static void exC(){
        HashSet<String> stringSetC = new HashSet<>(Arrays.asList("Dorian", "Grapefruit"));
        System.out.println(Styling.txtWhite("\nExercise C: Merge?"));
        printHashSet(hashSetMerge(stringSetA, stringSetB, stringSetC));
    }

    private static <T, E> HashSet<T> hashSetUnion(HashSet<E> setA, HashSet<E> setB) {

        HashSet<T> resultSet = new HashSet<>(setA.size() + setB.size());
        resultSet.addAll((HashSet<T>) setA);
        resultSet.addAll((HashSet<T>) setB);
        return resultSet;
    }

    private static <T, E> HashSet<T> hashSetIntersection(HashSet<E> setA, HashSet<E> setB) {

        HashSet<T> resultSet = new HashSet<>(setA.size() + setB.size());
        resultSet.addAll((HashSet<T>) setA);
        resultSet.retainAll((HashSet<T>) setB);
        return resultSet;
    }

    private static <T, E> HashSet<T> hashSetDifference(HashSet<E> setA, HashSet<E> setB) {

        HashSet<T> resultSet = new HashSet<>(setA.size() + setB.size());
        resultSet.addAll((HashSet<T>) setA);
        resultSet.removeAll((HashSet<T>) setB);
        return resultSet;
    }

    private static <T, E> HashSet<T> hashSetMerge(HashSet<E> setA, HashSet<E> setB, HashSet<E> setC) {

        HashSet<T> resultSet = new HashSet<>();
        resultSet.addAll((HashSet<T>) setC);
        resultSet.addAll((HashSet<T>) setA);
        resultSet.addAll((HashSet<T>) setB);
        return resultSet;
    }

    private static <T> void printHashSet(HashSet<T> set) {

        for (Object o : set) {
            System.out.print(o.toString() + "\t");
        }
        System.out.println();
    }

}
