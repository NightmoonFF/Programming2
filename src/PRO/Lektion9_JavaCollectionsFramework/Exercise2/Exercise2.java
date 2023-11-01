package PRO.Lektion9_JavaCollectionsFramework.Exercise2;

public class Exercise2 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Q 2.1                                                                                                   │
    │    Program the classes with the shown attributes and methods. Add suitable constructors.                   │
    │    The association must be implemented as a link attribute with type List<Student> (use an                 │
    │    object of type ArrayList<Student>).                                                                     │
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
        college.addStudent(student2);
        college.addStudent(student3);
        college.addStudent(student4);

        System.out.println(college.calcAverage());

        System.out.println(college.findStudent(2).getGrades().toString());
    }

}
