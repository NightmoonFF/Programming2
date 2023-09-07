package Utility;

import java.util.ArrayList;
import java.util.Scanner;

public class Dispatch {
    static int tableSize;
    static Runnable[] table;
    static Scanner scanner = new Scanner(System.in);

    public static void start(ArrayList<Runnable> dispatchTable) {

        // convert to Array, and skip index 0
        table = new Runnable[dispatchTable.size() + 1];

        tableSize = table.length;
        for (int i = 1; i <= tableSize - 1; i++) {
            table[i] = dispatchTable.get(i - 1);
        }

        userPrompt();
    }

    private static void userPrompt(){
        System.out.print(ConsoleStyling.color("-".repeat(50), ConsoleStyling.Color.WHITE, true));
        System.out.println();
        //TODO: Expand Runnable to allow saving the method name, then display them in a column with [index]-methodName()
        for(int i = 1; i < tableSize; i++){
            System.out.printf("%6s", i);
        }
        System.out.println();
        System.out.print("Choose an Exercise:  ");

        if(!scanner.hasNextInt()){
            System.out.println();
            System.out.println(ConsoleStyling.color("Invalid Input!", ConsoleStyling.Color.ORANGE, true));
            System.out.println(ConsoleStyling.color("Terminating Application...", ConsoleStyling.Color.ORANGE, true));
            userPrompt();
        }
        int choice = scanner.nextInt();
        System.out.print(ConsoleStyling.color("-".repeat(50), ConsoleStyling.Color.WHITE, true));
        System.out.println()
        ;
        dispatchEntry(choice); //-1 since arrays start at 0

        userPrompt();
    }

    private static void dispatchEntry(int index){

        int i = index; //to avoid the empty [0] index

        // Perform the action based on the selected case
        if (i >= 0 && i < tableSize && table[i] != null) {
            table[i].run();
        } else {
            // Default
        }
    }

    /**
     * @return count of entries in: Runnable[] dispatchTable
     */
    private static int countEntries(){
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null) {
                count++;
            }
        }
        return count;
    }


}
