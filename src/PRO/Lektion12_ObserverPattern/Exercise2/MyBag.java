package PRO.Lektion12_ObserverPattern.Exercise2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyBag implements ObservableBag {

    private final Map<String, Integer> elements;

    private final Set<Observer> observers;

    public MyBag() {

        elements = new HashMap<>();
        observers = new HashSet<>();
    }

    @Override
    public void addObserver(Observer observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        observers.remove(observer);
    }

    @Override
    public void addElement(String element) {

        elements.put(element, elements.getOrDefault(element, 0) + 1);
        notifyObservers(element, elements.get(element));
    }

    @Override
    public void removeElement(String element) {

        if (elements.containsKey(element)) {
            int count = elements.get(element);
            if (count > 1) {
                elements.put(element, count - 1);
            }
            else {
                elements.remove(element);
            }
            notifyObservers(element, count - 1);
        }
    }

    @Override
    public void getCount() {

        for (Map.Entry<String, Integer> entry : elements.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private void notifyObservers(String element, int count) {

        for (Observer observer : observers) {
            observer.update(element, count);
        }
    }

}
