package PRO.Lektion6_Rekursion2.Exercise6;
public class Exercise6{
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 6                                                                                              │
    │                                                                                                            │
    │    Towers of Hanoi exercise                                                                                │
    │    First calculate the number of moves needed to move n disks (do not use a program for this).             │
    │    Then extend the Towers of Hanoi program so that it prints the needed number of moves.                   │
    │                                                                                                            │
    │    Problem: Flyt alle skiver fra søjle A til søjle C.                                                      │
    │    Regler:                                                                                                 │
    │    • Man må kun flytte én skive af gangen                                                                  │
    │    • En større skive må ikke placeres på en mindre                                                         │
    │    • Alle skiver skal placeres på en søjle                                                                 │
    │    Algoritmen:                                                                                             │
    │    • Flyt de øverste N-1 skiver fra A til B                                                                │
    │    • Flyt den nederste skive fra A til C                                                                   │
    │    • Flyt N-1 skiver fra B til C                                                                           │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    /*
    First calculate in hand  the number of moves needed to move n disks
    After playing with the rings a little, seems the formula is that moving
    them from A to B, except the last one, is n(n-1). then you add one, to move the
    remaining one to C, then add n(n-1) again to move them over

    This would be base cases:
    n0 = 0
    n1 = 1

    n2 = n1 + 1 + n1
    = 1 + 1 + 1
    = 3

    n3 = n2 + 1 + n2
    = 3 + 1 + 3
    = 7

     */

    /**
     * @param n - amount of rings to move
     * @return - total moves needed to move n rings
     */
    public static int hanoiMoves(int n) {
        if(n <= 0) { throw new IllegalArgumentException("n cannot be 0 or negative"); }
        if(n == 1) { return 1; }

        // n(n) = n(n-1) + 1 + n(n-1)
        return hanoiMoves(n-1) + 1 + hanoiMoves(n-1);
    }

    public static void print(){
        System.out.println(hanoiMoves(6));
    }
}
