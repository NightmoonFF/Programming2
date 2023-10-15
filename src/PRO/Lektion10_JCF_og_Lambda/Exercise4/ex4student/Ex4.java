package PRO.Lektion10_JCF_og_Lambda.Exercise4.ex4student;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {

    public static void main(String[] args) {
        List<Runner> runners = new ArrayList<>(List.of(
                new Runner("Ib", 30),
                new Runner("Per", 50),
                new Runner("Ole", 27),
                new Runner("Ulla", 40),
                new Runner("Jens", 35),
                new Runner("Hans", 28)
        ));
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