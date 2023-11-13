package PRO.Lektion11_StrategyPattern.Exercise3;

public class Exercise3 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 3                                                                                              │
    │                                                                                                            │
    │    Create a Customer class with attributes number and name (and constructor, getters and                   │
    │    toString() method). Add a static field of type Comparator<Customer> (with get and set).                 │
    │    Implement the comparator interface in two classes: one that compares numbers, and one that              │
    │    compares names.                                                                                         │
    │    The Customer class must implement the Comparable<Customer> interface. Use the field of                  │
    │    type Comparator in the implementation of the compareTo() method, so that customers can be               │
    │    compared on either numbers or names (Strategy pattern is used here).                                    │
    │    Test your Customer class in a main() method. Extra: Use a lambda to implement the                       │
    │    comparator interface                                                                                    │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    //TODO: extra exercise
    public static void print() {

        Customer customer1 = new Customer(1, "Elias");
        Customer customer2 = new Customer(2, "Jonas");
        Customer customer3 = new Customer(3, "Jonas");
        Customer customer4 = new Customer(4, "Karl");
        Customer customer5 = new Customer(4, "Majbrit");

        System.out.println("Testing identical name using " + Customer.getComparator().getClass().getSimpleName() + ":");
        System.out.println(customer1 + " and " + customer2);
        System.out.println("Result: " + customer1.compareTo(customer2));
        System.out.println();
        System.out.println(customer1 + " and " + customer1);
        System.out.println("Result: " + customer1.compareTo(customer1));
        System.out.println();
        System.out.println(customer2 + " and " + customer3);
        System.out.println("Result: " + customer2.compareTo(customer3));
        System.out.println();
        System.out.println(customer4 + " and " + customer5);
        System.out.println("Result: " + customer4.compareTo(customer5));

        System.out.println();

        Customer.setComparator(new NumberComparator());
        System.out.println(
                "Testing identical number(id) using " + Customer.getComparator().getClass().getSimpleName() + ":");
        System.out.println(customer1 + " and " + customer2);
        System.out.println("Result: " + customer1.compareTo(customer2));
        System.out.println();
        System.out.println(customer1 + " and " + customer1);
        System.out.println("Result: " + customer1.compareTo(customer1));
        System.out.println();
        System.out.println(customer2 + " and " + customer3);
        System.out.println("Result: " + customer2.compareTo(customer3));
        System.out.println();
        System.out.println(customer4 + " and " + customer5);
        System.out.println("Result: " + customer4.compareTo(customer5));

    }

}
