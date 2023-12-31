package PRO.Lektion11_StrategyPattern.Exercise2;

import PRO.Lektion11_StrategyPattern.Exercise2.Barks.Growl;
import PRO.Lektion11_StrategyPattern.Exercise2.Barks.PlayfulBark;
import PRO.Lektion11_StrategyPattern.Exercise2.Diets.NormalDiet;
import PRO.Lektion11_StrategyPattern.Exercise2.Diets.ProteinDiet;

public class Exercise2 {
/*
    ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                            │
    │    Exercise 2                                                                                              │
    │                                                                                                            │
    │    Dog klassen er en abstract klasse, som har klassen Labrador som underklasse.                            │
    │    En hund (dog) har to adfærd. Den kan spise (eat) enten en normal diæt (NormalDiet: ”Eating              │
    │    a normal diet”) eller en protein diæt (ProteinDiet: ”Eating a protein diet”). Den kan også gø           │
    │    (bark), enten som lystig gøen (PlayfullBark: “Bark! Bark!”) eller som knurren (Growl:                   │
    │    “Growl! Growl!”).                                                                                       │
    │    Implementer en hunds adfærd vha. Strategy mønsteret.                                                    │
    │    Lav en test klasse med en labrador, som har både en spise adfærd og en gø adfærd. Test                  │
    │    hundens adfærd. Lav også en ændring af begge adfærd, og test hundens adfærd igen                        │
    │                                                                                                            │
    └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
*/

    public static void print() {

        Dog dog = new Labrador(new PlayfulBark(), new NormalDiet());

        dog.eat();
        dog.bark();
        dog.setDiet(new ProteinDiet());
        dog.setBarkBehavior(new Growl());
        dog.eat();
        dog.bark();

    }

}
