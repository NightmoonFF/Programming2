package Lektion5_Rekursion;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(35) + 2;
        System.out.println("Factorial of " + randomNumber + ":");

        int result = Excersises.factorial(randomNumber);

        System.out.println(result);
    }
}
