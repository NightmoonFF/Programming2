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
    │    Problem: Flyt alle skiver fra søjle 1 til søjle 3.                                                      │
    │    Regler:                                                                                                 │
    │    • Man må kun flytte én skive af gangen                                                                  │
    │    • En større skive må ikke placeres på en mindre                                                         │
    │    • Alle skiver skal placeres på en søjle                                                                 │
    │    Algoritmen:                                                                                             │
    │    • Flyt de øverste N-1 skiver til fra A til B                                                            │
    │    • Flyt den nederste skive fra A til C                                                                   │
    │    • Flyt N-1 skiver fra B til C                                                                           │
    │                                                                                                            │
    │    public class Towers {                                                                                   │
    │    	public static void main(String[] args) {                                                               │
    │    	move(4, 1, 3); // 4 diske fra 1 (=A) til 3 (=C)                                                        │
    │    }                                                                                                       │
    │    		// move n disks from ‘from’ to ‘to’                                                                   │
    │    		public static void move(int n, int from, int to) {                                                    │
    │    			if (n == 1) {                                                                                        │
    │    				System.out.println("Move: " + from + " -> " + to);                                                  │
    │    			} else {                                                                                             │
    │    				move(n - 1, from, other);                                                                           │
    │    				System.out.println("Move: " + from + " -> " + to);                                                  │
    │    				move(n - 1, other, to);                                                                             │
    │    			}                                                                                                    │
    │    	}                                                                                                      │
    │    }                                                                                                       │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print(){

    }



}
