package PRO.Lektion12_ObserverPattern.Exercise3.App;

import java.util.ArrayList;

public class Customer {

    private final String name; // not empty

    private final ArrayList<Book> books = new ArrayList<>();

    public Customer(String name) { this.name = name; }


    // Get & Set
    public void addBook(Book book) { books.add(book); }

    public ArrayList<Book> getBooks() { return new ArrayList<>(this.books); }

    public String getName() { return name; }

    @Override
    public String toString() { return name; }

}
