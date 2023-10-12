package PRO.Lektion12_ObserverPattern;

import PRO.Lektion12_ObserverPattern.Exercise2.BagObserver;
import PRO.Lektion12_ObserverPattern.Exercise2.MyBag;
import PRO.Lektion12_ObserverPattern.Exercise2.ObservableBag;
import PRO.Lektion12_ObserverPattern.Exercise2.Observer;
import Utility.Dispatchable;

public class Exercises implements Dispatchable {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    Group work on [DP] chap. 2: Observer Pattern                                                            │
    │    1) Page 38-57                                                                                           │
    │    WeatherStation and the Observer Pattern.                                                                │
    │     What is not good in the solution on page 42 – 43?                                                     │
    │     The two examples (one on page 44, the other on page 48-50): who are the subjects,                     │
    │    who are the observers?                                                                                  │
    │     Discuss the class diagram for the Observer Pattern (on page 52 and 57). What’s the                    │
    │    purpose of the registerObserver() method? Of the notifyObservers() method? Of the                       │
    │    update() method?                                                                                        │
    │     Formulate the Observer pattern with your own words.                                                   │
    │    2) Page 58 - 62 and 69                                                                                  │
    │    The code of the Weather Station using Observer Pattern.                                                 │
    │     Point out the most important parts of the final code, important for the Observer                      │
    │    pattern. (Just to make sure that everyone understands the code.)                                        │
    │    3) Page 72                                                                                              │
    │    Wrapping up.                                                                                            │
    │     Look at theWeatherData class using the Observer pattern (page 59). Why does the                       │
    │    solution using the Observer Pattern have a low coupling (as defined on page 54), and                    │
    │    why is low coupling a good thing?                                                                       │
    │     Make sure that every member of your group understands every line written on page                      │
    │    72!                                                                                                     │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise1(){

    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    I denne opgave skal du implementerer en ObservableBag. En bag minder om et set, men med                 │
    │    den forskel, at det er tilladt at have dubletter. For hvert element der tilføjes bag’en, skal der       │
    │    derfor holdes styr på hvor mange gange elementet forekommer i bag’en.                                   │
    │    Du skal anvende et observer pattern til at gøre det muligt at observere på når der tilføjes og          │
    │    fjernes elementer fra bag’en. I denne variant af observer pattern skal Observer både have at            │
    │    vide hvilket element der tilføjes / fjernes, og dets aktuelle antal i ObservableBag efter               │
    │    operationen er udført. Observeren skal blot printe oplysningerne.                                       │
    │    Implementationen skal være baseret på et HashMap, og adaptes til følgende interface (adapter            │
    │    pattern):                                                                                               │
    │    public interface Bag {                                                                                  │
    │        Add the string to the bag                                                                           │
    │    public void add(String s);                                                                              │
    │        Remove the string s from the bag (if it is the bag).                                                │
    │    public void remove(String s);                                                                           │
    │     Get the count of the string s in the bag.                                                              │
    │    public int getCount(String s);                                                                          │
    │    }                                                                                                       │
    │    Lav det der skal til, så din nye ObservableBag kan anvendes i et for-each loop. Elementer, der          │
    │    er tilføjet flere gange til ObservableBag, skal kun optræde é n gang i gennemløbet (antal               │
    │    kommer ikke med i gennemløbet).                                                                         │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise2(){

        ObservableBag observableBag = new MyBag();
        Observer observer = new BagObserver();
        observableBag.addObserver(observer);

        observableBag.addElement("Kopitaske");
        observableBag.addElement("Grillpølse");
        observableBag.addElement("Belvedere");
        observableBag.addElement("Grillpølse");
        observableBag.addElement("Narko");
        observableBag.addElement("Grillpølse");
        observableBag.removeElement("Grillpølse");

        System.out.println("--".repeat(50));

        observableBag.getCount();

    }



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
    │    Q1                                                                                                      │
    │    Implement a bidirectional many to many association between class Book and class Customer.               │
    │    Q2                                                                                                      │
    │    Create a BookObserver interface with one method: void update(Book book).                                │
    │    Q3                                                                                                      │
    │    The class Book is going to be subject in an implementation of the Observer Pattern. Extend              │
    │    the class, so that it can handle book observers. Every time the number of copies of a book is           │
    │    decremented, the observers must be told.                                                                │
    │    Q4                                                                                                      │
    │    The class Purchaser is going to be observer in the Observer Pattern. Extend the class, so that it       │
    │    is a book observer. Whenever a book is sold, the purchaser is told. If the sell brings the count        │
    │    of books in stock below 6, the purchaser must purchase 10 more copies to fill the stock.                │
    │    Q5                                                                                                      │
    │    The class Salesman is also going to be a book observer. Whenever a book is sold, the                    │
    │    salesman is told. His update()-method must print a list of books bought by customers, that              │
    │    also bought the sold book. The list must be without duplicates and without the sold book.               │
    │    Q6                                                                                                      │
    │    Use the main() method in the Ex3App class to test your classes. Look carefully at the printed           │
    │    output to see, if everything is working as expected.                                                    │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise3(){

    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 4                                                                                              │
    │                                                                                                            │
    │    The picture below shows a small application with 3 windows. The window on the left is the               │
    │    MainFrame-window and the two windows on the right are two SubFrame-windows. The                         │
    │    classes MainFrame and SubFrame can be found in the file observer_ex4student.zip.                        │
    │                                                                                                            │
    │    Every time the user                                                                                     │
    │    chooses a new color in the MainFrame-window, the background color of                                    │
    │    the MainFrame window changes.                                                                           │
    │    It is your job to extend this functionality to the SubFrame-windows: every time the user                │
    │    chooses a new color in the MainFrame-window, the background color of the MainFrame- and                 │
    │    the subscribed SubFrame-windows changes.                                                                │
    │    You must use the Observer Pattern to implement this. The MainFrame object is the subject                │
    │    and the SubFrame objects are the observers.                                                             │
    │    Hint 1: You must add methods to the subject class to add and remove observers.                          │
    │    Hint 2: Create an interface ColorObserver with a method named update(String color) that the             │
    │    observer class must implement.                                                                          │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise4(){

    }



}
