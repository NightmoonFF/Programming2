package DAOS.Lektion8_JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class Opgave14 {
    public static void main(String[] args) throws SQLException {

        connect();
        //findRytter();
        //insertResult2022();
        //createPreparedStatement();
        createPersonArray();
    }
    static Connection minConnection;
    static Statement stmt;
    static BufferedReader inLine;
    private static void connect(){

        try {
            inLine = new BufferedReader(new InputStreamReader(System.in));
            String server="localhost";
            String dbnavn="Semester2_Lektion8";
            String login="sa";
            String password="19451945Wtf";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+dbnavn+
                    ";user=" + login + ";password=" + password + ";");

            stmt = minConnection.createStatement();
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }
    }

/*
    Find scriptet med cykelrytterdatabasen fra lektion 3

    Giv de to foreign key constraints i placering navne og kør scriptet ind igen (se evt. definitionen af
    tabellen ansati i eksempel-databasen)

    Lav nu en java-metode, som indlæser en rytterinitial og udskriver årstal og placeringer for ham.
    Hvis han er udgået, skrives UDGÅET. Du skal fra denne metode selv lave SQL-sætningen via
    strengmanipulation (brug selectmedparm som skabelon).

    Lav herefter et Java-program, hvor du kan indtaste resultaterne for 2022 (se nedenfor) og gemmer
    disse resultater i databasen. Du skal også her lave SQL-sætningen via strengmanipulation (brug
    insertmedstring som skabelon). Du skal kun lave Java-programmet til indtastning af selve
    resultaterne, øvrige oprettelser laver du bare via Management Studio.

    Udvid din løsning, så der kommer fornuftige fejlreaktioner (f.eks. hvis du indtaster placeringer for
    en rytter, der ikke er oprettet)

    VM i 2022 blev afholdt i Wollongong i Australien. Alle danskere fuldførte. De danske resultater
    var: Mattias Skjelmose (ikke oprettet), nr. 10, Mikkel Frølich Honore (MFH) nr. 15, Magnus Cort
    (MC) nr. 35, Michael Mørkøv (MMØ) nr. 55, Jakob Fuglsang (JF) nr. 56, Alexander Kamp (ikke
    oprettet) nr. 57, Anthon Charmig (ikke oprettet) nr. 70, Mikkel Bjerg (MBJ) nr. 92
*/
    private static void findRytter(){
        try {

            System.out.println("Indtast søgestreng");
            String inString = inLine.readLine();

            String sql =
                    "USE Semester2_lektion8\n" +
                    "SELECT rytter.rytternavn, placering.aarstal, placering.plac\n" +
                    "FROM rytter\n" +
                    "LEFT JOIN placering ON placering.initial = rytter.initial\n" +
                    "WHERE rytter.initial = '" + inString + "'";

            ResultSet res=stmt.executeQuery(sql);

            //gennemløber svaret
            while (res.next()) {

                if(res.getString(3) == null){
                    System.out.println(res.getString(1) + "    " + res.getString(2) + "    " + "UDGÅET");
                }else

                System.out.println(res.getString(1) + "    " + res.getString(2) + "    " + res.getString(3));

            }
            // pæn lukning
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }
    }
    private static void insertResult2022(){
        try {
            System.out.println("Indtast initialer");
            String initialStr=inLine.readLine();
            System.out.println("Indtast placering");
            String placeringStr=inLine.readLine();

            // sender insert'en til db-serveren
            String sql = "insert into placering values (2022,'" + initialStr + "'," + placeringStr + ")";
            stmt.execute(sql);
            System.out.println("Placering er nu registreret");
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            // fejl-kode 547 svarer til en foreign key fejl
            { case 547 : {if (e.getMessage().contains("fk_initial"))
                System.out.println("initial-nummer er ikke oprettet");
            else
                System.out.println("ukendt fremmednøglefejl");
                break;
            }
            // fejl-kode 2627 svarer til primary key fejl
                case 2627: {System.out.println("placering er allerede oprettet");
                    break;
                }
                default: System.out.println("fejlSQL:  "+e.getMessage());
            };
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
        }

    }
/*
    Lav inserten fra opgave 14 igen, idet du nu anvender prepared statements i stedet for selv at lave
    SQL-sætningen med strengmanipulation. (du kan bruge insertprepared som skabelon)
    Hint: På prepared statement findes en metode setNull – ikke så relevant i år, da alle fuldførte.
 */
    private static void createPreparedStatement() throws SQLException {
        try {
            String sql =
                    "USE Semester2_lektion8\n" +
                            "SELECT rytter.rytternavn, placering.aarstal, placering.plac\n" +
                            "FROM rytter\n" +
                            "LEFT JOIN placering ON placering.initial = rytter.initial\n" +
                            "WHERE rytter.initial = 'AJ'";

            // Prepared statement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            ResultSet rs = prestmt.executeQuery();


            while( rs.next()){
                System.out.println(rs.getString(1) + "    " + rs.getString(2) + "    " + rs.getString(3));
            }

            // Udf�rer sætningen
            rs.close();
            prestmt.close();

            System.out.println("bop");
            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
            System.out.println("fejlSQL:  "+e.getMessage());};
        }

/*
    Lav et JAVA-program der læser en hel tabel med personer ind i en ArrayList af person-objekter.
*/

    private static void createPersonArray(){
        try {
            String sql =
                    "USE Semester2_lektion8\n" +
                    "SELECT * FROM person\n";

            // Prepared statement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            ResultSet rs = prestmt.executeQuery();

            ArrayList<Person> people = new ArrayList<>();

            while( rs.next()){
                people.add(new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }

            // Udf�rer sætningen
            rs.close();
            prestmt.close();

            for(Person p : people){
                System.out.println(
                                p.navn + "  -  " +
                                p.cpr + "  -  " +
                                p.stilling + "  -  " +
                                p.løn + "  -  " +
                                p.postnr);
            }

            if (!minConnection.isClosed()) minConnection.close();
        }
        catch (SQLException e) {
            System.out.println("fejlSQL:  "+e.getMessage());};
    }
}


class Person{
    String cpr;
    String navn;
    String stilling;
    int løn;
    int postnr;

    public Person(String cpr, String navn, String stilling, int løn, int postnr) {
        this.cpr = cpr;
        this.navn = navn;
        this.stilling = stilling;
        this.løn = løn;
        this.postnr = postnr;
    }
}