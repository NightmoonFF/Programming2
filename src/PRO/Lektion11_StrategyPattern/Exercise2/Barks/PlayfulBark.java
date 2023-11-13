package PRO.Lektion11_StrategyPattern.Exercise2.Barks;

public class PlayfulBark implements BarkBehavior {

    @Override
    public void bark() {

        System.out.println("Bark Bark!");
    }

}
