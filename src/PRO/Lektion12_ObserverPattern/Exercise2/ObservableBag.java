package PRO.Lektion12_ObserverPattern.Exercise2;

public interface ObservableBag {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void addElement(String element);

    void removeElement(String element);

    void getCount();

}
