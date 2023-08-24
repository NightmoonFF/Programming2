package Lektion2_Nedarvning_og_Polymorphi.Opgave2;

public abstract class GeoShape {

    String name;
    double posX;
    double posY;

    public GeoShape(double posX, double posY) {
        // "This" skulle gerne hente subklassens navn, ikke superklassens
        this.name = getClass().getSimpleName();
        this.posX = posX;
        this.posY = posY;
    }

    public void ParallelShift(double xAmount, double yAmount){
        this.posX += xAmount;
        this.posY += yAmount;
    }
    public double Area(){

        throw new NullPointerException("This Superclass Method Should Never Be Used. Check overrides in subclasses");
    }

}

class Square extends GeoShape{

    double sideLength;

    public Square(double posX, double posY, double sideLength) {
        super(posX, posY);
        this.sideLength = sideLength;
    }

    @Override
    public double Area(){
        double total = 0;
            total = Math.pow(sideLength, 2);
        return total;
    }

    @Override
    public String toString(){return this.getClass().getSimpleName() + " - " + "Position: (" + this.posX + "," + posY + ") SideLength: " + this.sideLength;}
}

class Rectangle extends GeoShape{

    double sideLengthA;
    double sideLengthB;

    public Rectangle(double posX, double posY, double sideLengthA, double sideLengthB) {
        super(posX, posY);
        this.sideLengthA = sideLengthA;
        this.sideLengthB = sideLengthB;
    }

    public double Area(){
        double total = 0;
        total = sideLengthA * sideLengthB;
        return total;
    }

    public String toString(){return this.getClass().getSimpleName() + " - " + "Position: (" + this.posX + "," + posY + ") SideLengthA: " + this.sideLengthA + " SideLengthB: " + this.sideLengthB;}
}

class Circle extends GeoShape{

    double radius;
    public Circle(double posX, double posY, double radius) {
        super(posX, posY);
        this.radius = radius;
    }

    public double Area(){
        double total = 0;
        total = Math.PI * Math.pow(radius, 2);
        return total;
    }

    public String toString(){return this.getClass().getSimpleName() + " - " + "Position: (" + this.posX + "," + posY + ") Radius: " + this.radius;}

}

class Ellipse extends GeoShape{

    double axisMajor;
    double axisMinor;
    public Ellipse(double posX, double posY, double axisMajor, double axisMinor) {
        super(posX, posY);
        this.axisMajor = axisMajor;
        this.axisMinor = axisMinor;
    }


    public double Area(){
        double total = 0;
        total = Math.PI * axisMajor * axisMinor;
        return total;
    }

    public String toString(){return this.getClass().getSimpleName() + " - " + "Position: (" + this.posX + "," + posY + ") Major Axis: " + this.axisMajor + " Minor Axis: " + this.axisMinor;}
}