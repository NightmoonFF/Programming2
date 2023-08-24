package Lektion2_Nedarvning_og_Polymorphi.Opgave1;

public abstract class Employee {
    String Name;
    String address;
    double hourlyWage;
    int hoursPerWeek;

    public Employee(String Name, String address, double hourlyWage, int hoursPerWeek) {
        this.Name = Name;
        this.address = address;
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }


    /**
     * calculates weekly salary for the employee.
     * All employees work 37 hours
     * @return The weekly salary for the employee
     */
    public double weeklySalary(){
        double total = 0;
        total = hoursPerWeek * hourlyWage;
        System.out.println(this.getClass().getSimpleName() + " " + this.Name + " has earned: " + total);
        return total;
    }

}
