package PRO.Lektion8_Generics.Exercise3;

public class ArrayBag<E> implements Bag<E> {

    // the array to hold the items
    private final E[] items;

    // current number of items in the bag,
    // items are at index 0..size-1
    //TODO: //NOTE: i had to change this to not be final. Intended?
    private int size;

    /**
     * Create a bag with the given capacity.
     */
    public ArrayBag(int capacity) {

        @SuppressWarnings("unchecked") E[] empty = (E[]) new Object[capacity];
        items = empty;
        size = 0;
    }

    /**
     * Create a bag with capacity 10.
     */
    public ArrayBag() {

        this(10);
    }

    @Override
    public int getCurrentSize() {

        return size;
    }

    @Override
    public boolean isFull() {

        return size == items.length;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public boolean add(E newEntry) {

        if (size < items.length) {
            items[size] = newEntry;
            size++;
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public E remove() {

        if (size > 0) {
            items[size] = null;
            size--;
        }
        return items[size];
    }

    @Override
    public boolean remove(E anEntry) {

        for (int i = 0; i < items.length; i++) {
            if (items[i] == anEntry) {
                items[i] = null;
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {

        for (int i = 0; i < items.length; i++) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(E anEntry) {

        int frequency = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == anEntry) { frequency++; }
        }
        return frequency;
    }

    @Override
    public boolean contains(E anEntry) {

        for (int i = 0; i < items.length; i++) {
            if (items[i] == anEntry) { return true; }
        }

        return false;
    }

    @Override
    public E[] toArray() {

        E[] newArray = (E[]) new Object[items.length];
        System.arraycopy(items, 0, newArray, 0, items.length);

        return newArray;
    }

}
