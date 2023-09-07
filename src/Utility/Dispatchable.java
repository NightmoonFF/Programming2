package Utility;

import java.util.ArrayList;
import java.util.List;

public interface Dispatchable extends Printable {

    default void dispatch() {
        Dispatch.start(getPrintable());
    }
    default void dispatch(int i){

    }
}
