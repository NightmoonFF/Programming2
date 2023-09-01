package Lektion3_Interfaces.Opgave1;

public class Beer implements Measurable{

    String name;
    double alcoholPercent;

    public Beer(String name, double alcoholPercent) {
        this.name = name;
        this.alcoholPercent = alcoholPercent;
    }

    @Override
    public double getMeasure(){
        return alcoholPercent;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlcoholPercent() {
        return alcoholPercent;
    }

    public void setAlcoholPercent(double alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }
}
