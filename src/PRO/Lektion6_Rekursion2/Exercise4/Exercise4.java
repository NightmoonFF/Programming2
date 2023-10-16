package PRO.Lektion6_Rekursion2.Exercise4;
public class Exercise4{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 4                                                                                              │
    │                                                                                                            │
    │    In the table below is a recursive definition of sequence of numbers:                                    │
    │    no0 = 2                                                                                                 │
    │    no1 = 1                                                                                                 │
    │    no2 = 5                                                                                                 │
    │    non = 2*non-3 - non-1 if n > 2 and n is even                                                            │
    │    non = non–1 + non-2 + 3*non-3 if n > 2 and n is odd                                                     │
    │                                                                                                            │
    │    Exercise 3.1                                                                                            │
    │    Calculate by hand the value of the third, fourth, fifth and sixth number in the sequence; that is       │
    │    the value of no3, no4, no5 and no6.                                                                     │
    │                                                                                                            │
    │    Exercise 3.2                                                                                            │
    │    Programme a recursive method named calcNo that calculates the n’th number in the sequence.              │
    │    The signature of the method is:                                                                         │
    │    	*Returns the n’th number in the sequence defined above.                                              │
    │    	*Requires: n >= 0                                                                                    │
    │    	public int CalcNo(int n)                                                                             │
    │                                                                                                            │
    │    Exercise 3.3                                                                                            │
    │    Programme an iterative method that calculates the n’th number in the sequence. No recursion             │
    │    is allowed here.                                                                                        │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    // 3.1 Hand Calculation:
    /*
        no0 = 2
        no1 = 1
        no2 = 5

        no3 = (non-1) + (non-2) + (3* (non-3)  | odd formula
        no3 = (no2) + (no1) + ( 3 * (no0) )
        no3 = 5 + 1 + 6
        no3 = 12

        no4 = 2 * (non-3) - (non-1) | even formula
        no4 = 2 * no1 - no3
        no4 = 2 * 1 - 9
        no4 =

        I dont fucking get this?
        something is off. 2-9?
     */

    public static void print(){
        System.out.println(calcNo(5));
        System.out.println(calcNoIterative(5));
    }

    /**
     * returns the n'th number in the sequence
     * @param n n'th sequence
     * @return
     */
    private static int calcNo(int n){
        if(n < 0) { throw new IllegalArgumentException("n must be >= 0"); }
        if(n == 0) { return 2; }
        if(n == 1) { return 1; }
        if(n == 2) { return 5; }

        if(Utility.MathUtil.isEven(n)) {
            return 2 * calcNo(n-3) - calcNo(n-1);
        }
        else {
            return calcNo(n-1) + calcNo(n-2) + (3 * calcNo(n-3));
        }
    }
        private static int calcNoIterative(int n) {
        if (n < 0) { throw new IllegalArgumentException("n must be >= 0"); }
        if (n == 0) { return 2; }
        if (n == 1) { return 1; }
        if (n == 2) { return 5; }

        int[] dp = new int[n + 1];
        dp[0] = 2;
        dp[1] = 1;
        dp[2] = 5;

        for (int i = 3; i <= n; i++) {

            if (Utility.MathUtil.isEven(i)) {

                dp[i] = 2 * dp[i - 3] - dp[i - 1];

            } else {

                dp[i] = dp[i - 1] + dp[i - 2] + (3 * dp[i - 3]);

            }
        }

        return dp[n];
    }




}
