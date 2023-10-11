package PRO.Lektion2_Nedarvning_og_Polymorphi.Opgave1;

import java.time.Year;

public class Mechanic extends Employee {

    Year graduationYear;

    public Mechanic(String name, String address, double hourlyWage, Year graduationYear) {
        super(name, address, hourlyWage, 37);
        this.graduationYear = graduationYear;
    }

}
