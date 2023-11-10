package PRO.Lektion16_List_ADT;

import PRO.Lektion16_List_ADT.Exercise1.Exercise1;
import PRO.Lektion16_List_ADT.Exercise2.Exercise2;
import PRO.Lektion16_List_ADT.Exercise3.Exercise3;
import Utility.Styling;
public class Main {
	public static void main(String[] args) {

		int printExercise = 1;

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

		}	}
}
