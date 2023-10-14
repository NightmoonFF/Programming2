package PRO.Lektion13_Test.Exercise3;

import Utility.MathUtil;

public class Daycare {

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

    /*
    * Returns the total payment for a family minus discount
    * Pre: small >= 0, big >= 0
    * (small is the number of preschool children
    * and big is the number of children attending school)
    */
    public int totalPayment(int small, int big){

        if(small <= 0 && big <= 0) { throw new RuntimeException("At least one child must exist"); }

        int smallCost = 2000;
        int bigCost = 1000;
        int totalCost = 0;

        int remainingSmall = small;
        int remainingBig = big;

        // Only one child – no discount – you have to pay full price.
        if (small+big == 1) {
            if(small == 1) { return smallCost; }
            if(big == 1) { return bigCost; }
        }

        // If there are 2 or 3 children, you pay full price for the most expensive child, while you
        // get a discount of 25% for the rest.
        else if (small + big >= 2) {

            // first child is full price
            if(small > 0) { totalCost += smallCost; remainingSmall--; }
            else { totalCost += bigCost; remainingBig--; }

            // calculate the other 1 or 2, of either
            for(int i = 0; i < remainingSmall; i++){
                totalCost += MathUtil.percentageReduction(25, smallCost);
            }
            for(int i = 0; i < remainingBig; i++){
                totalCost += MathUtil.percentageReduction(25, bigCost);
            }

        }

        // If there are more than 3 children, use the above model for the first 3 children.
        // For the fourth, fifth (and so on) child you get a discount of 50%
        if (small + big > 3){

            for(int i = 0; i < remainingSmall; i++){
                totalCost += MathUtil.percentageReduction(50, smallCost);
            }
            for(int i = 0; i < remainingBig; i++){
                totalCost += MathUtil.percentageReduction(50, bigCost);
            }
        }

        return totalCost;
    }
}