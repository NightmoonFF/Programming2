package Utility;

import java.util.ArrayList;
import java.util.List;

public interface Dispatchable extends Printable {

    /**
     * Fetches all methods in the class, where name starts
     * with "print", and lists them in the terminal. Then
     * asks user for an index of which one they would like
     * to execute
     */
    default void dispatch() {
        Dispatch.start(getPrintable());
    }

    /**
     * Fetches all methods in the class, where name starts
     * with "print", and executes the one with matching
     * index of the parameter. The methods --SHOULD-- be fetched
     * in the order, of the order that they appear in the class
     * @param i - Index of the method to run
     */
    default void dispatch(int i){
        Dispatch.start(getPrintable(), i);
    }
}
