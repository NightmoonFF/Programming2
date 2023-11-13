package PRO.Lektion12_ObserverPattern.Exercise3.App;

import Utility.Styling;

public class TestApp {

    public static void test() {

        Salesman salesman = new Salesman("Saul Goodman");
        Buyer buyer = new Buyer("Mr. Collector");

        Book donaldDuck = new Book("Donald Duck");
        donaldDuck.addObserver(buyer);
        donaldDuck.addObserver(salesman);

        // TODO: make purchaser buy 6 copies of donaldDuck
        buyer.buyBook(donaldDuck, 6);
        System.out.println();

        Book java = new Book("Java");
        java.addObserver(salesman);
        java.addObserver(buyer);

        // TODO: make purchaser buy 8 copies of java
        buyer.buyBook(java, 8);
        System.out.println();

        Book designPatterns = new Book("Design Patterns");
        designPatterns.addObserver(salesman);
        designPatterns.addObserver(buyer);

        // TODO: make purchaser buy 10 copies of designPatterns
        buyer.buyBook(designPatterns, 10);
        System.out.println();

        Customer bob = new Customer("Bob");
        Customer alice = new Customer("Alice");
        Customer harry = new Customer("Harry");

        //---------------------------------------------------------------------

        makeSale(donaldDuck, bob);
        System.out.println();
        makeSale(donaldDuck, alice);
        System.out.println();
        makeSale(donaldDuck, harry);
        System.out.println();

        makeSale(java, bob);
        System.out.println();
        makeSale(java, alice);
        System.out.println();
        makeSale(java, harry);
        System.out.println();

        makeSale(designPatterns, bob);
        System.out.println();

        System.out.println(Styling.txtWhite("Bob's Books:"));
        for (Book b : bob.getBooks()) {
            System.out.println(b.getTitle());
        }

        System.out.println(Styling.txtWhite("Alice's Books:"));
        for (Book b : alice.getBooks()) {
            System.out.println(b.getTitle());
        }

        System.out.println(Styling.txtWhite("Harry's Books:"));
        for (Book b : harry.getBooks()) {
            System.out.println(b.getTitle());
        }

    }

    public static void makeSale(Book b, Customer c) {

        System.out.println("Sale: " + b + " sold to " + c.getName());
        // TODO: link customer and book
        c.addBook(b);
        b.addCustomer(c);

        b.decCount(1);
    }

}
