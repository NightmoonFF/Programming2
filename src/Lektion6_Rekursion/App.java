package Lektion6_Rekursion;

import java.util.Scanner;

public class App {
    static Assignments a = new Assignments();
    public static void main(String[] args) {
        dispatchTable();
        userPrompt();
    }

    private static void userPrompt(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Select an assignment to print (index)");
        System.out.print("Enter your choice: ");

        if(!scanner.hasNextInt()){
            System.out.println("Invalid Input");
            return;
        }
        choice = scanner.nextInt();



        userPrompt();
    }


    final int maxCaseAmount = 10;
    Runnable[] table = new Runnable[maxCaseAmount];
    private static void dispatchTable(){


    }

}
