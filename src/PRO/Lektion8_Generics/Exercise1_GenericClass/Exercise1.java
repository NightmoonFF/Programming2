package PRO.Lektion8_Generics.Exercise1_GenericClass;

import Utility.DataGen;
import Utility.Styling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    a) Program a generic class Person<T> with a name field of type T and constructor and                    │
    │    toString() method (Person<T> is a generic class).                                                       │
    │    Make another class FullName with fields firstname and lastname (both strings) and                       │
    │    constructor and toString() method (FullName is an ordinary class).                                      │
    │    Test the class Person<T>, first with String as type argument, and then with FullName as type            │
    │    argument (i.e. Person<String> and Person<FullName>).                                                    │
    │                                                                                                            │
    │    b) Modify the class Person<T> so that it implements the interface Comparable<Person<T>>                 │
    │    with persons ordered according to the value of the name field. This will require that the type          │
    │    parameter T implements Comparable<T>.                                                                   │
    │    Test the compareTo() method with Person<String> objects, and with Person<FullName>                      │
    │    objects.                                                                                                │
    │    Add some persons to an ArrayList<Person<FullName>>. Print the list before and after sorting             │
    │    it with Collections.sort().                                                                             │
    │                                                                                                            │
    │    c) Extra exercise (extra now; you will learn about lambda expressions later):                           │
    │    Add an age field to the Person class (update the constructor and the toString() method, add a           │
    │    getAge() method).                                                                                       │
    │    Sort the list on age with the sort() method in the List class using a lambda expression.                │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/
public class Exercise1 {

    static Person<String, Integer> p1 = new Person<>("Jonas", 24);
    static Person<String, Integer> p2 = new Person<>("Abra", 55);
    static Person<FullName, Integer> pf1 = new Person<>(new FullName("Børge", "Karlsen"), 24);
    static ArrayList<Person<FullName, Integer>> fnList = new ArrayList<>();

    public static void print() {

        IntStream.range(0, 7).forEach(i -> fnList.add(
                new Person<>(
                        new FullName(DataGen.rndFirstName(), DataGen.rndLastName()),
                        new Random().nextInt(1, 100))));
        exA();
        exB();
        exC();

    }

    private static void exA() {

        System.out.println(Styling.txtWhite("\nExercise A:"));
        System.out.println(p1);
        System.out.println(pf1.toString());

    }

    private static void exB() {

        System.out.println(Styling.txtWhite("\nExercise B:"));

        System.out.println("Comparing " + p1.name + " with " + p2.name + ": " + p1.compareTo(p2));

        System.out.println("Alphabetically sorted list of FullName:");

        for (Person<FullName, Integer> p : fnList) {
            System.out.print("[" + p.toString() + "]\t");
        }

        System.out.print("\n");
        Collections.sort(fnList);

        for (Person<FullName, Integer> p : fnList) {
            System.out.print("[" + p.toString() + "]\t");
        }

    }

    private static void exC() {

        System.out.println(Styling.txtWhite("\n\nExercise C:"));
        System.out.println("List sorted by age: ");

        fnList.sort(Comparator.comparingInt(Person::getAge));

        for (Person<FullName, Integer> p : fnList) {
            System.out.print("[" + p.toString() + ": " + p.getAge() + "y" + "]\t");
        }

    }

}
