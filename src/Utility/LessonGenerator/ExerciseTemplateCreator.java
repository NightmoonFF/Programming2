package Utility.LessonGenerator;

import Utility.ConsoleStyling;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ExerciseTemplateCreator extends Application{
    static VBox vbxScroll;
    static ArrayList<String[]> exerciseDescriptions = new ArrayList<>();
    static int currentExercisePage = 0;
    static TextArea txaDescription;
    static Button btnPrevious;
    static Label lblExercise;
    @Override
    public void start(Stage primaryStage) {
        initGUI(primaryStage);
    }

    private static final int CHARACTER_LIMIT = 100;

    //region GUI
    private static void limitText(){

        // Add a listener to enforce the character limit
        txaDescription.textProperty().addListener((observable, oldValue, newValue) -> {
            String[] lines = newValue.split("\n");
            StringBuilder newText = new StringBuilder();

            for (String line : lines) {
                if (line.length() > CHARACTER_LIMIT) {
                    String trimmedLine = line.substring(0, CHARACTER_LIMIT);
                    newText.append(trimmedLine).append("\n");
                    while (line.length() > CHARACTER_LIMIT) {
                        line = line.substring(CHARACTER_LIMIT);
                        newText.append(line, 0, Math.min(line.length(), CHARACTER_LIMIT)).append("\n");
                    }
                } else {
                    newText.append(line).append("\n");
                }
            }

            // Remove extra newline at the end
            newText.setLength(newText.length() - 1);

            txaDescription.setText(newText.toString());
        });

    }
    private static void initGUI(Stage primaryStage){

        //region Create Package Name
        Label lblPkName = new Label("Package Name: ");
        lblPkName.setAlignment(Pos.BASELINE_CENTER);
        TextField txfPackageName = new TextField();
        txfPackageName.setPrefSize(100, 20);
        txfPackageName.setMaxSize(250, 20);
        txfPackageName.setAlignment(Pos.BASELINE_CENTER);
        //endregion

        //region Create Navigation bar
        btnPrevious = new Button("Back");
        btnPrevious.setOnAction(e -> previousPage());
        btnPrevious.setAlignment(Pos.BASELINE_LEFT);
        btnPrevious.setDisable(true);

        lblExercise = new Label("Exercise " + "1");
        lblExercise.setAlignment(Pos.BASELINE_CENTER);
        lblExercise.setFont(Font.font ("Verdana", 20));

        Button btnNext = new Button("Next");
        btnNext.setOnAction(e -> nextPage());
        btnNext.setAlignment(Pos.BASELINE_RIGHT);

        // Create empty regions (panes) for left and right alignment
        Pane leftSpacer = new Pane();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS); // Expand to fill available space
        Pane rightSpacer = new Pane();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS); // Expand to fill available space


        HBox hbxNavigation = new HBox();
        hbxNavigation.setAlignment(Pos.BASELINE_CENTER);
        hbxNavigation.setMinSize(600, 20);
        hbxNavigation.setPrefSize(600, 20);
        hbxNavigation.setMaxSize(600, 20);
        hbxNavigation.getChildren().addAll(btnPrevious,leftSpacer, lblExercise,rightSpacer, btnNext);

        //label for end of navigation
        Label lblSpacer = new Label();
        //endregion

        //region Create DescriptionField
        txaDescription = new TextArea("...");
        txaDescription.setPrefSize(600, 450);
        txaDescription.setMinSize(600, 450);
        txaDescription.setMaxSize(600, 450);
        txaDescription.setWrapText(true);
        limitText();
        //endregion

        //region Create Button
        Button btnConfirm = new Button("Confirm");
        btnConfirm.setPrefSize(150, 50);
        btnConfirm.setOnAction(e -> createLesson(txfPackageName.getText()));
        //endregion

        //region Create Main Vbox
        VBox vbxMain = new VBox(10);
        vbxMain.setAlignment(Pos.TOP_CENTER);
        vbxMain.getChildren().addAll(lblPkName, txfPackageName, hbxNavigation, lblSpacer, txaDescription);
        //endregion

        //region Create Border Pane
        BorderPane borderPane = new BorderPane();

        BorderPane.setAlignment(vbxMain, Pos.TOP_CENTER);
        BorderPane.setMargin(vbxMain, new Insets(12, 12, 12, 12));
        borderPane.setCenter(vbxMain);

        BorderPane.setAlignment(btnConfirm, Pos.BASELINE_CENTER);
        BorderPane.setMargin(btnConfirm, new Insets(12, 12, 12, 12));
        borderPane.setBottom(btnConfirm);
        //endregion

        //region Create Scene
        Scene scene = new Scene(borderPane, 700, 700);

        primaryStage.setTitle("Create new Lesson");
        primaryStage.setScene(scene);
        primaryStage.show();
        //endregion
    }
    private static void nextPage(){
        btnPrevious.setDisable(false);
        saveExerciseToArray();
        currentExercisePage++;
        pasteExerciseFromArray();
        lblExercise.setText("Exercise " + String.valueOf(currentExercisePage+1));
    }
    private static void previousPage(){
        saveExerciseToArray();
        currentExercisePage--;
        pasteExerciseFromArray();

        if(currentExercisePage == 0){
            btnPrevious.setDisable(true);
        }

        lblExercise.setText("Exercise " + String.valueOf(currentExercisePage+1));
    }
    private static void pasteExerciseFromArray(){
        if (currentExercisePage >= 0 && currentExercisePage < exerciseDescriptions.size()) {

            StringBuilder sb = new StringBuilder();
            for (String line : exerciseDescriptions.get(currentExercisePage)) {
                sb.append(line).append("\n");
            }
            String text = sb.toString();


            txaDescription.setText(text);

        } else {
            txaDescription.clear();
        }
    }
    private static void saveExerciseToArray(){

        if (txaDescription.getText().length() > 1){

            String text = txaDescription.getText();
            String[] lines = text.split("\n");

            String[] storedLines = new String[lines.length];

            System.arraycopy(lines, 0, storedLines, 0, lines.length);

            if (exerciseDescriptions.size() > currentExercisePage){
                exerciseDescriptions.set(currentExercisePage, storedLines);
            } else{
                exerciseDescriptions.add(currentExercisePage, storedLines);
            }
        }
    }
    //endregion

    //region File Creation
    public static void createLesson(String pkgName){

        saveExerciseToArray();

        //region Create Main Directory
        String directoryPath = "src" + File.separator + "PRO" + File.separator + pkgName; // Specify the directory path
        Path mainPath = Paths.get(directoryPath); // Create a Path object for the directory

        if (!Files.exists(mainPath)) {
            try {
                Files.createDirectory(mainPath);
                System.out.println(
                            ConsoleStyling.color("Package: ", ConsoleStyling.Color.GREEN, true) +
                            ConsoleStyling.color(pkgName, ConsoleStyling.Color.ORANGE, true) +
                            ConsoleStyling.color(" created successfully", ConsoleStyling.Color.GREEN, true));

            } catch (IOException e) {
                System.err.println("Failed to create directory: " + e.getMessage());
            }
        } else {
            System.out.println("Directory already exists.");
        }
        //endregion

        //region Create Main class
        try {
            Files.createFile(Paths.get(mainPath + File.separator + "Main.java"));
            System.out.println(
                            ConsoleStyling.color("File: ", ConsoleStyling.Color.GREEN, true) +
                            ConsoleStyling.color("Main.java", ConsoleStyling.Color.ORANGE, true) +
                            ConsoleStyling.color(" created successfully", ConsoleStyling.Color.GREEN, true));
        } catch (IOException e) {
            System.err.println("Failed to create file: " + e.getMessage());
        }

        try {
            FileWriter writer = new FileWriter(mainPath + File.separator + "Main.java");
            writer.write("package " + "PRO." + pkgName + ";\n\n");
            writer.write("public class Main {\n");
            writer.write("\tpublic static void main(String[] args) {\n");
            writer.write("\t}\n");
            writer.write("}\n");
            writer.close();

            System.out.println(
                            ConsoleStyling.color("Content written to: ", ConsoleStyling.Color.GREEN, true) +
                            ConsoleStyling.color("Main.java", ConsoleStyling.Color.ORANGE, true) +
                            ConsoleStyling.color(" successfully", ConsoleStyling.Color.GREEN, true));
        } catch (IOException e) {
            System.err.println("Failed to write to the file: " + e.getMessage());
        }
        //endregion

        //region Create Exercise Directories & Files
        int count = 1;
        String ex;

        for(String[] exercises : exerciseDescriptions){
            ex = "Exercise" + count;

            Path dirPath = Paths.get("src" + File.separator + "PRO" + File.separator + pkgName + File.separator + ex);
            createDir(dirPath);

            Path filePath = Paths.get(dirPath + File.separator + ex + ".java");
            createFile(filePath);

            writeExerciseToFile(filePath, "PRO." + pkgName + "." + ex, ex, count);

            count++;
        }
        //endregion

        System.out.println(ConsoleStyling.color("Lesson Package Sucessfully Created!", ConsoleStyling.Color.WHITE, true));
        Platform.exit();
    }
    private static void writeExerciseToFile(Path path, String pkg, String ex, int exNr){
        try{
            FileWriter writer = new FileWriter(path.toString());

            // Write Class Header
            writer.write("package " + pkg + ";\n");
            writer.write("public class " + ex + "{\n");


            // Create Top of Box
            String exerciseTitle = "Exercise " + exNr;
            writer.write("/*\n");
            writer.write("    ┌" + "─".repeat(100 + 4 + 4) + "┐\n");
            writer.write("    │" + " ".repeat(100 + 4 + 4) + "│\n");
            writer.write("    │    " + exerciseTitle + " ".repeat(100 - exerciseTitle.length()) + "    │\n");
            writer.write("    │" + " ".repeat(100 + 4 + 4) + "│\n");

            // Write each line of text
            for(String s : exerciseDescriptions.get(exNr - 1)){
                writer.write("    │    " + s + " ".repeat(100 - s.length()) + "    │" + "\n");
            }

            // Create Bottom of box
            writer.write("    │" + " ".repeat(100 + 4 + 4) + "│\n");
            writer.write("    └" + "─".repeat(100 + 4 + 4) + "┘\n");
            writer.write("*/\n");
            writer.write("\n");
            writer.write("    public static void print(){\n");
            writer.write("\n");
            writer.write("    }\n");
            writer.write("\n\n\n");


            // Write class footer, and close the writer
            writer.write("}\n");
            writer.close();
            System.out.println(
                        ConsoleStyling.color("Content written to: ", ConsoleStyling.Color.GREEN, true) +
                        ConsoleStyling.color(path.getFileName().toString(), ConsoleStyling.Color.ORANGE, true) +
                        ConsoleStyling.color(" successfully", ConsoleStyling.Color.GREEN, true));
        }
        catch (IOException e){
            System.err.println("Failed to write to the file: " + e.getMessage());
        }
    }
    private static void createFile(Path path){
        try {
            Files.createFile(path);
            System.out.println(
                        ConsoleStyling.color("File: ", ConsoleStyling.Color.GREEN, true) +
                        ConsoleStyling.color(path.getFileName().toString(), ConsoleStyling.Color.ORANGE, true) +
                        ConsoleStyling.color(" created successfully", ConsoleStyling.Color.GREEN, true));
        } catch (IOException e) {
            System.err.println("Failed to create file: " + e.getMessage());
        }
    }
    private static void createDir(Path path){
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                System.out.println(
                            ConsoleStyling.color("Directory: ", ConsoleStyling.Color.GREEN, true) +
                            ConsoleStyling.color(path.getFileName().toString(), ConsoleStyling.Color.ORANGE, true) +
                            ConsoleStyling.color(" created successfully", ConsoleStyling.Color.GREEN, true));
            } catch (IOException e) {
                System.err.println("Failed to create directory: " + e.getMessage());
            }
        } else {
            System.out.println("Directory already exists.");
        }
    }
    //endregion
}