package PRO.Lektion1_Git_og_superklasser.Opgave5;

public class Car extends Vehicle{

    int numDoors;

    public Car(String make, String model, int year, double mileage, int numDoors) {
        super(make, model, year, mileage);
        this.numDoors = numDoors;
    }
}
