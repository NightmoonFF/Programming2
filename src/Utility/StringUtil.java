package Utility;

public abstract class StringUtil {

    public static int countMatches(String s, String regex) {

        return s.length() - s.replaceAll(regex, "").length();
    }

    public static boolean isNumeric(String s) {

        if (s.length() == 0) {
            return false;
        }
        final int sz = s.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
