package PRO.Lektion11_StrategyPattern.Exercise5;
public class Exercise5{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 5                                                                                              │
    │                                                                                                            │
    │    Implementer betaling vha. Strategy pattern, således at følgende main() metode kan køres:                │
    │    	public class App {                                                                                     │
    │    		public static void main(String[] args) {                                                              │
    │    			ShoppingCart cart = new ShoppingCart();                                                              │
    │    			cart.addItem(new Item("Sucker", 10));                                                                │
    │    			cart.addItem(new Item("Beers", 40));                                                                 │
    │    			// pay by credit card                                                                                │
    │    			cart.pay(new CreditCardPayment("John Doe", "1234567890123456"));                                     │
    │    			// pay by PPaypal                                                                                    │
    │    			cart.pay(new PaypalPayment("johndoe@example.com", "MyPassword"));                                    │
    │    	}                                                                                                      │
    │    }                                                                                                       │
    │                                                                                                            │
    │    Kørslen skal resultere i følgende udskrift:                                                             │
    │    Paid with credit card: 50                                                                               │
    │    Paid using Paypal: 50                                                                                   │
    │    Hjælp: Lav et SAM interface kaldet Payment med metoden void pay(int amount)                             │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print(){

    }



}
