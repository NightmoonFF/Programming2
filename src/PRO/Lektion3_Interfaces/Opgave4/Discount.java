package PRO.Lektion3_Interfaces.Opgave4;

public interface Discount {
    public double getDiscountedPrice(double price);
    public String getDescription();
}

class PercentDiscount implements Discount{
    int discountPercentage;
    public PercentDiscount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    @Override
    public double getDiscountedPrice(double price) {
        double result = 0;
        result = (price/100) * discountPercentage;
        return result;
    }
    @Override
    public String getDescription(){
        return "Applies a discount based on a Percentage (%)";
    }
    @Override
    public String toString(){
        return "(" + discountPercentage + "% Discount)";
    }
}
class FixedDiscount implements Discount{
    int fixedDiscount;
    int discountLimit;
    public FixedDiscount(int fixedDiscount, int discountLimit){
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }
    @Override
    public double getDiscountedPrice(double minPrice){
        double result = 0;
        if(minPrice >= discountLimit){
            result = minPrice-fixedDiscount;
        }
        else{
            result = minPrice;
        }
        return result;
    }
    @Override
    public String getDescription(){
        return "A discount which requires a certain total price to take effect";
    }
    @Override
    public String toString(){
        return "(" + fixedDiscount + "kr Discount)";
    }
}
class AgeDiscount implements Discount{
    int requiredAge;
    int customerAge;

    public AgeDiscount(int customerAge, int requiredAge) {
        this.customerAge = customerAge;
        this.requiredAge = requiredAge;
    }
    @Override
    public double getDiscountedPrice(double price) {
        if(customerAge >= requiredAge){
            return customerAge/100 * price + price;
        }
        return price;
    }
    @Override
    public String getDescription() {
        return null;
    }
}