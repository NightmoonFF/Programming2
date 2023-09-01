package Utility;

import java.awt.*;

import static Utility.ConsoleStyling.Color.*;

public abstract class ConsoleStyling {
    public enum Color{
        RED,
        GREEN,
        BLUE,
        YELLOW,
        ORANGE,
        PURPLE,
        PINK,
        BROWN,
        WHITE,
        Color, BLACK
    }


    // Custom
    public static String title(String text) {
        String s = text;
        s = color(s, YELLOW, true);
        return s;
    }
    public static String result(String text) {
        String s = text;
        s = color(s, WHITE, false);
        s = underline(s);
        return s;
    }


    // Standard
    public static String color(String text, String hexColor, boolean bold) {

        if(bold == false){
            return "\033[38;2;" + hexToRgb(hexColor) + "m" + text + "\033[0m";
        }
        else{
            return bold("\033[38;2;" + hexToRgb(hexColor) + "m" + text + "\033[0m");
        }
    }
    public static String color(String text, Color enumColor, boolean bold) {

        String hexCode;
        switch (enumColor) {
            case RED -> hexCode = "#FF0000";
            case GREEN -> hexCode = "#00FF00";
            case BLUE -> hexCode = "#0000FF";
            case YELLOW -> hexCode = "#FFFF00";
            case ORANGE -> hexCode = "#FFA500";
            case PURPLE -> hexCode = "#800080";
            case PINK -> hexCode = "#FFC0CB";
            case BROWN -> hexCode = "#A52A2A";
            case WHITE -> hexCode = "#FFFFFF";
            case BLACK -> hexCode = "#000000";
            default -> hexCode = "Unknown";
        }

        if(bold == false){
            return "\033[38;2;" + hexToRgb(hexCode) + "m" + text + "\033[0m";
        }
        else{
            return bold("\033[38;2;" + hexToRgb(hexCode) + "m" + text + "\033[0m");
        }

    }
    public static String bold(String text) { return "\u001B[1m" + text + "\u001B[0m"; }
    public static String italic(String text) { return "\033[3m" + text + "\033[0m"; }
    public static String underline(String text) { return "\033[4m" + text + "\033[0m"; }

    //region Private Methods
    private static String hexToRgb(String hex) {
        hex = hex.replace("#", "");
        int color = Integer.parseInt(hex, 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = color & 0xFF;
        return r + ";" + g + ";" + b;
    }
    //endregion
}
