package PRO.Lektion8_Generics;

import Utility.Dispatchable;

public class Exercises implements Dispatchable {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    a) Program a generic class Person<T> with a name field of type T and constructor and                    │
    │    toString() method (Person<T> is a generic class).                                                       │
    │    Make another class FullName with fields firstname and lastname (both strings) and                       │
    │    constructor and toString() method (FullName is an ordinary class).                                      │
    │    Test the class Person<T>, first with String as type argumnet, and then with FullName as type            │
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
    public static void printExercise1(){
        //System.out.println(new Person<String>("Jonas"));
        //System.out.println(new Person<FullName>(new FullName("Børge", "Karlsen")));
    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Program a generic method that takes two sets as parameters (that is, objects of type                    │
    │    HashSet<E>) and returns the union of the two sets as a HashSet<T>. (Do not change the                   │
    │    parameters.)                                                                                            │
    │    Program a similar method that returns the intersection of the two sets. And a method that               │
    │    returns the difference of the two sets (denoted A \ B or A – B in math).                                │
    │    Test your methods with 2 different type arguments.                                                      │
    │    Program a generic method that takes three sets as parameters. The method must add the first             │
    │    two sets to the third set (do not change the parameters).                                               │
    │    Test your solution.                                                                                     │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise2(){

    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 3                                                                                              │
    │                                                                                                            │
    │    In the file Bag.zip you will find the Bag<E> interface, JUnit testcases and the start of the class      │
    │    ArrayBag<E> that implement the Bag<E> interface.                                                        │
    │    Finish the implementation in the class ArrayBag<E>.                                                     │
    │    Run the JUnit test. Does your code pass all tests?                                                      │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise3(){

    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 4                                                                                              │
    │                                                                                                            │
    │    In the file Ring.zip you will find the Ring interface.                                                  │
    │    Program an ArrayRing<E> class that implements the interface. The implementation must use                │
    │    an ArrayList to hold the items. (Program your own EmptyRingException class.)                            │
    │    Test your implementation in a test class or in a JUnit test                                             │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise4(){

    }



}
