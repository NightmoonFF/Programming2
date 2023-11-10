package PRO.Lektion19_SorteretListe_og_Cirkulært_Array.Exercise1;

public class Exercise1 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    In this exercise you will implement a generic sorted singly-linked list. The elements in the list       │
    │    must be sorted in ascending order (according to Comparable<E>).                                         │
    │    Implement a test program and test the list (add a toString() method to the list).                       │
    │    The sorted singly-linked list must implement the following interface:                                   │
    │                                                                                                            │
    │    public class SortedList23Y<E> {                                                                         │
    │    *                                                                                                       │
    │    * Add the element to the list.                                                                          │
    │    * The list is still sorted after the element is added.                                                  │
    │    *                                                                                                       │
    │    public void add(E element);                                                                             │
    │    *                                                                                                       │
    │    * Remove the first element in the list.                                                                 │
    │    * The list is still sorted after the element is removed.                                                │
    │    * Return true, if the element was removed.                                                              │
    │    *                                                                                                       │
    │    public boolean removeFirst();                                                                           │
    │    *                                                                                                       │
    │    * Remove the last element in the list.                                                                  │
    │    * The list is still sorted after the element is removed.                                                │
    │    * Return true, if the element was removed.                                                              │
    │    *                                                                                                       │
    │    public boolean removeLast();                                                                            │
    │    *                                                                                                       │
    │    * Remove the first instance of the element from the list.                                               │
    │    * The list is still sorted after the element is removed.                                                │
    │    * Return true, if the element was removed.                                                              │
    │    *                                                                                                       │
    │    public boolean remove(E element);                                                                       │
    │    *                                                                                                       │
    │    * Return the number of elements in the list.                                                            │
    │    *                                                                                                       │
    │    public int size();                                                                                      │
    │    }                                                                                                       │
    │                                                                                                            │
    │    Requirement: Do not use a size field in your implementation                                             │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {

    }

    //Node next skal bruges på en fornuftig måde, man bliver nødt til at gå én
    //for langt, da man ikke ved om næste node er der hvor elementet skal indsættes.
    //Hvis fx P skal ind efter M, men man ved ikke om der er noget med V før
    //fx R, som ville være den der er én for langt

}
