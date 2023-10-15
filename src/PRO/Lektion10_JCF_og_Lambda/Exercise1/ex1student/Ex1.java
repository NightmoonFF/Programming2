package PRO.Lektion10_JCF_og_Lambda.Exercise1.ex1student;

import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Bent", 25),
                new Person("Susan", 34),
                new Person("Mikael", 60),
                new Person("Klaus", 44),
                new Person("Birgitte", 17),
                new Person("Liselotte", 9)
        );
        System.out.println(persons);
        System.out.println();

    }

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
}
