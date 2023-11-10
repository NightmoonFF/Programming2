package DAOS.Lektion17_MemoryManagement;

public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack();

        PushStack pusher = new PushStack(stack);
        PopStack popper = new PopStack(stack);

        Thread pushThread = new Thread(pusher);
        Thread popThread = new Thread(popper);

        pushThread.start();
        popThread.start();

    }

}
