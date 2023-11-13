package Utility;


public abstract class Regex {

    /**
     * Regular expression for all whitespace between words/characters,
     * including tabs, multiple spaces, etc.
     * Use case example: argument for String.split(), to make an array.
     *
     * @return the regex as a string
     */
    public static String split(SplitType splitType) {

        return switch (splitType) {
            case allWhitespace -> "\\s+";
            case commaSeparated -> ",";
        };

    }

    public enum SplitType {allWhitespace, commaSeparated}

}
