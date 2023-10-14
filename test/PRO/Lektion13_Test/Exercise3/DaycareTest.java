package PRO.Lektion13_Test.Exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaycareTest {
    Daycare daycare = new Daycare();
    int actualResult;

    @Test
    void oneChild() {
        actualResult = daycare.totalPayment(1, 0);
        assertEquals(2000, actualResult);

        actualResult = daycare.totalPayment(0, 1);
        assertEquals(1000, actualResult);
    }

    @Test
    void twoChildren() {
        actualResult = daycare.totalPayment(1, 1);
        assertEquals(2750, actualResult);

        actualResult = daycare.totalPayment(2, 0);
        assertEquals(3500, actualResult);

        actualResult = daycare.totalPayment(0, 2);
        assertEquals(1750, actualResult);
    }

    @Test
    void threeChildren() {

        // 2000 + ( (2000 * 1 + 1000 * 1) - 25%)
        actualResult = daycare.totalPayment(2, 1);
        assertEquals(4250, actualResult);

        // 2000 + ( (2000 * 0 + 1000 * 2) - 25%)
        actualResult = daycare.totalPayment(1, 2);
        assertEquals(3500, actualResult);

        // 2000 + ( (2000 * 2 + 1000 * 0) - 25%)
        actualResult = daycare.totalPayment(3, 0);
        assertEquals(5000, actualResult);

        // 1000 + ( (2000 * 0 + 1000 * 2) - 25%)
        actualResult = daycare.totalPayment(0, 3);
        assertEquals(2500, actualResult);

    }

    @Test
    void fourChildren() {

        // 2000 + (2000-25%) + (1000-25%) + (1000-50%)
        actualResult = daycare.totalPayment(2, 2);
        assertEquals(4750, actualResult);

        // 2000 + (1000-25%) + (1000-25%) + (1000-50%)
        actualResult = daycare.totalPayment(1, 3);
        assertEquals(4000, actualResult);

        // 2000 + (2000-25%) + (2000-25%) + (1000-50%)
        actualResult = daycare.totalPayment(3, 1);
        assertEquals(5500, actualResult);

        // 2000 + (2000-25%) + (2000-25%) + (2000-50%)
        actualResult = daycare.totalPayment(4, 0);
        assertEquals(6000, actualResult);

        // 1000 + (1000-25%) + (1000-25%) + (1000-50%)
        actualResult = daycare.totalPayment(0, 4);
        assertEquals(3000, actualResult);

    }

    @Test
    void tenChildren() {

        // 2000 + (2000-25%) + (2000-25%) + (  (2000-50%)*2 )  + ( (1000-50%) * 5) )
        actualResult = daycare.totalPayment(5, 5);
        assertEquals(9500, actualResult);

        // 2000 + (2000-25%) + (2000-25%) + (  (2000-50%)*7 )  + ( (1000-50%) * 0) )
        actualResult = daycare.totalPayment(10, 0);
        assertEquals(12000, actualResult);

        // 2000 + (2000-25%) + (2000-25%) + (  (2000-50%)*7 )  + ( (1000-50%) * 0) )
        actualResult = daycare.totalPayment(0, 10);
        assertEquals(6000, actualResult);

    }

    @Test
    void noChildren(){
        assertThrows(RuntimeException.class, ()->{
            daycare.totalPayment(0, 0);
        });

        assertThrows(RuntimeException.class, ()->{
            daycare.totalPayment(-2, 5);
        });
    }
}