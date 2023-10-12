package Utility;

public abstract class MathUtil {

    /**
     * Determines if a given integer value is between a given range
     * INCLUDES lower and upper bound
     * @param x - input value
     * @param lower - lower bound
     * @param upper - upper bound
     * @return true if input between bounds
     */
    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    /**
     * Determines if a given double value is between a given range
     * @param x - input value
     * @param lower - lower bound
     * @param upper - upper bound
     * @return true if input between bounds
     */
    public static boolean isBetween(double x, double lower, double upper) {
        return lower <= x && x <= upper;
    }

    /**
     * Determines if an integer is even or odd
     * @param n
     * @return true if even
     */
    public static boolean isEven(int n){
        // even, because the low bit will always be set on an odd number
        if( (n & 1) == 0){ return true; }
        else { return false; }
    }

    /**
     *  Rounds a double to the nearest half or whole number.
     *  Mostly for currencies like DKK which only has 50 cent coins
     * @param value
     * @return rounded result
     */
    public static double roundToNearestHalfOrWhole(double value) {
        int roundedIntValue = (int) Math.round(value * 2);
        double roundedValue = roundedIntValue / 2.0;
        return roundedValue;
    }
}
