package PRO.Lektion11_StrategyPattern.Exercise3;

import java.util.Comparator;

public class NumberComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {

        return Integer.compare(o1.getNumber(), o2.getNumber());
    }

}
