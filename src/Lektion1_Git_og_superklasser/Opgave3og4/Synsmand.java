package Lektion1_Git_og_superklasser.Opgave3og4;

import java.time.Year;

public class Synsmand extends Mekaniker{

    int antalSyn = 0;
    double synstillæg = 29;

    public Synsmand(String navn, String addresse, Year svendeprøveår, double timeløn) {
        super(navn, addresse, svendeprøveår, timeløn);
    }

    public void resetSyn(){
        this.antalSyn = 0;
    }

    public void tilføjSyn(int antal){
        this.antalSyn += antal;
    }

    @Override
    public double weeklySalary(){
        return (37 * timeløn) + (antalSyn * synstillæg);
    }

}
