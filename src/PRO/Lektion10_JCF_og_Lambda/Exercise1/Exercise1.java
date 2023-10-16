package PRO.Lektion10_JCF_og_Lambda.Exercise1;

import PRO.Lektion10_JCF_og_Lambda.Exercise1.ex1student.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Exercise1{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    Import the file Ex1Student.zip into the src folder in IntelliJ. Insert code in the main method          │
    │    that uses the findFirst() method with a lambda expression to solve question a - d.                      │
    │                                                                                                            │
    │    a) Find the first person in the persons list with an age of 44.                                         │
    │    b) Find the first person in the persons list with a name starting with 'S'.                             │
    │    c) Find the first person in the persons list with a name containing more than one ’i’.                  │
    │    d) Find the first person in the persons list with an age equal to the length of the name.               │
    │    e) Program a findAll() method. Its signature and implementation must fit the use of the                 │
    │    method in                                                                                               │
    │    List<Person> list1 = findAll(persons, p -> p.getAge() < 30);                                            │
    │    Insert code in the main method that uses the findAll() method with a lambda expression to               │
    │    solve question f-i.                                                                                     │
    │    f) Find all persons with name containing the letter 'i'.                                                │
    │    g) Find all persons with name starting with 'S'.                                                        │
    │    h) Find all persons with name of length 5.                                                              │
    │    i) Find all persons with name of length at least 6 and age below 40.                                    │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/
    /**
     * Returns from the list the first person
     * that satisfies the predicate.
     * Returns null, if no person satisfies the predicate.
     */
    public static Person findFirst(List<Person> list, Predicate<Person> filter) {
        for (Person p : list) {
            if (filter.test(p))
                return p;
        }
        return null;
    }

    public static List<Person> findAll(List<Person> list, Predicate<Person> filter){
        List<Person> newList = new ArrayList<>();
        for(Person p : list) {
            if(filter.test(p))
                newList.add(p);
        }
        return newList;
    }

    public static void print(){
        List<Person> persons = List.of(
                new Person("Bent", 25),
                new Person("Susan", 34),
                new Person("Mikael", 60),
                new Person("Klaus", 44),
                new Person("Birgitte", 17),
                new Person("Liselotte", 9)
        );

        // a) Find the first person in the persons list with an age of 44
        System.out.println(findFirst(persons, person -> person.getAge() == 44));

        // b) Find the first person in the persons list with a name starting with 'S'
        System.out.println(findFirst(persons, person -> person.getName().charAt(0) == 'S'));

        // c) Find the first person in the persons list with a name containing more than one "i"
        System.out.println(findFirst(persons, person -> person.getName().chars().filter(ch -> ch == 'i').count() >= 2 ));

        // d) Find the first person in the persons list with an age equal to the length of the name.
        System.out.println(findFirst(persons, person -> person.getName().length() == person.getAge()));

        List<Person> list1 = findAll(persons, p -> p.getAge() < 30);

    }




}
