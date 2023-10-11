package PRO.Lektion3_Interfaces.Opgave2_compareTo;

import Utility.ConsoleStyling;
import java.util.ArrayList;

public class App {
    static ArrayList<Customer> customers = new ArrayList<>();
    public static void main(String[] args) {
        initTestData();
        System.out.println("(Total Customers: " + customers.size() + ")");
        System.out.println();

        Customer largestCustomer = findLargest(customers.toArray(new Customer[0]));
        System.out.println(ConsoleStyling.title("Biggest Customer Lexicographically: "));
        System.out.println(largestCustomer.toString());
        System.out.println();

        //region Wagner
        Customer customerBig = new Customer("Wagner", "Quint", 99);
        Customer[] biggerThanWagner = biggerThanCustomer(customers.toArray(new Customer[0]), customerBig);
        System.out.println(ConsoleStyling.title("Customers Bigger than Wagner Quint: "));
        int wagnerCount = 0;
        for(Customer customer : biggerThanWagner){
            System.out.println(customer.toString());
            wagnerCount++;
        }
        System.out.println(ConsoleStyling.color("Total: ", ConsoleStyling.Color.WHITE, true) + ConsoleStyling.color(Integer.toString(wagnerCount), ConsoleStyling.Color.GREEN, true));
        String omittedCustomers = Integer.toString(customers.size() - biggerThanWagner.length);
        System.out.println(ConsoleStyling.color("Omitted: ", ConsoleStyling.Color.WHITE, true) + ConsoleStyling.color(omittedCustomers, ConsoleStyling.Color.RED, true));
        System.out.println();
        //endregion

        //region Arnold
        Customer customerSmall = new Customer("Arnold", "Fish", 41);
        Customer[] biggerThanArnold = biggerThanCustomer(customers.toArray(new Customer[0]), customerSmall);
        System.out.println(ConsoleStyling.title("Customers Bigger than Arnold Fish: "));
        int arnoldCount = 0;
        for(Customer customer : biggerThanArnold){
            System.out.println(customer.toString());
            arnoldCount++;
        }
        System.out.println(ConsoleStyling.color("Total: ", ConsoleStyling.Color.WHITE, true) + ConsoleStyling.color(Integer.toString(arnoldCount), ConsoleStyling.Color.GREEN, true));
        omittedCustomers = Integer.toString(customers.size() - biggerThanArnold.length);
        System.out.println(ConsoleStyling.color("Omitted: ", ConsoleStyling.Color.WHITE, true) + ConsoleStyling.color(omittedCustomers, ConsoleStyling.Color.RED, true));
        //endregion
    }

    private static Customer findLargest(Customer[] customers){

        Customer tempCustomer = null;
        for(Customer c : customers){

            if(tempCustomer == null){ tempCustomer = c; }

            int comparison = c.compareTo(tempCustomer);
            if(comparison > 0){
                tempCustomer = c;
            }
        }
        return tempCustomer;
    }

    public static Customer[] biggerThanCustomer(Customer[] customerArr, Customer customer){

        int deletedEntryCount = 0;

        // Set entries which are not greater than given Customer to null
        for(int i = 0; i < customerArr.length; i++){
            int comparison = customerArr[i].compareTo(customer);
            if(comparison < 0){
                customerArr[i] = null;
                deletedEntryCount++;
            }
        }

        int newArraySize = customerArr.length - deletedEntryCount;
        Customer[] newArray = new Customer[newArraySize];
        int arrayFillCounter = 0;

        // Fill in the notnull Customers
        for(int i = 0; i < customerArr.length; i++){
            if(customerArr[i] != null){
                newArray[arrayFillCounter] = customerArr[i];
                arrayFillCounter++;
            }
        }
        return newArray;
    }

    private static void initTestData(){
        customers.add(new Customer("John", "Doe", 30));
        customers.add(new Customer("Alice", "Smith", 25));
        customers.add(new Customer("Bob", "Johnson", 30));
        customers.add(new Customer("Alice", "Doe", 28));
        customers.add(new Customer("Michael", "Brown", 22));
        customers.add(new Customer("Emily", "Williams", 35));
        customers.add(new Customer("David", "Miller", 40));
        customers.add(new Customer("Sophia", "Jones", 28));
        customers.add(new Customer("James", "Taylor", 29));
        customers.add(new Customer("Olivia", "Anderson", 22));
        customers.add(new Customer("Daniel", "Martinez", 33));
        customers.add(new Customer("Emma", "Garcia", 28));
        customers.add(new Customer("William", "Rodriguez", 37));
        customers.add(new Customer("Ava", "Lopez", 26));
        customers.add(new Customer("Liam", "Hernandez", 31));
        customers.add(new Customer("Mia", "Gonzalez", 29));
        customers.add(new Customer("Benjamin", "Perez", 24));
        customers.add(new Customer("Isabella", "Wilson", 27));
        customers.add(new Customer("Ethan", "Moore", 23));
        customers.add(new Customer("Sofia", "Jackson", 32));
        customers.add(new Customer("Alexander", "Lee", 28));
        customers.add(new Customer("Charlotte", "Xark", 29));
        customers.add(new Customer("Xander", "Alberta", 29));
    }

}
