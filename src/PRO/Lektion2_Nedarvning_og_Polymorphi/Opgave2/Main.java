package PRO.Lektion2_Nedarvning_og_Polymorphi.Opgave2;

import java.util.ArrayList;

public class Main {

    static ArrayList<GeoShape> geoShapes = new ArrayList();
    public static void main(String[] args) {

        initTestData();

        double totalArea = 0;

        for(GeoShape shape : geoShapes){
            System.out.println(shape.toString());
            shape.ParallelShift(-100, -20);
            System.out.println(shape.toString());
            System.out.println("Area: " + shape.Area());
            System.out.println();
            totalArea += shape.Area();
        }

        System.out.println();
        System.out.println("Total Area: " + totalArea);
    }


    public static void initTestData(){
        Circle circle1 = new Circle(5, 10, 5);
        Circle circle2 = new Circle(11, 25, 8.4);
        Ellipse ellipse1 = new Ellipse(2, 5, 10, 20);
        Ellipse ellipse2 = new Ellipse(0, 0, 15, 42);
        Square square1 = new Square(20, 20, 10);
        Square square2 = new Square(25, 25, 82.1);
        Rectangle rectangle1 = new Rectangle(50, 50, 10, 25);
        Rectangle rectangle2 = new Rectangle(100, 100, 24.51, 99.74);

        geoShapes.add(circle1);
        geoShapes.add(circle2);
        geoShapes.add(ellipse1);
        geoShapes.add(ellipse2);
        geoShapes.add(square1);
        geoShapes.add(square2);
        geoShapes.add(rectangle1);
        geoShapes.add(rectangle2);

    }
}
