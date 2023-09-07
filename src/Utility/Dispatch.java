package Utility;

import java.util.ArrayList;
import java.util.Scanner;

public class Dispatch {
    static int tableSize;
    static NamedTask[] table;
    static Scanner scanner = new Scanner(System.in);


    /**
     * Execute with a prompt for index selection
     * @param dispatchTable
     */
    public static void start(ArrayList<NamedTask> dispatchTable) {
        table = new NamedTask[dispatchTable.size() + 1]; // convert to Array, and skip index 0
        tableSize = table.length;
        for (int i = 1; i <= tableSize - 1; i++) {
            table[i] = dispatchTable.get(i - 1);
        }
        userPrompt();
    }

    private static void userPrompt() {
        System.out.print(ConsoleStyling.color("-".repeat(50), ConsoleStyling.Color.WHITE, true));
        System.out.println();
        //TODO: Override feature (add optional parameter to go straight to an index)
        //TODO: Expand Runnable to allow saving the method name, then display them in a column with [index]-methodName()
        for (int i = 1; i < tableSize; i++) {
            System.out.println(
                    ConsoleStyling.color("[" + i + "] ", ConsoleStyling.Color.GREEN, true) +
                            ConsoleStyling.color(table[i].getTaskName(), ConsoleStyling.Color.WHITE, false)
            );
        }
        System.out.println();
        System.out.print("Choose an Exercise:  ");

        if (!scanner.hasNextInt() || scanner.nextInt() > table.length) {
            System.out.println();
            System.out.println(ConsoleStyling.color("Invalid Input!", ConsoleStyling.Color.ORANGE, true));
            exit();
        }
        int choice = scanner.nextInt();

        System.out.print(ConsoleStyling.color("-".repeat(50), ConsoleStyling.Color.WHITE, true));
        System.out.println();

        dispatchTableEntry(choice);
        promptContinue();
    }

    private static void promptContinue(){
        System.out.print("Do you want to continue (y/n)? ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("y")) {
            userPrompt();
        } else if (response.equalsIgnoreCase("n")) {
            userPrompt();
        } else {
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
            // Handle invalid input or provide further instructions.
        }
    }
    private static void exit(){
        System.out.println(ConsoleStyling.color("Terminating Application...", ConsoleStyling.Color.ORANGE, true));
        System.exit(0);
    }

    /**
     * Execute method based on the selected index
     * @param index
     */
    private static void dispatchTableEntry(int i) {
        if (i >= 0 && i < tableSize && table[i] != null) {
            table[i].run();
        } else {
            // Default
        }
    }

    /**
     * @return count of method entries in table
     */
    private static int countEntries() {
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null) {
                count++;
            }
        }
        return count;
    }
}
