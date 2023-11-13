package PRO.Lektion12_ObserverPattern.Exercise3.App;

import PRO.Lektion12_ObserverPattern.Exercise3.BookObserver;

import java.util.ArrayList;

public class Book {

    private final String title; // not empty
    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<BookObserver> observers = new ArrayList<>();
    private int count;

    public Book(String title) {

        this.title = title;
        this.count = 0;
    }

    public void incCount(int amount) { count += amount; }
    public void decCount(int amount) {

        count -= amount;
        notifyObservers();
    }

    private void notifyObservers() {

        for (BookObserver o : this.observers) {
            o.update(this);
        }
    }

    // Get, Set & toString()
    void addObserver(BookObserver observer) { this.observers.add(observer); }
    void removeObserver(BookObserver observer) { this.observers.remove(observer); }
    public void addCustomer(Customer customer) { customers.add(customer); }
    public ArrayList<Customer> getCustomers() { return new ArrayList<>(this.customers); }
    public String getTitle() { return title; }
    public int getCount() { return count; }
    @Override
    public String toString() { return title + "(" + count + ")"; }

}
