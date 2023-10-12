package PRO.Lektion13_Test.Exercise2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFeeTest {

    @Test
    void childBracket1() {
        LibraryFee libFee = new LibraryFee();
        int actualResult;
        LocalDate dueDate;
        LocalDate actualDate;

        dueDate = LocalDate.of(2023, Month.AUGUST, 2);
        actualDate = LocalDate.of(2023, Month.AUGUST, 4);
        actualResult = libFee.calculateFine(dueDate, actualDate, false);

        assertEquals(10, actualResult);
    }
    @Test
    void childBracket2() {
        LibraryFee libFee = new LibraryFee();
        int actualResult;
        LocalDate dueDate;
        LocalDate actualDate;

        dueDate = LocalDate.of(2023, Month.AUGUST, 2);
        actualDate = LocalDate.of(2023, Month.AUGUST, 10);
        actualResult = libFee.calculateFine(dueDate, actualDate, false);

        assertEquals(30, actualResult);
    }
    @Test
    void childBracket3() {
        LibraryFee libFee = new LibraryFee();
        int actualResult;
        LocalDate dueDate;
        LocalDate actualDate;

        dueDate = LocalDate.of(2023, Month.AUGUST, 2);
        actualDate = LocalDate.of(2023, Month.AUGUST, 30);
        actualResult = libFee.calculateFine(dueDate, actualDate, false);

        assertEquals(45, actualResult);
    }

    @Test
    void adultBracket1() {
        LibraryFee libFee = new LibraryFee();
        int actualResult;
        LocalDate dueDate;
        LocalDate actualDate;

        dueDate = LocalDate.of(2023, Month.AUGUST, 2);
        actualDate = LocalDate.of(2023, Month.AUGUST, 4);
        actualResult = libFee.calculateFine(dueDate, actualDate, true);

        assertEquals(20, actualResult);
    }
    @Test
    void adultBracket2() {
        LibraryFee libFee = new LibraryFee();
        int actualResult;
        LocalDate dueDate;
        LocalDate actualDate;

        dueDate = LocalDate.of(2023, Month.AUGUST, 2);
        actualDate = LocalDate.of(2023, Month.AUGUST, 10);
        actualResult = libFee.calculateFine(dueDate, actualDate, true);

        assertEquals(60, actualResult);
    }
    @Test
    void adultBracket3() {
        LibraryFee libFee = new LibraryFee();
        int actualResult;
        LocalDate dueDate;
        LocalDate actualDate;

        dueDate = LocalDate.of(2023, Month.AUGUST, 2);
        actualDate = LocalDate.of(2023, Month.AUGUST, 30);
        actualResult = libFee.calculateFine(dueDate, actualDate, true);

        assertEquals(90, actualResult);
    }
}