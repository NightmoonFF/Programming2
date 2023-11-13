package PRO.Lektion11_StrategyPattern.Exercise4.EvaluatorStudent;

import Utility.StringUtil;

public class EmailEvaluator implements Evaluator {

    /**
     * Returns true, if s contains a valid email address.
     */
    @Override
    public boolean isValid(String s) {

        // Check if "@" exists, or there are multiple
        if (!s.contains("@") || StringUtil.countMatches(s, "@") > 1) {
            return false;
        }

        // Separate into two strings at "@"
        String[] str = s.split("@", -1);

        // Validate each word separated by "." in left side
        String[] userStr = str[0].split("\\.", -1);
        for (String user : userStr) {
            if (!isWord(user)) { return false; }
        }

        // Same for right side, but make sure there's only two
        String[] hostStr = str[1].split("\\.", -1);
        if (hostStr.length > 2) {
            return false;
        }
        for (String host : hostStr) {
            if (!isWord(host)) { return false; }
        }

        return true;
    }

    /**
     * Returns true, if s is an acceptable word.
     * That is, s is not empty, and all letters
     * are in 'A'..'Z', 'a'..'z' or '0'..'9'.
     */
    public boolean isWord(String s) {

        if (s.length() == 0) { return false; }
        else return s.matches("[a-zA-Z0-9]+");

    }

}
