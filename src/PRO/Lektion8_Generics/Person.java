package PRO.Lektion8_Generics;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>>{

    //OBS: AF DÅRLIGE ÅRSAGER EXTENDER MAN INTERFACET PÅ TYPEN
    T name;
    public Person(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                '}';
    }

    @Override
    public int compareTo(Person<T> o) {
        return 0;
    }
}

class FullName {
    String firstName;
    String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}