package PRO.Lektion11_StrategyPattern.Exercise3;

import java.util.Comparator;

public class Customer implements Comparable<Customer> {

    static Comparator<Customer> comparator;
    private int number;
    private String name;

    public Customer(int number, String name) {

        this.number = number;
        this.name = name;
        setComparator(new NameComparator());
    }


    public static Comparator<Customer> getComparator() { return comparator; }

    public static void setComparator(Comparator<Customer> comparator) { Customer.comparator = comparator; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {

        return "{" + number + ", " + name + '}';
    }

    @Override
    public int compareTo(Customer o) {

        return comparator.compare(this, o);
    }

}
