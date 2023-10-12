package PRO.Lektion13_Test;

import Utility.Dispatchable;

public class Exercises implements Dispatchable {
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
    │        //TODO                                                                                              │
    │    }                                                                                                       │
    │                                                                                                            │
    │    Program the method and test it using JUnit (remember also to test for cases, where an                   │
    │    exception is thrown). Use the test case developed in SU.                                                │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise1(){
        // Exercise completed without printable result
    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    The following table is taken from the homepage of the libraries in Aarhus and shows the fines           │
    │    if you return materials (books, CD’s etc.) too late (the table is simplified – actually there are       │
    │    more intervals than stated here). (You don’t have to care about weekends, holidays etc.)                │
    │                                                                                                            │
    │    Excess -------- 0 to 17 -------- 18+ years                                                              │
    │    1 – 7 days        10 kr.            20 kr.                                                              │
    │    8 – 14 days       30 kr.            60 kr.                                                              │
    │    15+ days          45 kr.            90 kr.                                                              │
    │                                                                                                            │
    │    The calculation is done using the following method:                                                     │
    │    *                                                                                                       │
    │    Return the fine according to the table above.                                                           │
    │    Pre: calculatedDate < actualDate                                                                        │
    │    (calculatedDate is the expected return date and                                                         │
    │    actualDate is the day you actually return the book)                                                     │
    │    *                                                                                                       │
    │    public int calculateFine(                                                                               │
    │            LocalDate calculatedDate,                                                                       │
    │            LocalDate actualDate,                                                                           │
    │            boolean adult)                                                                                  │
    │    Program the method and test it using JUnit. Use the test cases developed in SU                          │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise2(){
        // Exercise completed without printable result
    }



/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 3                                                                                              │
    │                                                                                                            │
    │    In X-town municipality, families with children are offered childcare for preschool children as          │
    │    daycare and for children attending school (until 4th grade) as SFA (School Free time                    │
    │    Arrangement).                                                                                           │
    │    The charges are 2000 kr. for daycare and 1000 kr. for SFA. You will get a discount for siblings         │
    │    according to these rules:                                                                               │
    │        - Only one child – no discount – you have to pay full price.                                        │
    │        - If there are 2 or 3 children, you pay full price for the most expensive child, while you          │
    │          get a discount of 25% for the rest.                                                               │
    │        - If there are more than 3 children, use the above model for the first 3 children. For the          │
    │          fourth, fifth (and so on) child you get a discount of 50%                                         │
    │                                                                                                            │
    │    The following method calculates the total price for a family:                                           │
    │    *                                                                                                       │
    │    * Returns the total payment for a family minus discount                                                 │
    │    * Pre: small >= 0, big >= 0                                                                             │
    │    * (small is the number of preschool children                                                            │
    │    * and big is the number of children attending school)                                                   │
    │    *                                                                                                       │
    │    public int totalPayment (int small, int big)                                                            │
    │    Program the method and test it using JUnit. Make new test cases.                                        │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void printExercise3(){

    }



}
