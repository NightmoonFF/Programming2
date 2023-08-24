package Lektion2_Nedarvning_og_Polymorphi.Opgave1;

import java.time.Year;
import java.util.ArrayList;

public class Main {

    static ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {
        initTestData();
        System.out.println("Total weekly wages payed:");
        System.out.println(ANSI_BLUE + totalWeeklySalary() + ANSI_RESET);
    }

    public static final String ANSI_BLUE = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static double totalWeeklySalary(){
        double total = 0;
        for(Employee emp : employees){
            total += emp.weeklySalary();
        }

        return total;
    }

    public static void initTestData(){
        Mechanic mech1 = new Mechanic("Jens", "Bogbjergvej 22", 124.5, Year.of(2008));
        Mechanic mech2 = new Mechanic("Bo", "Nasserstræde 15", 122.3, Year.of(2002));
        Mechanic mech3 = new Mechanic("Hans", "Hurlumhejvej 42", 111.9, Year.of(2004));
        Mechanic mech4 = new Mechanic("Jesper", "Raballerstræde 124", 142.6, Year.of(2011));

        Foreman foreman1 = new Foreman("Johannes", "Bullerbyvej 51", 134, Year.of(2016), 514);
        Foreman foreman2 = new Foreman("Kasper", "Wallagade 51", 151, Year.of(2014), 621);

        Inspector inspector1 = new Inspector("Mathias", "Paradisgade 69", 137, Year.of(2007));
        inspector1.addInspection(6);

        WorkingBoy boy1 = new WorkingBoy("Jeppe", "fuglebakken 22", 94.2);
        WorkingBoy boy2 = new WorkingBoy("Jeppe", "Stavnsbjergvej 41", 91.5);

        employees.add(mech1);
        employees.add(mech2);
        employees.add(mech3);
        employees.add(mech4);
        employees.add(foreman1);
        employees.add(foreman2);
        employees.add(inspector1);
        employees.add(boy1);
        employees.add(boy2);
    }




}
