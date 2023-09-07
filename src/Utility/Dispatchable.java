package Utility;

import java.util.ArrayList;

public interface Dispatchable extends Printable {

    default void dispatch() {
        ArrayList<Runnable> printableList = getPrintable();
    }
}
