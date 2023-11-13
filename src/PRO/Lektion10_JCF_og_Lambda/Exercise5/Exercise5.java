package PRO.Lektion10_JCF_og_Lambda.Exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exercise5 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 5                                                                                              │
    │                                                                                                            │
    │    Du har en tekst fil med karakter for film. Hver film kar en karakter mellem 1 (dårlig) og 5             │
    │    (fremragende). Den første linje i filen angiver hvor mange karakterer der er i filen. Hver              │
    │    karakter består af to linjer: Navnet på filmen og karakteren for filmen. Her er et eksempel på          │
    │    fire forskellige film og de 7 karakterer der er givet.                                                  │
    │    7                                                                                                       │
    │    Harry Potter og de vises sten                                                                           │
    │    4                                                                                                       │
    │    Harry Potter og de vises sten                                                                           │
    │    5                                                                                                       │
    │    Min Søsters børn i Afrika                                                                               │
    │    1                                                                                                       │
    │    Harry Potter og de vises sten                                                                           │
    │    4                                                                                                       │
    │    Min Søsters børn i Afrika                                                                               │
    │    2                                                                                                       │
    │    Løvernes konge                                                                                          │
    │    3                                                                                                       │
    │    Junglebogen                                                                                             │
    │    4                                                                                                       │
    │    Skriv et program der læser en sådan fil, og beregner den gennemsnitlige karakter for hver film          │
    │    og udskriver gennemsnittet for hver fil med angivelse af hvor mange karakterer der er givet.            │
    │    Output kunne f.eks se således ud:                                                                       │
    │    Harry Potter og de vises sten: 3 karakterer, gennemsnit 4,3                                             │
    │    Min Søsters børn i Afrika: 2 karakterer, gennemsnit 1,5                                                 │
    │    Løvernes konge: 1 karakter, gennemsnit 3                                                                │
    │    Junglebogen: 1 karakter, gennemsnit 4                                                                   │
    │    Anvend en eller flere Map for at beregne output.                                                        │
    │    Hjælp: Key i map skal være String (navnet på film)                                                      │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    //TODO: why is this not allowed inside the lambda like the other variables?
    static double sum = 0;

    public static void print() {

        String filePath = "/home/elias/IdeaProjects/Programming 2/src/PRO/Lektion10_JCF_og_Lambda/Exercise5/Reviews";
        calculateReviewAverage(readReviewFile(filePath));
    }

    private static void calculateReviewAverage(HashMap<String, List<Integer>> reviews) {

        // Iterate each movie
        reviews.entrySet().iterator().forEachRemaining(movie -> {

            // Iterate each review for that movie and add up sum
            sum = 0;
            movie.getValue().forEach(rating -> sum += rating);

            int ratings = movie.getValue().size();
            double avg = sum / ratings;
            System.out.println(
                    movie.getKey() + " - " + String.format("%.1f", avg) + " (" + movie.getValue()
                                                                                      .size() + (ratings == 1 ? " " +
                            "review)" : " reviews)"));
        });

    }


    /**
     * @precondition file is formatted as Line1: Film Title, Line2: Integer Film rating value, repeating as needed.
     */
    private static HashMap<String, List<Integer>> readReviewFile(String filepath) {

        HashMap<String, List<Integer>> reviews = new HashMap<>();

        try {
            File myFile = new File(filepath);
            Scanner myScanner = new Scanner(myFile);

            while (myScanner.hasNextLine()) {

                String movieTitle = myScanner.nextLine();
                Integer rating = Integer.parseInt(myScanner.nextLine());

                if (reviews.containsKey(movieTitle)) {
                    reviews.get(movieTitle).add(rating);
                }
                else {
                    reviews.put(movieTitle, new ArrayList<>());
                    reviews.get(movieTitle).add(rating);
                }
            }

            myScanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return reviews;
    }

}
