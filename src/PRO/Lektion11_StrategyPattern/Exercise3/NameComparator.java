package PRO.Lektion11_StrategyPattern.Exercise3;

import java.util.Comparator;

public class NameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {

        return o1.getName().compareTo(o2.getName());
    }

}
