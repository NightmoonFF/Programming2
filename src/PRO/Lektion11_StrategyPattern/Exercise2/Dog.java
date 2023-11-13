package PRO.Lektion11_StrategyPattern.Exercise2;

import PRO.Lektion11_StrategyPattern.Exercise2.Barks.BarkBehavior;
import PRO.Lektion11_StrategyPattern.Exercise2.Diets.Diet;

public abstract class Dog {

    private BarkBehavior barkBehavior;
    private Diet diet;

    public Dog(BarkBehavior barkBehavior, Diet diet) {

        this.barkBehavior = barkBehavior;
        this.diet = diet;
    }

    public void bark() { barkBehavior.bark(); }

    public void eat() { diet.eat(); }

    public void setBarkBehavior(BarkBehavior barkBehavior) {

        this.barkBehavior = barkBehavior;
    }

    public void setDiet(Diet diet) {

        this.diet = diet;
    }

}
