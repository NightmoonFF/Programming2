package Utility;

public class ValidationUtil {

    public static boolean validateInt(String s) {

        if (s.isEmpty() || s.isBlank()) { return false; }
        else {
            try {
                Integer.parseInt(s.trim());
            }
            catch (NumberFormatException e) { return false; }
        }
        return true;
    }

    public static Boolean validateDouble(String stringValue) {

        if (stringValue.length() == 0) { return false; }
        else {
            try {
                Double.parseDouble(stringValue.trim());
            }
            catch (NumberFormatException e) { return false; }
        }
        return true;

    }

}
