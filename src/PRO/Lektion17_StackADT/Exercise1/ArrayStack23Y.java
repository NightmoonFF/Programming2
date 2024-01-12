package PRO.Lektion17_StackADT.Exercise1;

import java.util.Arrays;
import java.util.NoSuchElementException;

// OPGAVE 1 med array.
public class ArrayStack23Y<E> implements Stack23Y<E> {

    // top is the index of the top element in the stack,
    // top is -1 if the stack is empty
    private int top = -1;

    // items contains the elements in the stack at index 0..top and null else
    @SuppressWarnings("unchecked")
    private E[] items = (E[]) new Object[4];

    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {

        //Checks if stack is full
        if (top == items.length - 1) {
            //Doubles stack size
            items = Arrays.copyOf(items, items.length * 2);
        }

        //Increment top index (the new entry on the stack is one higher)
        top++;

        //Adds the latest entry on top of the stack
        items[top] = entry;

    }

    /**
     * Remove and return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop() {
        if(!isEmpty()){
            return items[top--]; //returns and decrements
        }
        else{
            throw new NoSuchElementException("Cannot pop stack: is empty");
        }

    }

    /**
     * Return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E peek() {

        if(!isEmpty()){
            return items[0];
        }
        else{
            throw new NoSuchElementException("Cannot pop stack: is empty");
        }
    }

    /**
     * Return true, if this stack is empty.
     */
    @Override
    public boolean isEmpty() {
        if(top == -1){
            return true;
        }
        else return false;
    }

    /**
     * Remove all elements from this stack.
     */
    @Override
    public void clear() {

    }

    /**
     * Return the number of elements in this stack.
     */
    @Override
    public int size() {

        return 0;
    }
}
