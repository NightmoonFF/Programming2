package Lektion1_Git_og_superklasser.Opgave3;

import java.time.Year;

public class Værkfører extends Mekaniker{

    Year udnævnelsesår;
    double ugetillæg;


    public Værkfører(String navn, String addresse, Year svendeprøveår, double timeløn, Year udnævnelsesår, double ugetillæg) {
        super(navn, addresse, svendeprøveår, timeløn);
        this.udnævnelsesår = udnævnelsesår;
        this.ugetillæg = ugetillæg;
    }

    @Override
    public double weeklySalary(){
        return (37 * timeløn) + ugetillæg;
    }
}
