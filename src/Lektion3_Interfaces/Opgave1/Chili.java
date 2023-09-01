package Lektion3_Interfaces.Opgave1;

public class Chili implements Measurable{
    String name;
    double scoville;

    public Chili(String name, int scoville) {
        this.name = name;
        this.scoville = scoville;
    }

    @Override
    public double getMeasure(){
        return scoville;
    }

    @Override
    public String getName(){
        return this.name;
    }

    //region Get & Set
    public void setName(String name) {
        this.name = name;
    }
    public double getScoville() {
        return scoville;
    }
    public void setScoville(double scoville) {
        this.scoville = scoville;
    }
    //endregion
}
