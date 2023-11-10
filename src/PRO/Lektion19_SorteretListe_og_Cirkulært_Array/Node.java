package PRO.Lektion19_SorteretListe_og_Cirkulært_Array;

public class Node<T> {

    private final T element;
    private final Node<T> next;
    private final Node<T> prev;

    public Node(T t) {

        this.element = t;
        this.next = null;
        this.prev = null;
    }

}
