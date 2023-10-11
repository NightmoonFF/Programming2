package PRO.Lektion2_Nedarvning_og_Polymorphi.Opgave3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private final LocalDate birthday;

    // association 1 --> 0..* Order
    private final ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public Discount discount = null;

    /**
     * Opgave 3 - total pris for alle ordrer
     * @return
     */
    public double totalBuy(){
        double total = 0;
        for(Order order : orders){
            total += order.orderPrice();
        }
        return total;
    }

    public double totalBuyWithDiscount(){
        if(discount == null){return totalBuy();}
        return discount.getDiscount(totalBuy());
    }
}
