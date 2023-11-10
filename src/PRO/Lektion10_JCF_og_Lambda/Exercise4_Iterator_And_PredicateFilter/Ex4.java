package PRO.Lektion10_JCF_og_Lambda.Exercise4_Iterator_And_PredicateFilter;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {

    private static final List<Runner> runners = new ArrayList<>(List.of(
            new Runner("Ib", 30),
            new Runner("Per", 50),
            new Runner("Ole", 27),
            new Runner("Ulla", 40),
            new Runner("Jens", 35),
            new Runner("Hans", 28)
                                                                       ));

    public static List<Runner> getRunners() {

        return new ArrayList<>(runners);
    }

    public static void ex4() {

        System.out.println(runners);
        System.out.println();

        // OBS: Throws exception.
        for (Runner runner : runners) {
            if (runner.getLapTime() >= 40) {
                runners.remove(runner);
            }
        }
        System.out.println(runners);
        System.out.println();
    }

}