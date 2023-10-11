package PRO.Lektion12_ObserverPattern.Exercise3;

public class Customer {
    private final String name; // not empty

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
