package PRO.Lektion10_JCF_og_Lambda.Exercise1;

public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    @Override
    public String toString() {

        return String.format("Person[%s,%d]", name, age);
    }

}
