package PRO.Lektion3_Interfaces.Opgave3;
import Utility.Styling;
import Utility.MathUtil;

import java.util.*;

public class App {
    /**
    The decision of whether to instantiate objects as the interface type (Sellable) or the superclass type (Product) depends on your specific design and requirements.
     Both approaches have their use cases, and the choice should be made based on what makes the most sense for your application.

     Here are some considerations for each approach:

    Instantiate as Sellable:
    This is a more abstract and flexible approach because it focuses on the object's behavior defined by the Sellable interface.
    If you have a collection of items (e.g., a list of products) and you want to treat them uniformly based on their common behavior,
     (i.e., what they can be sold as), instantiating as Sellable can simplify your code.
    This approach allows you to easily switch or add different implementations of Sellable without changing the code that uses these objects.

     Instantiate as Product:
     This approach is more concrete and specific, focusing on the fact that the object is a type of product.
     If you need to access properties or methods specific to the Product class or its subclasses (e.g., properties like product name or methods like calculateTax()),
     then instantiating as Product might be more appropriate.
     It might be suitable when you're primarily dealing with the product's characteristics rather than its common behavior as a sellable item.
     If you instantiate objects as the interface type (Sellable), you can only access the methods and properties defined in the Sellable interface directly.
     If the getName method is specific to the Product class or its subclasses and not part of the Sellable interface, you won't be able to directly access it
     when you have a reference of type Sellable.
     Example:

         Sellable sellableItem = new ElectricalProduct();
         if (sellableItem instanceof Product) {
            Product productItem = (Product) sellableItem;
            String productName = productItem.getName();
            System.out.println(productName);
        }

     **/

    public static void main(String[] args){
        printReciept(simulateShoppingTrip());
    }


    private static void printReciept(ArrayList<Product> products){

        ArrayList<Product> itemsToPrint = new ArrayList<Product>();
        Collections.shuffle(itemsToPrint);

        System.out.println(Styling.color("WALKMART", Styling.Color.ORANGE, true));
        System.out.println("Addr: Fisherstreet 51, 23-10");
        System.out.println("Tlf: 69 96 96 69");
        System.out.println("****************");
        System.out.println( Styling.color("CASH RECIEPT", Styling.Color.WHITE, true));
        System.out.println("****************");

        double totalPrice = 0;
        for(Product product : products){
            totalPrice += product.getPrice();

            //15 spaces no matter what

            System.out.print( Styling.bold(product.name) );

            int remainingChars = 20 - product.name.length();
            for(int i = 0; i < remainingChars; i++) {
                System.out.print(" ");
            }

            remainingChars = 9 - String.valueOf(product.getPrice()).length();
            System.out.print(product.getPrice());
            System.out.print("kr");
            for(int i = 0; i < remainingChars; i++){
                System.out.print(" ");
            }
            System.out.print(
                 " - "
                + product.getSalesTaxPercent()
                + "% Tax"
                + " ("
                + Styling.italic(String.format("%.2f", (product.getSalesTaxPercent() / 100) * product.price) + "kr") //String.format("%.2f", value) formats the double value value with two decimal places (.2f)
                + ")" );
            System.out.println();
            System.out.println(Styling.italic("-" + product.description));
            System.out.println();
            }

        // Print Total
        System.out.println("****************");
        System.out.print(Styling.color("TOTAL:         ", Styling.Color.WHITE, true));
        System.out.print( Styling.color(String.valueOf(MathUtil.roundToNearestHalfOrWhole(totalPrice)), Styling.Color.WHITE, true) );
        System.out.println();


    }
    private static ArrayList<Product> simulateShoppingTrip(){
        ArrayList<Product> shoppingCart = new ArrayList<>();
        shoppingCart.add(new LiquorProducts(184.99, "Whiskey", "Single malt whiskey", 45.0));
        shoppingCart.add(new FoodProduct(39.99, "Chicken", "Boneless chicken breast", 7.0));
        shoppingCart.add(new Product(125.0, "Desk Lamp", "LED desk lamp"));
        shoppingCart.add(new ElectricalProduct(2499.99, "Gaming Console", "Next-gen gaming console", 200.0));
        shoppingCart.add(new FoodProduct(35.0, "Salad", "Mixed greens salad", 5.0));
        shoppingCart.add(new FoodProduct(19.45, "Pasta", "Spaghetti pasta", 365.0));
        shoppingCart.add(new Product(84.99, "Sunglasses", "UV protection sunglasses"));
        shoppingCart.add(new ElectricalProduct(1927.21, "Air Conditioner", "Inverter AC unit", 150.0));
        shoppingCart.add(new LiquorProducts(116.95, "Cognac", "VSOP cognac", 40.0));
        shoppingCart.add(new ElectricalProduct(482.41, "Router", "High-speed wireless router", 30.0));

        //test that the tax amount is cant be less than 3
        shoppingCart.add(new ElectricalProduct(7.0, "AA Battery", "A single AA Battery Cell", 2.0));
        //test that alcohol under 90kr are taxed at 80% not 120%
        shoppingCart.add(new LiquorProducts(89.99, "Wine", "Red wine", 14.0));
        return shoppingCart;
    }


    // ----------------Unused----------------
    static ArrayList<Product> products = new ArrayList();
    private static void initTestData(){
        // Create Products
        products.add(new Product(10.0, "Book", "A classic novel"));
        products.add(new Product(25.0, "T-shirt", "Cotton T-shirt"));
        products.add(new Product(30.0, "Backpack", "Water-resistant backpack"));
        products.add(new Product(15.0, "Desk Lamp", "LED desk lamp"));
        products.add(new Product(8.0, "Notebook", "Spiral-bound notebook"));
        products.add(new Product(40.0, "Shoes", "Running shoes"));
        products.add(new Product(20.0, "Watch", "Analog wristwatch"));
        products.add(new Product(12.0, "Umbrella", "Compact folding umbrella"));
        products.add(new Product(18.0, "Sunglasses", "UV protection sunglasses"));
        products.add(new Product(5.0, "Pencil Set", "Set of 12 colored pencils"));


        // Create Food Products
        products.add(new FoodProduct(10.0, "Milk", "Fresh milk", 7.0));
        products.add(new FoodProduct(8.0, "Bread", "Whole wheat bread", 3.0));
        products.add(new FoodProduct(15.0, "Cheese", "Cheddar cheese", 30.0));
        products.add(new FoodProduct(5.0, "Apples", "Fresh apples", 10.0));
        products.add(new FoodProduct(12.0, "Eggs", "Free-range eggs", 14.0));
        products.add(new FoodProduct(9.0, "Chicken", "Boneless chicken breast", 7.0));
        products.add(new FoodProduct(7.0, "Bananas", "Ripe bananas", 5.0));
        products.add(new FoodProduct(6.0, "Yogurt", "Greek yogurt", 10.0));
        products.add(new FoodProduct(11.0, "Salad", "Mixed greens salad", 5.0));
        products.add(new FoodProduct(13.0, "Pasta", "Spaghetti pasta", 365.0));

        // Create ElectricalProducts
        products.add(new ElectricalProduct(50.0, "Laptop", "High-performance laptop", 60.0));
        products.add(new ElectricalProduct(30.0, "Smartphone", "Flagship smartphone", 10.0));
        products.add(new ElectricalProduct(80.0, "TV", "4K Ultra HD TV", 120.0));
        products.add(new ElectricalProduct(25.0, "Headphones", "Noise-cancelling headphones", 20.0));
        products.add(new ElectricalProduct(40.0, "Refrigerator", "Energy-efficient refrigerator", 400.0));
        products.add(new ElectricalProduct(70.0, "Washing Machine", "Front-load washing machine", 150.0));
        products.add(new ElectricalProduct(55.0, "Vacuum Cleaner", "Bagless vacuum cleaner", 10.0));
        products.add(new ElectricalProduct(90.0, "Air Conditioner", "Inverter AC unit", 150.0));
        products.add(new ElectricalProduct(75.0, "Gaming Console", "Next-gen gaming console", 200.0));
        products.add(new ElectricalProduct(60.0, "Router", "High-speed wireless router", 30.0));

        // Create LiquorProducts
        products.add(new LiquorProducts(20.0, "Whiskey", "Single malt whiskey", 45.0));
        products.add(new LiquorProducts(15.0, "Vodka", "Premium vodka", 40.0));
        products.add(new LiquorProducts(25.0, "Rum", "Aged dark rum", 35.0));
        products.add(new LiquorProducts(18.0, "Wine", "Red wine", 14.0));
        products.add(new LiquorProducts(22.0, "Tequila", "Silver tequila", 38.0));
        products.add(new LiquorProducts(30.0, "Gin", "London dry gin", 42.0));
        products.add(new LiquorProducts(28.0, "Brandy", "Fine brandy", 36.0));
        products.add(new LiquorProducts(24.0, "Beer", "Craft beer", 5.0));
        products.add(new LiquorProducts(19.0, "Cognac", "VSOP cognac", 40.0));
        products.add(new LiquorProducts(21.0, "Champagne", "Brut champagne", 12.0));
    }
}
