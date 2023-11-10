package PRO.Lektion19_SorteretListe_og_Cirkulært_Array;

public interface SortedList23y<E> {

    /**
     * Add the element to the list.
     * The list is still sorted after the element is added.
     */
    void add(E element);

    /**
     * Remove the first element in the list.
     * The list is still sorted after the element is removed.
     *
     * @return true, if the element was removed
     */
    boolean removeFirst();

    /**
     * Remove the last element in the list.
     * The list is still sorted after the element is removed.
     *
     * @return true, if the element was removed
     */
    boolean removeLast();

    /**
     * Remove the first instance of the element in the list.
     * The list is still sorted after the element is removed.
     *
     * @return true, if the element was removed
     */
    boolean remove(E element);

    /**
     * @return the number of elements in the list
     */
    int size();

}
