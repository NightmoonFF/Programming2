package PRO.Lektion12_ObserverPattern.Exercise3.App;

import PRO.Lektion12_ObserverPattern.Exercise3.BookObserver;
import Utility.Styling;

public class Buyer implements BookObserver {

    private final String name; // not empty

    public Buyer(String name) {

        this.name = name;
    }

    public void buyBook(Book b, int amount) {

        b.incCount(amount);
        System.out.println("Buyer " + name + ": " + b + ", " + amount + " copies");
    }

    @Override
    public void update(Book book) {

        if (book.getCount() < 6) {
            System.out.println(Styling.txtOrange("Observer Purchase:"));
            buyBook(book, 10);
        }
    }

}
