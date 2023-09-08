package Utility.StringLists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class StringList {

    private static ArrayList<String> firstNameList = new ArrayList<>();

    // Initialize lists
    static {


        try (BufferedReader br = new BufferedReader(new FileReader("src/Utility/StringLists/first-names.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                firstNameList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //region Places
    private static ArrayList<String> placeList = new ArrayList<>();
    // Init list
    static {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Utility/StringLists/places.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                placeList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getPlaceList() {
        return placeList;
    }

    public static String getRandomPlace(){
        Random rnd = new Random();
        return placeList.get(rnd.nextInt(1, placeList.size()));
    }


    //endregion





    public static ArrayList<String> getFirstNameList() {
        return firstNameList;
    }
}
