package PRO.Lektion12_ObserverPattern.Exercise3.App;

import PRO.Lektion12_ObserverPattern.Exercise3.BookObserver;
import Utility.Styling;

import java.util.HashSet;

public class Salesman implements BookObserver {

    private final String name; // not empty

    public Salesman(String name) {

        this.name = name;
    }

    @Override
    public void update(Book book) {

        HashSet<Book> books = new HashSet<>();

        for (Customer c : book.getCustomers()) {
            books.addAll(c.getBooks());
        }
        books.remove(book);

        if (!books.isEmpty()) {
            System.out.println(Styling.txtGreen("Salesman's list of customer books: "));
            System.out.println(books);
        }
    }

}
