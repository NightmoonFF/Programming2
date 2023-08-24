package Lektion2_Nedarvning_og_Polymorphi.Opgave1;

import java.time.Year;

public class Inspector extends Mechanic {

    int inspections = 0;
    double inspectionWageBonus = 29;

    public Inspector(String name, String address, double hourlyWage, Year graduationYear) {
        super(name, address, hourlyWage, graduationYear);
    }

    public void resetInspections(){
        this.inspections = 0;
    }

    public void addInspection(int antal){
        this.inspections += antal;
    }

    @Override
    public double weeklySalary(){
        double total = 0;
        total = (37 * hourlyWage) + (inspections * inspectionWageBonus);
        System.out.println("Inspector " + this.Name + " has earned: " + total);
        return total;
    }

}
