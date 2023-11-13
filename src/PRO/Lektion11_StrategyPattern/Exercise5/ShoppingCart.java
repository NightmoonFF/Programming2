package PRO.Lektion11_StrategyPattern.Exercise5;

import java.util.ArrayList;

public class ShoppingCart {

    private final ArrayList<Item> items = new ArrayList<>();

    public ShoppingCart() {

    }

    public void pay(Payment payment) {

        payment.pay(getCartTotal());
    }

    public void addItem(Item item) {

        items.add(item);
    }

    public int getCartTotal() {

        return items.stream().mapToInt(Item::getPrice).sum();
    }

}

class Item {

    String name;
    int price;

    public Item(String name, int price) {

        this.name = name;
        this.price = price;
    }

    public int getPrice() { return this.price; }

}