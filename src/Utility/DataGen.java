package Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public abstract class DataGen {

    private static final ArrayList<String> firstNameList = new ArrayList<>();
    private static final ArrayList<String> lastNameList = new ArrayList<>();
    private static final ArrayList<String> placeList = new ArrayList<>();

    static {
        // First Names
        try (BufferedReader br = new BufferedReader(new FileReader("src/Utility/StringLists/first-names.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                firstNameList.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Last Names
        try (BufferedReader br = new BufferedReader(new FileReader("src/Utility/StringLists/last-names.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lastNameList.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Places
        try (BufferedReader br = new BufferedReader(new FileReader("src/Utility/StringLists/places.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                placeList.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------//

    public static String rndFirstName() { return firstNameList.get(new Random().nextInt(1, firstNameList.size())); }

    public static String rndLastName() { return lastNameList.get(new Random().nextInt(1, lastNameList.size())); }

    public static String rndPlace() { return placeList.get(new Random().nextInt(1, placeList.size())); }

    public static ArrayList<String> getFirstNameList() { return firstNameList; }

    public static ArrayList<String> getLastNameList() { return lastNameList; }

    public static ArrayList<String> getPlaceList() { return placeList; }

}
