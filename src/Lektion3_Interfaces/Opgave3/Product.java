package Lektion3_Interfaces.Opgave3;

public class Product implements Sellable{
    // Class is not abstract(un-instantiable), since you are able to
    //  instantiate products that are not explicitly defined with unique traits.
    // I don't believe that I have to specify "implements Sellable" in the
    //  subclasses, but that it should be fine to just override the methods
    double price;
    String name;
    String description;
    public Product(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    /**
     * @return 25 - the Standard DK Moms
     */
    @Override
    public double getSalesTaxPercent() {
        return 25;
    }

    /**
     * @return the price after tax
     */
    @Override
    public double getPriceAfterTax(){
        return (getSalesTaxPercent() / 100) * price + price;
    }

    //region Getters & Setters
    public double getPrice(){
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
class FoodProduct extends Product{
    double expectedDaysToExpire;
    public FoodProduct(double price, String name, String description, double expectedDaysToExpire) {
        super(price, name, description);
        this.expectedDaysToExpire = expectedDaysToExpire;
    }
    @Override
    public double getSalesTaxPercent() {
        return 5;
    }

    public double getExpectedDaysToExpire() {
        return expectedDaysToExpire;
    }
    public void setExpectedDaysToExpire(double expectedDaysToExpire) {
        this.expectedDaysToExpire = expectedDaysToExpire;
    }
}
class ElectricalProduct extends Product{
    double averageKilowattHours;
    public ElectricalProduct(double price, String name, String description, double averageKilowattHours) {
        super(price, name, description);
        this.averageKilowattHours = averageKilowattHours;
    }

    /**
     * @override Ensure that the total tax payed is at least 3kr
     * @return the product price after taxation
     */
    @Override
    public double getPriceAfterTax(){

        if(getSalesTaxPercent() / 100 * price < 3){
            return 3 + price;
        }
        // Else Tax normally
        else{
            return (getSalesTaxPercent() / 100) * price + price;
        }
    }
    @Override
    public double getSalesTaxPercent() {
        return 30;
    }
}
class LiquorProducts extends Product{
    double alcoholVolume;
    public LiquorProducts(double price, String name, String description, double alcoholVolume) {
        super(price, name, description);
        this.alcoholVolume = alcoholVolume;
    }

    /**
     * @return 120 if price is greater than 90; else returns 80
     */
    @Override
    public double getSalesTaxPercent(){
        if(price > 90){
            return 120;
        }
        else{ return 80; }
    }
    public double getAlcoholVolume() {
        return alcoholVolume;
    }
    public void setAlcoholVolume(double alcoholVolume) {
        this.alcoholVolume = alcoholVolume;
    }
}
