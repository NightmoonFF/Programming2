package PRO.Lektion12_ObserverPattern.Exercise2;

public class Exercise2 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    I denne opgave skal du implementerer en ObservableBag. En bag minder om et set, men med                 │
    │    den forskel, at det er tilladt at have dubletter. For hvert element der tilføjes bag’en, skal der       │
    │    derfor holdes styr på hvor mange gange elementet forekommer i bag’en.                                  │
    │    Du skal anvende et observer pattern til at gøre det muligt at observere på når der tilføjes og        │
    │    fjernes elementer fra bag’en. I denne variant af observer pattern skal Observer både have at           │
    │    vide hvilket element der tilføjes / fjernes, og dets aktuelle antal i ObservableBag efter               │
    │    operationen er udført. Observeren skal blot printe oplysningerne.                                       │
    │    Implementationen skal være baseret på et HashMap, og adaptes til følgende interface (adapter           │
    │    pattern):                                                                                               │
    │    public interface Bag {                                                                                  │
    │    ** Add the string to the bag *                                                                          │
    │    public void add(String s);                                                                              │
    │    ** Remove the string s from the bag (if it is the bag). *                                               │
    │    public void remove(String s);                                                                           │
    │    ** Get the count of the string s in the bag. *                                                          │
    │    public int getCount(String s);                                                                          │
    │    }                                                                                                       │
    │    Lav det der skal til, så din nye ObservableBag kan anvendes i et for-each loop. Elementer, der         │
    │    er tilføjet flere gange til ObservableBag, skal kun optræde é n gang i gennemløbet (antal              │
    │    kommer ikke med i gennemløbet).                                                                         │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {

        ObservableBag observableBag = new MyBag();
        Observer observer = new BagObserver();
        observableBag.addObserver(observer);

        observableBag.addElement("Kopitaske");
        observableBag.addElement("Grillpølse");
        observableBag.addElement("Belvedere");
        observableBag.addElement("Grillpølse");
        observableBag.addElement("Narko");
        observableBag.addElement("Grillpølse");
        observableBag.removeElement("Grillpølse");

        System.out.println("--".repeat(50));

        observableBag.getCount();
    }

}
