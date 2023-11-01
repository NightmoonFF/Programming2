package PRO.Lektion5_Rekursion;

import Utility.Styling;

public class main {

    public static void main(String[] args) {

        int printExercise = 5;

        switch (printExercise) {
            case 1:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 1 \n")));
                Exercises.PrintExercise1();
                break;
            case 2:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 2 \n")));
                Exercises.PrintExercise2();
                break;
            case 3:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 3 \n")));
                Exercises.PrintExercise3();
                break;
            case 4:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 4 \n")));
                Exercises.PrintExercise4();
                break;
            case 5:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 5 \n")));
                Exercises.scanDir("/home/elias/IdeaProjects/Programming 2/src/PRO");
                break;
            case 6:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 6 \n")));
                Exercises.printExercise6();
                break;
            case 7:
                System.out.println(Styling.txtOrange(Styling.underline("\nExercise 6 \n")));
                System.out.println(Exercises.findPossibleDominoCoverage(10));
        }
    }

}
