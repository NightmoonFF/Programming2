package Lektion2_Nedarvning_og_Polymorphi.Opgave3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args){

        initTestData();

        for(Customer customer : customers){
            System.out.println();
            System.out.println("(" + customer.getName() + ") " + customer.totalBuy());
            System.out.println("Total: " + customer.totalBuyWithDiscount() + " " + customer.discount.toString());
            System.out.println();

            customer.discount = null;
        }

    }

    private static void initTestData(){
        Product product1 = new Product(1, "Kage", 24);
        Product product2 = new Product(2, "Bagel", 30);
        Product product3 = new Product(3, "Ost", 50);
        Product product4 = new Product(4, "Tartelet", 15);
        Product product5 = new Product(5, "Mousse", 20);
        Customer customer1 = new Customer("Karl", LocalDate.of(2000, 10, 12));
        Customer customer2 = new Customer("Dorte", LocalDate.of(1999, 2, 5));

        //---

        //Customer1 Ordrer
        //Order 1
        Order order1 = new Order(1);
        OrderLine orderLine1 = new OrderLine(1, 4, product1);
        OrderLine orderLine2 = new OrderLine(2, 29, product2);
        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);

        //Order 2
        Order order2 = new Order(2);
        OrderLine orderLine3 = new OrderLine(1, 19, product3);
        OrderLine orderLine4 = new OrderLine(2, 11, product4);
        OrderLine orderLine5 = new OrderLine(3, 84, product5);
        order2.addOrderLine(orderLine3);
        order2.addOrderLine(orderLine4);
        order2.addOrderLine(orderLine5);

        //---

        //Customer2 Ordrer
        //Order 3
        Order order3 = new Order(3);
        OrderLine orderLine6 = new OrderLine(1, 3, product2);
        OrderLine orderLine7 = new OrderLine(2, 6, product4);
        order3.addOrderLine(orderLine6);
        order3.addOrderLine(orderLine7);

        //Order 4
        Order order4 = new Order(4);
        OrderLine orderLine8 = new OrderLine(1, 5, product3);
        OrderLine orderLine9 = new OrderLine(2, 8, product1);
        order4.addOrderLine(orderLine8);
        order4.addOrderLine(orderLine9);

        //Order 5
        Order order5 = new Order(5);
        OrderLine orderLine10 = new OrderLine(1, 34, product5);
        OrderLine orderLine11 = new OrderLine(2, 72, product3);
        order5.addOrderLine(orderLine10);
        order5.addOrderLine(orderLine11);

        //Order 6
        Order order6 = new Order(6);
        OrderLine orderLine12 = new OrderLine(1, 13, product5);
        OrderLine orderLine13 = new OrderLine(2, 47, product2);
        order6.addOrderLine(orderLine12);
        order6.addOrderLine(orderLine13);

        //---

        PercentDiscount percentDiscount = new PercentDiscount(15);
        FixedDiscount fixedDiscount = new FixedDiscount(250, 1000);
        customer1.discount = percentDiscount;
        customer2.discount = fixedDiscount;

        //---

        customer1.addOrder(order1);
        customer1.addOrder(order2);

        customer2.addOrder(order3);
        customer2.addOrder(order4);
        customer2.addOrder(order5);
        customer2.addOrder(order6);

        customers.add(customer1);
        customers.add(customer2);

    }
}
