package PRO.Lektion9_JavaCollectionsFramework.Exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {
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
    │    Test your methods                                                                                       │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {

        Student student1 = new Student(1, "Ted Danson");
        Student student2 = new Student(2, "Mark Hamil");
        Student student3 = new Student(3, "Geronimo Cadillac");
        Student student4 = new Student(4, "Walter White");
        student1.addGrade(10);
        student1.addGrade(12);
        student2.addGrade(4);
        student3.addGrade(10);
        student4.addGrade(7);
        student4.addGrade(12);
        College college = new College("Aarhus Universitet");
        college.addStudent(student1);
        college.addStudent(student4);
        college.addStudent(student3);
        college.addStudent(student2);

        List<Student> studentList = new ArrayList<>(college.getStudents().values());

        System.out.println("Unsorted:");
        System.out.println(studentList);

        System.out.println("\nDefault sorted (compareTo):");
        Collections.sort(studentList);
        System.out.println(studentList);

        System.out.println("\nSorted by Name using Comparator:");
        Collections.sort(studentList, new StudentNameComparator());
        System.out.println(studentList);

        //TODO: equals() & hashCode()
    }

}
