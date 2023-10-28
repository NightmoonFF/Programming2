package PRO.Lektion8_Generics;

import PRO.Lektion8_Generics.Exercise1_GenericClass.Exercise1;
import PRO.Lektion8_Generics.Exercise2_GenericMethod_HashSet.Exercise2;
import PRO.Lektion8_Generics.Exercise3.Exercise3;
import PRO.Lektion8_Generics.Exercise4.Exercise4;
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
