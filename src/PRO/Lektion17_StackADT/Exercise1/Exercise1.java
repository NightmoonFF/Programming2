package PRO.Lektion17_StackADT.Exercise1;
public class Exercise1{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    In the file stack23Ystudent.zip you can find the interface Stack23Y, as well as the beginning           │
    │    of the 3 implementations LinkedStack23Y, ArrayStack23Y and DequeStack23Y.                               │
    │    Finish the 3 implementations.                                                                           │
    │    Test your implementations                                                                               │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print(){

//        Stack23Y<String> stack = new ArrayStack23Y<>();
        Stack23Y<String> stack = new LinkedStack23Y<>();
//        Stack23Y<String> stack = new DequeStack23Y<>();

        stack.push("Tom");
        stack.push("Diana");
        stack.push("Harry");
        stack.push("Thomas");
        stack.push("Bob");
        stack.push("Brian");
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty() + " " + stack.size());
        System.out.println();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println();

        System.out.println(stack.isEmpty() + " " + stack.size());
        System.out.println();

        // -------- test of reverse --------

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverse(numbers);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    /** Reverse the table. */
    public static <E> void reverse(E[] table) {
        // Stack23Y<E> stack = new ArrayStack23Y<E>();
        // Stack23Y<E> stack = new LinkedStack23Y<E>();
        Stack23Y<E> stack = new DequeStack23Y<>();
        for (E e : table) {
            stack.push(e);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            table[i] = stack.pop();
            i++;
        }
    }

}

