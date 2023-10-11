package PRO.Lektion12_ObserverPattern.Exercise3;

public class Buyer {
    private final String name; // not empty

    public Buyer(String name) {
        this.name = name;
    }

    public void buyBook(Book b, int amount) {
        b.incCount(amount);
        System.out.println("Buyer " + name + ": " + b + ", " + amount + " copies");
    }
}
