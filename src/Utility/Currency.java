package Utility;

public abstract class Currency {

    /**
     *  Function to round a double to the nearest half or whole number.
     *  Mostly for currencies like DKK which only has 50 cent coins
     * @param value
     * @return rounded value
     */
    public static double roundToNearestHalfOrWhole(double value) {
        int roundedIntValue = (int) Math.round(value * 2);
        double roundedValue = roundedIntValue / 2.0;
        return roundedValue;
    }
}
