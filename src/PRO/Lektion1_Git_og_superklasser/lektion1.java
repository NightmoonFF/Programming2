package PRO.Lektion1_Git_og_superklasser;

import PRO.Lektion1_Git_og_superklasser.Opgave3og4.Mekaniker;
import PRO.Lektion1_Git_og_superklasser.Opgave3og4.Synsmand;
import PRO.Lektion1_Git_og_superklasser.Opgave3og4.Værkfører;

import java.time.Year;
import java.util.ArrayList;

public class lektion1 {

    static ArrayList<Mekaniker> mekanikere = new ArrayList<>();
    public static void main(String[] args) {

        Mekaniker mekaniker1 = new Mekaniker("Jens", "Bogbjergvej 22", Year.of(2008), 124.5);
        Mekaniker mekaniker2 = new Mekaniker("Bo", "Nasserstræde 15", Year.of(2002), 122.3);
        Mekaniker mekaniker3 = new Mekaniker("Hans", "Hurlumhejvej 42", Year.of(2004), 111.9);
        Mekaniker mekaniker4 = new Mekaniker("Jesper", "Raballerstræde 124", Year.of(2011), 142.6);

        Værkfører værkfører1 = new Værkfører("Johannes", "Bullerbyvej 51", Year.of(2014), 138, Year.of(2016), 514);
        Værkfører værkfører2 = new Værkfører("Kasper", "Wallagade 51", Year.of(2009), 151, Year.of(2014), 621);

        Synsmand synsmand1 = new Synsmand("Mathias", "Paradisgade 69", Year.of(2007), 137);
        synsmand1.tilføjSyn(6);

        mekanikere.add(mekaniker1);
        mekanikere.add(mekaniker2);
        mekanikere.add(mekaniker3);
        mekanikere.add(mekaniker4);
        mekanikere.add(værkfører1);
        mekanikere.add(værkfører2);
        mekanikere.add(synsmand1);

        //Opgave 4.a
        System.out.println("opgave 4.a  - " + mekaniker1.weeklySalary());

        //Opgave 4.b,c,d,e
        System.out.println("opgave 4.b+ - " + totalWeeklySalary());

    }

    public static double totalWeeklySalary(){
        double total = 0;
        for(Mekaniker mek : mekanikere){
            total += mek.weeklySalary();
        }

        return total;
    }





}
