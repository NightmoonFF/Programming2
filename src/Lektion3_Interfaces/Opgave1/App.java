package Lektion3_Interfaces.Opgave1;

import Utility.ConsoleStyling;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        initTestData();

        // Average Scoville
        double tempAverage = average(spicyStuff.toArray(new Measurable[0]));
        System.out.println(ConsoleStyling.color("Average Scoville: ", "#FFFF00", true) + ConsoleStyling.color(Double.toString(tempAverage), "#FFFFFF", false));

        // Spiciest Chilli
        Measurable tempMax = max(spicyStuff.toArray(new Measurable[0]));
        System.out.println(ConsoleStyling.color("Spiciest Chilli: ", "FFFF00", true) + ConsoleStyling.color(Double.toString(tempMax.getMeasure()), "FFFFFF", false) + " (" + tempMax.getName() + ")");

        // Black Friday Meal
        Measurable[] tempFridayMeal = blackFridayMeal(spicyStuff.toArray(new Measurable[0]), beers.toArray(new Measurable[0]));
        System.out.print(ConsoleStyling.color("Black Friday Meal: ", "FFFF00", true));
        for(int i = 0; i < tempFridayMeal.length; i++){
            boolean isLastEntry = (i == tempFridayMeal.length - 1);
            String entry = tempFridayMeal[i].getName();
            System.out.print(ConsoleStyling.color(entry, "#00FF00", false));

            if(!isLastEntry){
                System.out.print(ConsoleStyling.color(", ", "#FFFFFF", false));

            }
            else{ System.out.println(); }
        }

        // Filtered Average Scoville
        double tempAverageFiltered = average(spicyStuff.toArray(new Measurable[0]), new ChilliFilter());
        System.out.println(ConsoleStyling.color("Average Scoville", "#FFFF00", true) + " (filtered): " + ConsoleStyling.color(Double.toString(tempAverageFiltered), "#FFFFFF", false));



    }

    /**
     * Filter for chillies, to rule out ones with less than 5000 scoville
     */
    static class ChilliFilter implements Filter{
        @Override
        public boolean acceptMeasure(Measurable x){
            if(x.getMeasure() >= 5000){
                return true;
            }
            else return false;
        }
    }


    /**
     * Calculate average measurement, with a filter applied
     * @param objects objects to measure
     * @param filter the filter to apply
     * @return the average of the objects, excluding those filtered out
     */
    public static double average(Measurable[] objects, Filter filter){

        double result = 0;
        int counter = 0;

        for(Measurable m : objects){

            if(filter.acceptMeasure(m)){
                result += m.getMeasure();
                counter++;
            }
        }
        return result/counter;
    }


    public static double average(Measurable[] objects) {

        double result = 0;
        int counter = 0;

        for(Measurable m : objects){
            result += m.getMeasure();
            counter++;
        }
        return result/counter;
    }

    public static Measurable max(Measurable[] objects){

        Measurable tempObject = new Chili("temp", 0);

        for(Measurable m : objects){
            if(m.getMeasure() > tempObject.getMeasure() || tempObject == null){
                tempObject = m;
            }
        }
        return tempObject;
    }

    public static Measurable[] blackFridayMeal(Measurable[] chillies, Measurable[] beers){

        Measurable strongestChilli = null;
        Measurable strongestBeer = null;

        for(Measurable chili : chillies){
            if(strongestChilli == null){
                strongestChilli = chili;
            }
            else if(chili.getMeasure() > strongestChilli.getMeasure()){
                strongestChilli = chili;
            }
        }

        for(Measurable beer : beers){
            if(strongestBeer == null){
                strongestBeer = beer;
            }
            else if(beer.getMeasure() > strongestBeer.getMeasure()){
                strongestBeer = beer;
            }
        }

        return new Measurable[]{strongestChilli, strongestBeer};
    }

    static ArrayList<Measurable> spicyStuff = new ArrayList<>();

    static ArrayList<Measurable> beers = new ArrayList<>();

    private static void initTestData(){
        Chili chili1 = new Chili("Bell Pepper", 100);
        Chili chili2 = new Chili("Jalapeño", 2000);
        Chili chili3 = new Chili("Pimenta de Neyde", 100000);
        Chili chili4 = new Chili("Habanero", 250000);
        Chili chili5 = new Chili("Carolina Reaper", 1500000);
        spicyStuff.addAll(Arrays.asList(chili1, chili2, chili3, chili4, chili5));

        Beer beer1 = new Beer("Tuborg", 4.5);
        Beer beer2 = new Beer("Carlsberg", 4.1);
        Beer beer3 = new Beer("Royal", 4.7);
        Beer beer5 = new Beer("IPA Loco", 21);
        Beer beer4 = new Beer("Master Brew", 10.6);
        beers.addAll(Arrays.asList(beer1, beer2, beer3, beer4, beer5));
    }

}