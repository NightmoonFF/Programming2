package PRO.Lektion10_JCF_og_Lambda.Exercise2_Comparator_Sort_ForEach;

import Utility.Styling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise2 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Importer filen Ex2Student.zip til src folderen i IntelliJ. Indsæt kode i main metoden som løser         │
    │    spørgsmål a - c.                                                                                        │
    │                                                                                                            │
    │    a) Udskriv en linie for hver løber med name og lapTime ved at bruge List.forEach() metoden              │
    │    med en Consumer lambda.                                                                                 │
    │    b) Som a), men udskriv kun løberne med lapTime < 30.                                                    │
    │    c) Sorter løberne stigende efter lapTime ved at bruge List.sort() metoden med en Comparator             │
    │    lambda. Udskriv løberne.                                                                                │
    │    d) Extra (ikke en del af pensum):                                                                       │
    │                                                                                                            │
    │    Beregn summen af løbernes lapTime ved at bruge List.forEach() og en Consumer lambda.                    │
    │    Brug en lokal variabel sum i metoden, som bruger lamda udtrykket, til at gemme summen i.                │
    │    Hint: Erklær sum som et array med længde 1.                                                             │
    │                                                                                                            │
    │    Bemærk: Lambda udtryk kan benytte lokale variable fra metoden, som lambda udtrykket er                  │
    │    en del af, men det kræver at variablen er erklæret final (eller er effektivt final, dvs. aldrig         │
    │    opdateres). Vi vil derfor ikke bruge lambda udtryk, som anvender lokale variable                        │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    static List<Runner> runners = new ArrayList<>(
            List.of(new Runner("Ib", 30), new Runner("Per", 50), new Runner("Ole", 27), new Runner("Ulla", 40),
                    new Runner("Jens", 35), new Runner("Hans", 28)));

    public static void print() {

        ExA();
        ExB();
        ExC();
        ExD();
    }

    /**
     * Normal forEach lambda (void)
     */
    private static void ExA() {

        System.out.println(Styling.txtWhite("Exercise A:"));
        runners.forEach(r -> System.out.println(r.toString()));
    }

    /**
     * Lambda with conditional (if statement)
     */
    private static void ExB() {

        System.out.println(Styling.txtWhite("\nExercise B:"));
        runners.forEach(r -> {
            if (r.getLapTime() < 30) {
                System.out.println(r);
            }
        });
    }

    /**
     * Lambda with Comparator on Sort()
     */
    private static void ExC() {

        System.out.println(Styling.txtWhite("\nExercise C:"));
        Collections.sort(runners, Comparator.comparingInt(Runner::getLapTime));
        runners.forEach(r -> System.out.println(r.toString()));
    }

    /**
     * Consumer lambda
     */
    private static void ExD() {

        System.out.println(Styling.txtWhite("\nExercise D:"));
    }

}
