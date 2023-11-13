package PRO.Lektion12_ObserverPattern;

import PRO.Lektion12_ObserverPattern.Exercise1.Exercise1;
import PRO.Lektion12_ObserverPattern.Exercise2.Exercise2;
import PRO.Lektion12_ObserverPattern.Exercise3.Exercise3;
import PRO.Lektion12_ObserverPattern.Exercise4.Exercise4;
import Utility.Styling;

public class Main {

    public static void main(String[] args) {

        int printExercise = 3;

        switch (printExercise) {
            case 1:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 1 \n")));
                Exercise1.print();
                break;
            case 2:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 2 \n")));
                Exercise2.print();
                break;
            case 3:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 3 \n")));
                Exercise3.print();
                break;
            case 4:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 4 \n")));
                Exercise4.print();
                break;

        }
    }

}
