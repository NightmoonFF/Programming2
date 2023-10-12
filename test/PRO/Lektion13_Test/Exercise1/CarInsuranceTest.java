package PRO.Lektion13_Test.Exercise1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class CarInsuranceTest {

    private CarInsurance carInsurance;
    private double actualValue;

    @BeforeEach
    public void setUp(){
        //Arrange is done here in this case, instead of in each method
        actualValue = 0;
        carInsurance = new CarInsurance(2400);
    }

    @DisplayName("[TC_01, TC_05]")
    @Order(1)
    @Test
    void ageTests() {

        actualValue = carInsurance.calculatePremium(18, false, 0);
        assertEquals(3000, actualValue);

        actualValue = carInsurance.calculatePremium(20, false, 0);
        assertEquals(3000, actualValue);

        actualValue = carInsurance.calculatePremium(24, false, 0);
        assertEquals(3000, actualValue);

        actualValue = carInsurance.calculatePremium(25, false, 0);
        assertEquals(2400, actualValue);

        actualValue = carInsurance.calculatePremium(78, false, 0);
        assertEquals(2400, actualValue);
    }

    @DisplayName("[TC_06, TC_07]")
    @Order(2)
    @Test
    void genderTests(){

        actualValue = carInsurance.calculatePremium(27, true, 0);
        assertEquals(2280, actualValue);

        actualValue = carInsurance.calculatePremium(22, true, 0);
        assertEquals(2850, actualValue);
    }

    @DisplayName("[TC_08, TC_18]")
    @Order(3)
    @Test
    void damageTests(){
        // No reduction
        actualValue = carInsurance.calculatePremium(30, false, 0);
        assertEquals(2400, actualValue);
        actualValue = carInsurance.calculatePremium(30, false, 1);
        assertEquals(2400, actualValue);
        actualValue = carInsurance.calculatePremium(30, false, 2);
        assertEquals(2400, actualValue);

        // 15% reduction
        actualValue = carInsurance.calculatePremium(30, false, 3);
        assertEquals(2040, actualValue);
        actualValue = carInsurance.calculatePremium(30, false, 4);
        assertEquals(2040, actualValue);
        actualValue = carInsurance.calculatePremium(30, false, 5);
        assertEquals(2040, actualValue);

        // 25% reduction
        actualValue = carInsurance.calculatePremium(30, false, 6);
        assertEquals(1800, actualValue);
        actualValue = carInsurance.calculatePremium(30, false, 7);
        assertEquals(1800, actualValue);
        actualValue = carInsurance.calculatePremium(30, false, 8);
        assertEquals(1800, actualValue);

        // 35% reduction
        actualValue = carInsurance.calculatePremium(30, false, 9);
        assertEquals(1560, actualValue);
        actualValue = carInsurance.calculatePremium(30, false, 11);
        assertEquals(1560, actualValue);

    }

    @DisplayName("[TC_19, TC_21]")
    @Order(4)
    @Test
    void exceptionTests(){

        assertThrows(RuntimeException.class, ()->{
            carInsurance.calculatePremium(28, false, -1);
        });

        assertThrows(RuntimeException.class, ()->{
            carInsurance.calculatePremium(-1, false, 0);
        });

        assertThrows(RuntimeException.class, ()->{
            carInsurance.calculatePremium(14, false, 0);
        });


    }

}