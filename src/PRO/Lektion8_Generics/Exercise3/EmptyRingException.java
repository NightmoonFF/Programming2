package PRO.Lektion8_Generics.Exercise3;

public class EmptyRingException extends RuntimeException{
    public EmptyRingException(){
        super("Error: Ring is empty");
    }
}
