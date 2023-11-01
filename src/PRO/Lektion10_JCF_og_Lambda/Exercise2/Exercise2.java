package PRO.Lektion10_JCF_og_Lambda.Exercise2;

import java.util.ArrayList;
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

    public static void print() {

        List<Runner> runners = new ArrayList<>(
                List.of(new Runner("Ib", 30), new Runner("Per", 50), new Runner("Ole", 27), new Runner("Ulla", 40),
                        new Runner("Jens", 35), new Runner("Hans", 28)));

        System.out.println("Exercise A:");
        runners.forEach(r -> System.out.println(r.toString()));
        System.out.println("Exercise B:");
        runners.forEach(runner -> runner.getLapTime() > 30);
    }

}
