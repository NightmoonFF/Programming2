package PRO.Lektion13_Test.Exercise2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryFee {

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
