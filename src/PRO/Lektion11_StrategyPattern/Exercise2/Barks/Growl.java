package PRO.Lektion11_StrategyPattern.Exercise2.Barks;

public class Growl implements BarkBehavior {

    @Override
    public void bark() {

        System.out.println("Growl..Growl!");
    }

}
