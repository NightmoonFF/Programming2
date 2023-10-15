package PRO.Lektion13_Test.Exercise2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryFee {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    The following table is taken from the homepage of the libraries in Aarhus and shows the fines           │
    │    if you return materials (books, CD’s etc.) too late (the table is simplified – actually there are       │
    │    more intervals than stated here). (You don’t have to care about weekends, holidays etc.)                │
    │                                                                                                            │
    │    Excess -------- 0 to 17 -------- 18+ years                                                              │
    │    1 – 7 days        10 kr.            20 kr.                                                              │
    │    8 – 14 days       30 kr.            60 kr.                                                              │
    │    15+ days          45 kr.            90 kr.                                                              │
    │                                                                                                            │
    │    The calculation is done using the following method:                                                     │
    │    *                                                                                                       │
    │    Return the fine according to the table above.                                                           │
    │    Pre: calculatedDate < actualDate                                                                        │
    │    (calculatedDate is the expected return date and                                                         │
    │    actualDate is the day you actually return the book)                                                     │
    │    *                                                                                                       │
    │    public int calculateFine(                                                                               │
    │            LocalDate calculatedDate,                                                                       │
    │            LocalDate actualDate,                                                                           │
    │            boolean adult)                                                                                  │
    │    Program the method and test it using JUnit. Use the test cases developed in SU                          │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    /**
     * Return the fine according to the table above.
     * Pre: calculatedDate < actualDate
     * (calculatedDate is the expected return date and
     * actualDate is the day you atually return the book)
     */
    public int calculateFine(LocalDate calculatedDate, LocalDate actualDate, boolean adult){
        if(calculatedDate.compareTo(actualDate) > 0){
            throw new RuntimeException("expected return date is greater than actual return date");
        }

        int fine = 0;

        if(calculatedDate.until(actualDate, ChronoUnit.DAYS) >= 15){
            if(!adult) { fine = 45; }
            else { fine = 90; }
        }
        else if(calculatedDate.until(actualDate, ChronoUnit.DAYS) >= 8){
            if(!adult) { fine = 30; }
            else { fine = 60; }
        }
        else if(calculatedDate.until(actualDate, ChronoUnit.DAYS) > 0){
            if(!adult) { fine = 10; }
            else { fine = 20; }
        }

        return fine;

    }


}
