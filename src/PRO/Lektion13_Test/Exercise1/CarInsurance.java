package PRO.Lektion13_Test.Exercise1;

import static Utility.MathUtil.*;

public class CarInsurance {
    private final double basisPremium;
    public CarInsurance(double basisPremium){
        this.basisPremium = basisPremium;
    }

    public double calculatePremium(int age, boolean isWoman, int yearsWithoutDamage){
        double premium = basisPremium;

        if(yearsWithoutDamage < 0) { throw new RuntimeException("Years without damage cannot be a negative number"); }
        if(age < 0) { throw new RuntimeException("Age of the insurance holder cannot be negative"); }
        if(age < 18) { throw new RuntimeException("The insurance holder must be over 18 years old"); }
        //TODO: er der forskel på at throw RuntimeException og throw IllegalArguementException

        if(age < 25) { premium = premium + (premium * 0.25); }
        if(isWoman) { premium = premium - (premium * 0.05); }

        if(isBetween(yearsWithoutDamage, 3, 5)) { premium = premium - (premium * 0.15); }
        else if(isBetween(yearsWithoutDamage, 6, 8)) { premium = premium - (premium * 0.25); }
        else if(yearsWithoutDamage > 8) { premium = premium - (premium * 0.35); }

        return premium;
    }

}
