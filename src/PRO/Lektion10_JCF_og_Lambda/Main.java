package PRO.Lektion10_JCF_og_Lambda;

import PRO.Lektion10_JCF_og_Lambda.Exercise1.*;
import Utility.Styling;

public class Main {
	public static void main(String[] args) {

		int printExercise = 1;

		switch (printExercise) {
			case 1:
				System.out.println(Styling.txtOrange(Styling.underline("\nExercise 1 \n")));
				Exercise1.print();
				break;
		}
	}
}
