package DAOS.Lektion17_MemoryManagement;

import Utility.Styling;

public class PushStack implements Runnable {

    final Stack stack;

    public PushStack(Stack stack) {

        this.stack = stack;
    }

    @Override
    public void run() {

        for (int i = 0; i < 6; i++) {

            System.out.println(Styling.txtGreen("Pushing: " + i));

            stack.push(i);

            try {
                this.sleep(600);
            }
            catch (Exception e) {
                System.out.println("EXCEPTION");
            }
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
