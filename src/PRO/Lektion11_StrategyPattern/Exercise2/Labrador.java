package PRO.Lektion11_StrategyPattern.Exercise2;

import PRO.Lektion11_StrategyPattern.Exercise2.Barks.BarkBehavior;
import PRO.Lektion11_StrategyPattern.Exercise2.Diets.Diet;

public class Labrador extends Dog {

    public Labrador(BarkBehavior barkBehavior, Diet diet) {

        super(barkBehavior, diet);
    }

}
