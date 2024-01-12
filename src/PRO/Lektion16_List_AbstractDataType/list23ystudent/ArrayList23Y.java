package PRO.Lektion16_List_AbstractDataType.list23ystudent;

import java.util.Arrays;
import java.util.Iterator;

/**
 * An array based implementation of the List ADT.
 */
public class ArrayList23Y<E> implements List23Y<E> {

    @SuppressWarnings("unchecked")
    private E[] data = (E[]) new Object[4];
    private int size = 0;
    // data contains elements at index 0..size-1 and null else

    /**
     * Add the element to the end of this list.
     */
    @Override
    public void add(E e) {

        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size] = e;
        size++;
    }

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    @Override
    public boolean remove(E e) {

        for (int i = 0; i < data.length; i++) {

        }
        //make array 1 shorter
        data = Arrays.copyOf(data, data.length - 1);

        //return true if element was removed and data was changed, otherwise false
        return false;
    }

    /**
     * Return true, if this list contains the element.
     */
    @Override
    public boolean contains(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove all elements from this list.
     */
    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Return the size of this list.
     */
    @Override
    public int size() {

        return size;
    }

    /**
     * Return true, if this list is empty.
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E get(int index) {

        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("index cannot be less than zero, or greater than or equal to size");
        }
        return data[index];
    }

    /**
     * Add the element to this list at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index > size().
     * Note: The element can be added at an index equal to size().
     */
    @Override
    public void add(int index, E e) {

        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("index cannot be less than zero, or greater than size");
        }

        if (index == size) { this.add(e); }
        else {
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[data.length + 1];
            for (int i = 0; i < temp.length; i++) {

                //Assign same index for those below new element's index
                if (i < index) {
                    temp[i] = data[i];
                }
                //Assign index of new element with the element
                else if (i == index) {
                    temp[i] = e;
                }
                //Else assign sama data for the remaining entries in original array
                else {
                    temp[i] = data[i - 1];
                }
            }

            data = Arrays.copyOf(temp, temp.length * 2);
            size++;
        }

    }

    /**
     * Remove and return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    @Override
    public E remove(int index) {

        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("index cannot be less than zero, or greater than size");
        }

        if (index == data.length - 1) {

            E temp = data[index];

        }

        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[data.length + 1];

        for (int i = 0; i < temp.length; i++) {

//            //Assign same index for those below new element's index
//            if (i < index) {
//                temp[i] = data[i];
//            }
//            //Assign index of new element with the element
//            else if (i == index) {
//                temp[i] = e;
//            }
//            //Else assign sama data for the remaining entries in original array
//            else {
//                temp[i] = data[i - 1];
//            }
        }

        data = Arrays.copyOf(temp, temp.length * 2);
        size++;

        return temp[1];
    }

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */
    @Override
    public int indexOf(E e) {

        return -1;
    }

    /**
     * Return an iterator over this list.
     * Note: While the list is traversed by this iterator,
     * adding or removing an element is not allowed.
     */
    @Override
    public Iterator<E> iterator() {

        return null;
    }

    //-------------------------------------------

    @Override
    public String toString() {

        return null;
    }

}
