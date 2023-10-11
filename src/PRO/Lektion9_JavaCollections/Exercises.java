package PRO.Lektion9_JavaCollections;

import Utility.Dispatchable;

public class Exercises implements Dispatchable {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    Create a class named UseMethodsWithHashSet – the class must have a main() method.                       │
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

    public static void printExercise1(){

    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Q 2.1                                                                                                   │
    │    Program the classes with the shown attributes and methods. Add suitable constructors.                   │
    │    The association must be implemented as a link attribute with type List<Student>                         │
    │    (use an object of type ArrayList<Student>).                                                             │
    │    The method calcAverage() must calculate the average of all grades of all students.                      │
    │    The method findStudent() must return a student with the stated student no (if there is one,             │
    │    otherwise null must be returned).                                                                       │
    │    Test your classes in a main() method.                                                                   │
    │                                                                                                            │
    │    Q 2.2                                                                                                   │
    │    Make the changes that are necessary, if the association is realized as a link attribute of type         │
    │    Set<Student> (use an object of type LinkedHashSet<Student>).                                            │
    │                                                                                                            │
    │    Q 2.3                                                                                                   │
    │    Make the changes that are necessary, if the association is realized as a link attribute of type         │
    │    Map<Integer, Student> with the student number as key (use an object of type                             │
    │    LinkedHashMap<Integer, Student>).                                                                       │
    │    Test your solution                                                                                      │
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
    │    Q 3.1                                                                                                   │
    │    Extend the class Student from exercise 2, so that the class implements the                              │
    │    Comparable<Student> interface. Compare the students on student number.                                  │
    │    Q 3.2                                                                                                   │
    │    Sometimes we want to sort the students on name. To do that, we need a class that implements             │
    │    the Comparator<Student> interface (with comparison on names).                                           │
    │    Program this class. Test the Comparator<Student>.                                                       │
    │    Q 3.3                                                                                                   │
    │    Consider the methods equals() and hashCode() in class Student (the methods are inherited                │
    │    from class Object). Is it necessary to overwrite these methods?                                         │
    │    Let us say, that student objects with the same number are considered equal. Create a new                │
    │    equals() method and new hashCode() method. The compareTo() method and the hashCode()                    │
    │    mthod must be consistent with the equals() method.                                                      │
    │    Test your methods.                                                                                      │
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
    │    a) Write a program that                                                                                 │
    │    • Reads the words in a text file and inserts the words in a TreeSet. (There is a big text               │
    │    file on Canvas.)                                                                                        │
    │    • Prints all words in the set, the total number of words, and the number of different                   │
    │    words.                                                                                                  │
    │    b) Write a program that                                                                                 │
    │    • Reads the words in a text file and inserts the words in a TreeMap. Use words as keys                  │
    │    and the count of each word as value in the map.                                                         │
    │    • Prints the words in the map with count bigger than or equal to 1000, the total number                 │
    │    of words, and the number of different words.                                                            │
    │    c) Write a program that                                                                                 │
    │    • Reads the words in a text file and inserts the words in a LinkedHashMap. Use the hash                 │
    │    code of a word as key and the set of words with the same hash code as value.                            │
    │    • Prints the hash code and the set of words, but only for sets containing more than one                 │
    │    word.                                                                                                   │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise4(){

    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 5                                                                                              │
    │                                                                                                            │
    │    [YL] opgave 20.18                                                                                       │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise5(){

    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 6                                                                                              │
    │                                                                                                            │
    │    [YL] opgave 21.4                                                                                        │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise6(){

    }



}
