package PRO.Lektion12_ObserverPattern.Exercise2;

public class BagObserver implements Observer {


    @Override
    public void update(String element, int count) {

        System.out.println("Element: " + element + ", " + "Count: " + count);
    }

}
