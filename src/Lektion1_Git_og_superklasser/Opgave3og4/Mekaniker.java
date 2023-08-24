package Lektion1_Git_og_superklasser.Opgave3og4;

import java.time.Year;

public class Mekaniker extends Person {

    Year svendeprøveår;
    double timeløn;

    public Mekaniker(String navn, String addresse, Year svendeprøveår, double timeløn) {
        super(navn, addresse);
        this.svendeprøveår = svendeprøveår;
        this.timeløn = timeløn;
    }

    /**
     * calculates weekly salary for the employee.
     * All employees work 37 hours
     * @return The weekly salary for the employee
     */
    public double weeklySalary(){
        return 37 * timeløn;
    }

}
