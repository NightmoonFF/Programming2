package PRO.Lektion2_Nedarvning_og_Polymorphi.Opgave3;


public abstract class Discount {

    public double getDiscount(double price) {
        throw new NullPointerException("Discount not applied");
    }
}


class PercentDiscount extends Discount{
    int discountPercentage;

    public PercentDiscount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscount(double price) {
        double result = 0;
        result = (price/100) * discountPercentage;
        return result;
    }

    @Override
    public String toString(){
        return "(" + discountPercentage + "% Discount)";
    }
}


class FixedDiscount extends Discount{
    int fixedDiscount;
    int discountLimit;

    public FixedDiscount(int fixedDiscount, int discountLimit){
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    @Override
    public double getDiscount(double price){
        double result = 0;
        if(price >= discountLimit){
            result = price-fixedDiscount;
        }
        else{
            result = price;
        }
        return result;
    }

    @Override
    public String toString(){
        return "(" + fixedDiscount + "kr Discount)";
    }
}


