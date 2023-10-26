package PRO.Lektion7_Del_Los_Kombiner.Exercise4;

import hu.webarticum.treeprinter.SimpleTreeNode;
import hu.webarticum.treeprinter.decorator.BorderTreeNodeDecorator;
import hu.webarticum.treeprinter.printer.traditional.TraditionalTreePrinter;

public class Exercise4 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 4                                                                                              │
    │                                                                                                            │
    │    a) Draw the recursion tree for merge sort used on:                                                      │
    │            [13, 7, 48, 17, 24, 8, 5, 33]                                                                   │
    │    b) Draw the recursion tree for quicksort used on:                                                       │
    │             [13, 7, 48, 17, 24, 8, 5, 33]                                                                  │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {
        System.out.println("\nExercise A:\n");
        printA();
        System.out.println("\nExercise B:\n");
        printB();
    }


    private static void printB() {
        // level 1 (root)
        SimpleTreeNode rootNode = new SimpleTreeNode("13, 7, 48, 18, 24, 8, 5, 33");

        // level 2
        SimpleTreeNode t1 = new SimpleTreeNode("7, 8, 5");
        rootNode.addChild(t1);
        SimpleTreeNode t2 = new SimpleTreeNode("13");
        rootNode.addChild(t2);
        SimpleTreeNode t3 = new SimpleTreeNode("48, 17, 24, 33");
        rootNode.addChild(t3);
        // level 3
        SimpleTreeNode t1a = new SimpleTreeNode("5");
        t1.addChild(t1a);
        SimpleTreeNode t1b = new SimpleTreeNode("7");
        t1.addChild(t1b);
        SimpleTreeNode t1c = new SimpleTreeNode("8");
        t1.addChild(t1c);

        SimpleTreeNode t3a = new SimpleTreeNode("17");
        t3.addChild(t3a);
        SimpleTreeNode t3b = new SimpleTreeNode("24, 33");
        t3.addChild(t3b);
        SimpleTreeNode t3c = new SimpleTreeNode("48");
        t3.addChild(t3c);

        new TraditionalTreePrinter().print(new BorderTreeNodeDecorator(rootNode));
    }

    private static void printA() {
        System.out.print(printTab(5) + "[13, 7, 48, 17, 24, 8, 5, 33]");
        System.out.print("\n" + printTab(8) + "|");
        System.out.print("\n\t\t\t" + "-".repeat(40));
        System.out.print("\n\t\t\t|" + printTab(10) + "|");
        System.out.print("\n\t\t[13, 7, 48, 17]");
        System.out.print(printTab(7) + "[24, 8, 5, 33]");
        System.out.print("\n\t\t\t|" + printTab(10) + "|");
        System.out.print("\n\t" + "-".repeat(20) + printTab(5) + "-".repeat(20));
        System.out.print("\n\t|" + printTab(5) + "|" + printTab(5) + "|" + printTab(5) + "|");
        System.out.print(
                "\n" + "[13, 7]" + printTab(4) + "[48, 17]" + printTab(3) + "[24, 8]" + printTab(4)
                        + "[5, 33]");
        System.out.print("\n\t|" + printTab(5) + "|" + printTab(5) + "|" + printTab(5) + "|");
        System.out.print(
                "\n" + "-".repeat(10) + printTab(3) + "-".repeat(10) + printTab(3) + "-".repeat(10)
                        + printTab(3) + "-".repeat(10));
        System.out.print("\n|\t\t |\t\t\t|\t\t |" + "\t\t\t" + "|\t\t |\t\t\t|\t\t |");
        System.out.print("\n[13]\t[7]\t\t\t[48]\t[17]\t\t[24]\t[8]\t\t\t[5]\t\t[33]" + "\tMERGE⮟");
        System.out.print("\n|\t\t |\t\t\t|\t\t |" + "\t\t\t" + "|\t\t |\t\t\t|\t\t |");
        System.out.print(
                "\n" + "-".repeat(10) + printTab(3) + "-".repeat(10) + printTab(3) + "-".repeat(10)
                        + printTab(3) + "-".repeat(10));
        System.out.print("\n\t|" + printTab(5) + "|" + printTab(5) + "|" + printTab(5) + "|");
        System.out.print(
                "\n" + "[7, 13]" + printTab(4) + "[17, 48]" + printTab(3) + "[8, 24]" + printTab(4)
                        + "[5, 33]");
        System.out.print("\n\t|" + printTab(5) + "|" + printTab(5) + "|" + printTab(5) + "|");
        System.out.print("\n\t" + "-".repeat(20) + printTab(5) + "-".repeat(20));
        System.out.print("\n\t\t" + "[7, 13, 17, 48]" + printTab(7));
        System.out.print("[5, 8, 24, 33]");
        System.out.print("\n\t\t\t|" + printTab(10) + "|");
        System.out.print("\n\t\t\t" + "-".repeat(40));
        System.out.print("\n" + printTab(8) + "|");
        System.out.print("\n" + printTab(5) + "[5, 7, 8, 13, 17, 24, 33, 48]\n\n");
    }

    private static String printTab(int repeat) {
        return "\t".repeat(repeat);
    }
}
