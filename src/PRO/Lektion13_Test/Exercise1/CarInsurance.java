package PRO.Lektion13_Test.Exercise1;

import static Utility.MathUtil.*;

public class CarInsurance {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    In this exercise you are going to test a method from the CarInsurance class using JUnit.                │
    │    public class CarInsurance {                                                                             │
    │    private final double basisPremium; // invariant: basisPremium > 0.                                      │
    │    *                                                                                                       │
    │    * Create a CarInsurance.                                                                                │
    │    * Pre: basisPremium > 0.                                                                                │
    │    *                                                                                                       │
    │    public CarInsurance (double basisPremium) {                                                             │
    │    this.basisPremium = basisPremium;                                                                       │
    │    }                                                                                                       │
    │    *                                                                                                       │
    │    * Calculate and return a premium based of the following rules:                                          │
    │    * - person with age below 25: 25% is added to the basis premium,                                        │
    │    * - woman: the basis premium is reduced with 5%,                                                        │
    │    * - if the person have been driving without damages for:                                                │
    │    * - 0 to 2 years, the basis premium is reduced with 0%,                                                 │
    │    * - 3 to 5 years, the basis premium is reduced with 15%,                                                │
    │    * - 6 to 8 years, the basis premium is reduced with 25%,                                                │
    │    * - more than 8 years, the basis premium is reduced with 35%.                                           │
    │    * Throws a RuntimeException, if age < 18, or yearsWithoutDamage < 0,                                    │
    │    * or YearsWithoutDamage > age-18.                                                                       │
    │    *                                                                                                       │
    │    public double calculatePremium(int age, boolean isWoman, int yearsWithoutDamage) {                      │
    │        //T0D0                                                                                              │
    │    }                                                                                                       │
    │                                                                                                            │
    │    Program the method and test it using JUnit (remember also to test for cases, where an                   │
    │    exception is thrown). Use the test case developed in SU.                                                │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/
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
