package DAOS.Lektion17_MemoryManagement;

import Utility.Styling;

public class PopStack implements Runnable {

    final Stack stack;

    public PopStack(Stack stack) {

        this.stack = stack;
    }

    @Override
    public void run() {

        //wait for stack to not be empty
        while (true) {

            try {
                this.sleep(600);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            int i = stack.pop();
            System.out.println(Styling.txtOrange("Popping: " + i));

        }

    }

    private void sleep(int milli) {

        try {
            Thread.sleep(milli);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
