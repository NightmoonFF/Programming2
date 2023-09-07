package Utility;

import java.util.ArrayList;
import java.util.Scanner;

public class DispatchExercises {
    int tableSize;
    Runnable[] dispatchTable;
    Scanner scanner = new Scanner(System.in);

    public DispatchExercises(ArrayList<Runnable> dispatchTable) {
        this.tableSize = dispatchTable.size();
        this.dispatchTable = dispatchTable.toArray(new Runnable[tableSize]);
        userPrompt();
    }

    private void userPrompt(){
        System.out.println("Choose an Exercise:");

        for(int i = 1; i < tableSize; i++){
            System.out.printf("%6s", i);
        }

        if(!scanner.hasNextInt()){
            System.out.print("-".repeat(20));
            System.out.println();
            System.out.println(ConsoleStyling.color("Invalid Input", ConsoleStyling.Color.ORANGE, true));
            userPrompt();
        }
        int choice = scanner.nextInt();

        dispatchExercise(choice);

        userPrompt();
    }

    private void dispatchExercise(int index){
        // Perform the action based on the selected case
        if (index >= 0 && index < tableSize && dispatchTable[index] != null) {
            dispatchTable[index].run();
        } else {
            // Default
        }
    }

    /**
     * @return count of entries in: Runnable[] dispatchTable
     */
    private int countDispatchEntries(){
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if (dispatchTable[i] != null) {
                count++;
            }
        }
        return count;
    }


}
