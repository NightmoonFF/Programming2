package DAOS.Lektion17_MemoryManagement;

public class Stack {

    private Element first;

    public Stack() {

        first = null;
    }

    synchronized void push(int n) {

        first = new Element(n, first);
        if (!is_empty()) { notifyAll(); }
    }

    synchronized int pop() {

        if (first == null) {
            System.out.println("Stacken er tom");
        }

        try {
            wait();
            int n = first.info;
            first = first.next;
            return n;
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        int n = first.info;
        first = first.next;
        return n;
    }

    public boolean is_empty() {

        return first == null;

    }

    private class Element {

        int info;
        Element next;

        Element(int n, Element e) {

            info = n;
            next = e;
        }

    }

}
