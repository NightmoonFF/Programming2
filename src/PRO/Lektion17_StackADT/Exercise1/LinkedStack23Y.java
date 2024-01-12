package PRO.Lektion17_StackADT.Exercise1;

import java.util.NoSuchElementException;

// OPGAVE 1 med single-linked liste.
public class LinkedStack23Y<E> implements Stack23Y<E> {

    // top of stack is at head of list
    private Node<E> head = null;

    // the number of element in the stack
    int size = 0;

    /**
     * Add the element at the top of this stack.
     */
    @Override
    public void push(E entry) {
        Node<E> newNode = new Node<>(entry);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Remove and return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E pop() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        E popped = head.element;
        head = head.next;
        size--;
        return popped;
    }

    /**
     * Return this stack's top element.
     * Throw NoSuchElementException, if the stack is empty.
     */
    @Override
    public E peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return head.element;
    }

    /**
     * Return true, if this stack is empty.
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Removes all elements from this stack.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Return the number of elements in the stack.
     */
    @Override
    public int size() {

        return size;
    }

    //-------------------------------------------------------------------------

    private static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}
