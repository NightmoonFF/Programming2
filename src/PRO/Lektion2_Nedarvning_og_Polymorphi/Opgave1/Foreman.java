package PRO.Lektion2_Nedarvning_og_Polymorphi.Opgave1;

import java.time.Year;

public class Foreman extends Employee{

    Year promotionYear;
    double weeklyBonus;

    public Foreman(String name, String address, double hourlyWage, Year promotionYear, double weeklyBonus) {
        super(name, address, hourlyWage, 37);
        this.promotionYear = promotionYear;
        this.weeklyBonus = weeklyBonus;

    }

    @Override
    public double weeklySalary(){
        double total = 0;
        total = (37 * hourlyWage) + weeklyBonus;
        System.out.println("Foreman " + this.Name + " has earned: " + total);
        return total;
    }
}
