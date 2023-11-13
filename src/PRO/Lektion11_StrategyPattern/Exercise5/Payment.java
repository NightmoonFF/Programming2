package PRO.Lektion11_StrategyPattern.Exercise5;

@FunctionalInterface
public interface Payment {

    void pay(int amount);

}

class CreditCardPayment implements Payment {

    String name;
    String cardID;

    public CreditCardPayment(String name, String cardID) {

        this.name = name;
        this.cardID = cardID;
    }

    @Override
    public void pay(int amount) {

        System.out.println("Paid with credit card: " + amount);
    }

}

class PaypalPayment implements Payment {

    String email;
    String password;

    public PaypalPayment(String email, String password) {

        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(int amount) {

        System.out.println("Paid using Paypal: " + amount);
    }

}