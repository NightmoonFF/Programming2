package PRO.Lektion10_JCF_og_Lambda;

import PRO.Lektion10_JCF_og_Lambda.Exercise1.Exercise1;
import PRO.Lektion10_JCF_og_Lambda.Exercise2_Comparator_Sort_ForEach.Exercise2;
import PRO.Lektion10_JCF_og_Lambda.Exercise3_Iterator_List_Map.Exercise3;
import PRO.Lektion10_JCF_og_Lambda.Exercise4_Iterator_And_PredicateFilter.Exercise4;
import PRO.Lektion10_JCF_og_Lambda.Exercise5.Exercise5;
import PRO.Lektion10_JCF_og_Lambda.Exercise6.Exercise6;
import Utility.Styling;

public class Main {

    public static void main(String[] args) {

        int printExercise = 6;

        switch (printExercise) {
            case 1 -> {
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 1 \n")));
                Exercise1.print();
            }
            case 2 -> {
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 2 \n")));
                Exercise2.print();
            }
            case 3 -> {
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 3 \n")));
                Exercise3.print();
            }
            case 4 -> {
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 4 \n")));
                Exercise4.print();
            }
            case 5 -> {
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 5 \n")));
                Exercise5.print();
            }
            case 6 -> {
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 6 \n")));
                Exercise6.runExercise();
            }
        }
    }

}
