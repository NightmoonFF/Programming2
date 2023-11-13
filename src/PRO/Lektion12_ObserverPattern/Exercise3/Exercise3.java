package PRO.Lektion12_ObserverPattern.Exercise3;

import PRO.Lektion12_ObserverPattern.Exercise3.App.TestApp;

public class Exercise3 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 3                                                                                              │
    │                                                                                                            │
    │    In this exercise we are going to simulate a book store with books, customers, salesmen (who             │
    │    sells books to customers) and purchasers (who purchase new copies of books, when stock is               │
    │    low).                                                                                                   │
    │    The file observer_ex3student.zip contains the code for the classes, but the code is not                 │
    │    completed.                                                                                              │
    │                                                                                                            │
    │    Q1                                                                                                      │
    │    Implement a bidirectional many to many association between class Book and class Customer.               │
    │                                                                                                            │
    │    Q2                                                                                                      │
    │    Create a BookObserver interface with one method: void update(Book book).                                │
    │                                                                                                            │
    │    Q3                                                                                                      │
    │    The class Book is going to be subject in an implementation of the Observer Pattern. Extend              │
    │    the class, so that it can handle book observers. Every time the number of copies of a book is           │
    │    decremented, the observers must be told.                                                                │
    │                                                                                                            │
    │    Q4                                                                                                      │
    │    The class Purchaser is going to be observer in the Observer Pattern.                                    │
    │    Extend the class, so that it is a book observer. Whenever a book is sold, the purchaser is told.        │
    │    If the sell brings the count of books in stock below 6, the purchaser must purchase                     │
    │    10 more copies to fill the stock.                                                                       │
    │                                                                                                            │
    │    Q5                                                                                                      │
    │    The class Salesman is also going to be a book observer. Whenever a book is sold, the                    │
    │    salesman is told. His update()-method must print a list of books bought by customers, that              │
    │    also bought the sold book. The list must be without duplicates and without the sold book.               │
    │                                                                                                            │
    │    Q6                                                                                                      │
    │    Use the main() method in the Ex3App class to test your classes. Look carefully at the printed           │
    │    output to see, if everything is working as expected                                                     │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {

        TestApp.test();
    }

}
