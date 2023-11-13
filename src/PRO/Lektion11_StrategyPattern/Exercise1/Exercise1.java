package PRO.Lektion11_StrategyPattern.Exercise1;

public class Exercise1 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 1                                                                                              │
    │                                                                                                            │
    │    Gruppearbejde Head First Design Patterns, Kap. 1                                                        │
    │    1) Side 1-7                                                                                             │
    │    Den oprindelige løsning med nedarvning og interfaces :                                                  │
    │    • Diskuter de beskrevne løsninger: den med nedarvning, og den anden med interfaces                      │
    │    (for at sikre at alle i gruppen har forstået de to løsninger).                                          │
    │    • Hvorfor er disse løsninger ikke gode løsninger i eksemplet Duck?                                      │
    │    (I mange andre situationer er nedarvning og/eller interfaces en god løsning.)                           │
    │    2) Side 8-21                                                                                            │
    │    Hvad opnås ved isolering af det der ændrer sig, fra det der er konstant ?                               │
    │    Den nye løsning med delegeríng (kaldes også komposition):                                               │
    │    • Diskuter den nye løsning, så alle forstår den.                                                        │
    │    • Hvilke designprincipper anvendes? Formuler disse med egne ord.                                        │
    │    • Udpeg de vigtigste dele i den færdige kode.                                                           │
    │    • Hvordan kan adfærden for en and ændres på kørselstidspunktet?                                         │
    │    3) Side 22-24                                                                                           │
    │    Strategy Pattern :                                                                                      │
    │    • Kommentér Design Principle “Favor composition over inheritance” s. 23.                                │
    │    Formuler dette med egne ord.                                                                            │
    │    • Forklar Strategy Pattern side 24 .                                                                    │
    │    4) Side 25-32                                                                                           │
    │    Sammendrag af kapitlet :                                                                                │
    │    • Løs Design Puzzle på side 25 .                                                                        │
    │    • Formuler med egne ord en opsummering af siderne 26-28.                                                │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

/*
    1) 2)
    Joes solution to solve flying rubber ducks, is to make the subclasses not inheret the fly() method
    but instead remove it from the superclass, and create a fly() interface, that the ones who are
    suposed to fly inherits from. But java Interfaces have no implementation code, which means you
    would have to track down each duck and change their fly() code.

    Design principle:
    In other words, if you’ve got some aspect of your code that is
    changing, say with every new requirement, then you know you’ve
    got a behavior that needs to be pulled out and separated from all
    the stuff that doesn’t change.
    Here’s another way to think about this principle: take the parts
    that vary and encapsulate them, so that later you can
    alter or extend the parts that vary without affecting
    those that don’t

    Now, to separate the “parts that change from those that stay the same”, we are going to create two
    sets of classes (totally apart from Duck), one for fly and one for quack. Each set of classes will hold
    all the implementations of their respective behavior. For instance, we might have one class that
    implements quacking, another that implements squeaking, and another that implements silence.

    From now on, the Duck behaviors will live in a separate class—a class
    that implements a particular behavior interface.

    We’ll use an interface to represent each behavior – for instance,
    FlyBehavior and QuackBehavior – and each implementation of a
    behavior will implement one of those interfaces.

    Behavior can be changed at runtime, by assigning a different FlyBehavior class to a duck



*/

    public static void print() {

    }

}
