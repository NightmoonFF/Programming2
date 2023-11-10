package PRO.Lektion10_JCF_og_Lambda.Exercise4_Iterator_And_PredicateFilter;

import Utility.Styling;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Exercise4 {

    /*
        ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
        │                                                                                                            │
        │    Exercise 4                                                                                              │
        │                                                                                                            │
        │    Importer filen Ex4Student.zip til en src folder i IntelliJ.                                             │
        │    a) Kør programmet og bemærk den exception, som kastes. Hvad er problemet?                               │
        │    b) Erstat den fejlende for-sætning med en løkke, som anvender en iterator til at fjerne løbere          │
        │    med lapTime >= 40. Udskriv listen med løberne.                                                          │
        │    c) Lav en metode, som fjerner løbere fra en liste af løbere vha. et lambda udtryk. Metoden              │
        │    skal implementeres vha. en iterator.                                                                    │
        │    Metodens hovede:                                                                                        │
        │    	*                                                                                                    │
        │    	* Removes runners that satisfies the given filter.                                                   │
        │    	* Returns true, if any runner is removed.                                                            │
        │    	*                                                                                                    │
        │    	public static boolean removeIf(                                                                      │
        │    		List<Runner> runners, Predicate<Runner> filter)                                                  │
        │                                                                                                            │
        │    d) Bruge metoden fra c) til at fjerne løbere med lapTime >= 40.                                         │
        │    Kontroller, at koden i spørgsmål b) og koden i spørgsmål c) giver samme resultat.                       │
        │    e) Brug metoden List.removeIf() og en Predicate lambda til at fjerne løbere med                         │
        │    lapTime >= 40.                                                                                          │
        │    Kontroller, at koden i spørgsmål d) og koden i spørgsmål e) giver samme resultat.                       │
        │                                                                                                            │
        └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
    */
    public static void print() {

        // A)
        // ConcurrentModificationException.
        // Denne exception sker fordi at vi fjerner et element af iterationen imens den foretages
        System.out.println(Styling.txtWhite("Exercise B:"));
        ExB();
        System.out.println(Styling.txtWhite("\nExercise C:"));
        ExC();
        System.out.println(Styling.txtWhite("\nExercise D:"));
        ExD();
        System.out.println(Styling.txtWhite("\nExercise E:"));
        ExE();
    }

    private static void ExB() {

        List<Runner> runners = Ex4.getRunners();

        System.out.println(runners);
        Iterator<Runner> iterator = runners.iterator();
        for (Iterator<Runner> it = iterator; it.hasNext(); ) {
            if (it.next().getLapTime() >= 40) {
                it.remove();
            }
        }
        System.out.println(runners);
    }

    private static void ExC() {

        List<Runner> runners = Ex4.getRunners();

        System.out.println(runners);

        // Lambda expression Predicate filter
        Predicate<Runner> filter = r -> r.getLapTime() <= 30;
        removeIf(runners, filter);

        System.out.println(runners);
    }

    private static void ExD() {

        List<Runner> runners = Ex4.getRunners();

        System.out.println(runners);
        Predicate<Runner> filter = r -> r.getLapTime() >= 40;
        removeIf(runners, filter);
        System.out.println(runners);

        System.out.println("should have same result as:");

        runners = Ex4.getRunners();
        System.out.println(runners);
        Iterator<Runner> iterator = runners.iterator();
        for (Iterator<Runner> it = iterator; it.hasNext(); ) {
            if (it.next().getLapTime() >= 40) {
                it.remove();
            }
        }
        System.out.println(runners);
    }

    private static void ExE() {

        List<Runner> runners = Ex4.getRunners();

        System.out.println(runners);
        Predicate<Runner> filter = r -> r.getLapTime() >= 40;
        removeIf(runners, filter);
        System.out.println(runners);

        System.out.println("should have same result as:");

        runners = Ex4.getRunners();
        System.out.println(runners);
        runners.removeIf(r -> r.getLapTime() >= 40);
        System.out.println(runners);
    }

    private static boolean removeIf(List<Runner> runners, Predicate<Runner> filter) {

        Iterator<Runner> iterator = runners.iterator();

        for (Iterator<Runner> it = iterator; it.hasNext(); ) {
            if (filter.test(it.next())) {
                it.remove();
            }
        }

        return false;
    }

}
