package PRO.Lektion8_Generics.Exercise1_GenericClass;

public class Person<S extends Comparable<S>, I extends Comparable<I>> implements Comparable<Person<S, I>> {

    //OBS: AF MYSTISKE ÅRSAGER EXTENDER MAN INTERFACET PÅ TYPEN
    S name;
    I age;

    public Person(S name, I age) {

        this.name = name;
        this.age = age;

    }

    public int getAge() {

        return Integer.valueOf(String.valueOf(age));
    }

    @Override
    public String toString() { return String.valueOf(name); }

    @Override
    public int compareTo(Person<S, I> o) { return this.name.compareTo(o.name); }

}

class FullName implements Comparable<FullName> {

    String firstName;
    String lastName;

    public FullName(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {

        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(FullName o) {

        if (this.firstName.equals(o.firstName)) {
            return this.lastName.compareTo(o.lastName);
        }
        else {
            return this.firstName.compareTo(o.firstName);
        }
    }

}