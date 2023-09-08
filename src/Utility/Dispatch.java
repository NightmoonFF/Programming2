package Utility;

import java.util.ArrayList;
import java.util.Scanner;

public class Dispatch {
    static int tableSize;
    static NamedTask[] table;
    static Scanner scanner = new Scanner(System.in);

    /**
     * Converts the taskList from getPrintable into an array,
     * and starts the terminal process requesting an index of which one
     * @param taskList
     */
    public static void start(ArrayList<NamedTask> taskList) {
        table = new NamedTask[taskList.size() + 1]; // convert to Array, and skip index 0
        tableSize = table.length;
        for (int i = 1; i <= tableSize - 1; i++) {
            table[i] = taskList.get(i - 1);
        }
        userPrompt();
    }

    /**
     * Converts the taskList from getPrrintable into an array,
     * and executes the one specified by the index parameter
     * @param taskList
     * @param index the method to execute
     */
    public static void start(ArrayList<NamedTask> taskList, int index) {
        table = new NamedTask[taskList.size() + 1]; // convert to Array, and skip index 0
        tableSize = table.length;
        for (int i = 1; i <= tableSize - 1; i++) {
            table[i] = taskList.get(i - 1);
        }
        dispatchTableEntry(index);
    }

    /**
     * Asks user which of the indexed methods
     * they want to execute
     */
    private static void userPrompt() {
        System.out.print(ConsoleStyling.color("-".repeat(50), ConsoleStyling.Color.WHITE, true));
        System.out.println();
        for (int i = 1; i < tableSize; i++) {
            System.out.println(
                    ConsoleStyling.color("[" + i + "] ", ConsoleStyling.Color.GREEN, true) +
                            ConsoleStyling.color(table[i].getTaskName(), ConsoleStyling.Color.WHITE, false)
            );
        }

        while (true){
            System.out.println();
            System.out.print("Choose what to run:  ");
            int choice = 0;
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                if(choice > 0 && choice <= table.length - 1){
                    // Valid index
                    dispatchTableEntry(choice);
                    System.out.print(ConsoleStyling.color("-".repeat(50), ConsoleStyling.Color.WHITE, true));
                    System.out.println();
                    promptContinue();
                    break;
                }
                else{
                    // Invalid if index out of bounds
                    System.out.println();
                    System.out.println(ConsoleStyling.color("Invalid Input!", ConsoleStyling.Color.ORANGE, true));
                    scanner.next();
                }
            }
            else{
                // Invalid if not an integer
                System.out.println();
                System.out.println(ConsoleStyling.color("Invalid Input!", ConsoleStyling.Color.ORANGE, true));
                scanner.next();
            }
        }
    }

    /**
     * Asks user if they want to execute another method,
     * or exit the application
     */
    private static void promptContinue(){
        System.out.println("Do you want to continue (y/n)? ");
        while (true){
            if(scanner.hasNext()){
                String response = scanner.next();
                if (response.equalsIgnoreCase("y")) {
                    userPrompt();
                    break;
                } else if (response.equalsIgnoreCase("n")) {
                    exit();
                }
                else{
                    // Invaild input
                    System.out.println();
                    System.out.println(ConsoleStyling.color("Invalid Input!", ConsoleStyling.Color.ORANGE, true));
                    scanner.next();
                }
            }
        }
    }

    /**
     * Exits the Application
     */
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
        // idk what to use this for kek
        int count = 0;
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null) {
                count++;
            }
        }
        return count;
    }
}
