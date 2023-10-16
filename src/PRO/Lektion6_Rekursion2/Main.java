package PRO.Lektion6_Rekursion2;

import PRO.Lektion6_Rekursion2.Exercise1.Exercise1;
import PRO.Lektion6_Rekursion2.Exercise2.Exercise2;
import PRO.Lektion6_Rekursion2.Exercise3.Exercise3;
import PRO.Lektion6_Rekursion2.Exercise4.Exercise4;
import PRO.Lektion6_Rekursion2.Exercise5.Exercise5;
import PRO.Lektion6_Rekursion2.Exercise6.Exercise6;
import PRO.Lektion6_Rekursion2.Exercise7.Exercise7;
import PRO.Lektion6_Rekursion2.Exercise8.Exercise8;
import Utility.Styling;
public class Main {
	public static void main(String[] args) {

		int printExercise = 6;

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
				case 5:
					System.out.println(Styling.txtOrange(Styling.underline("\nExercise 5 \n")));
					Exercise5.print();
					break;
				case 6:
					System.out.println(Styling.txtOrange(Styling.underline("\nExercise 6 \n")));
					Exercise6.print();
					break;
				case 7:
					System.out.println(Styling.txtOrange(Styling.underline("\nExercise 7 \n")));
					Exercise7.print();
					break;
				case 8:
					System.out.println(Styling.txtOrange(Styling.underline("\nExercise 8 \n")));
					Exercise8.print();
					break;

		}	}
}
