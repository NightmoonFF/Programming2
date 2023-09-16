package Utility.LessonGenerator;

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
        //endregion

        //region Create Button
        Button btnConfirm = new Button("Confirm");
        btnConfirm.setPrefSize(150, 50);
        btnConfirm.setOnAction(e -> createPackage(txfPackageName.getText()));
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

            for (int i = 0; i < lines.length; i++) {
                storedLines[i] = lines[i];
            }

            if (exerciseDescriptions.size() > currentExercisePage){
                exerciseDescriptions.set(currentExercisePage, storedLines);
            } else{
                exerciseDescriptions.add(currentExercisePage, storedLines);
            }
        }
    }
    public static void createPackage(String pkgName){

        saveExerciseToArray();

        String directoryPath = "src" + File.separator + pkgName; // Specify the directory path
        Path directory = Paths.get(directoryPath); // Create a Path object for the directory

        //region Create Directory
        if (!Files.exists(directory)) {
            try {
                // Attempt to create the directory
                Files.createDirectory(directory);
                System.out.println("Directory created successfully.");
            } catch (IOException e) {
                System.err.println("Failed to create directory: " + e.getMessage());
            }
        } else {
            System.out.println("Directory already exists.");
        }
        //endregion

        //region Create AppClass
        try {
            Files.createFile(Paths.get(directory + File.separator + "App.java"));
            System.out.println("App Class created successfully.");
        } catch (IOException e) {
            System.err.println("Failed to create file: " + e.getMessage());
        }

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(directory + File.separator + "App.java");
            // Write content to the file
            writer.write("package " + pkgName + ";\n\n");
            writer.write("public class App {\n");
            writer.write("    public static void main(String[] args) {\n");
            writer.write("        new Exercises().dispatch();");
            writer.write("    }\n");
            writer.write("}\n");
            // Close the FileWriter
            writer.close();

            System.out.println("Content written to App.java successfully.");
        } catch (IOException e) {
            System.err.println("Failed to write to the file: " + e.getMessage());
        }
        //endregion

        //region Create ExerciseClass
        try {
            Files.createFile(Paths.get(directory + File.separator + "Exercises.java"));
            System.out.println("Exercises Class created successfully.");
        } catch (IOException e) {
            System.err.println("Failed to create file: " + e.getMessage());
        }

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(directory + File.separator + "Exercises.java");
            // Write content to the file
            writer.write("package " + pkgName + ";\n\n");
            writer.write("public class App {\n");
            // Close the FileWriter
            writer.close();
            System.out.println("Content written to Exercises.java successfully.");
        } catch (IOException e) {
            System.err.println("Failed to write to the file: " + e.getMessage());
        }
        //endregion
        printExercises(pkgName);
        Platform.exit();

    }
    public static void printExercises(String pkgName){

        String directoryPath = "src" + File.separator + pkgName;

        try{
            FileWriter writer = new FileWriter(directoryPath + File.separator + "Exercises.java");

            //TODO: write the beginning - import, package, class, etc

            int count = 1;
            //for each exercise
            for(String[] exercises : exerciseDescriptions){

                // Create Top of Box
                String exerciseTitle = "Exercise " + count;
                writer.write("/*\n");
                writer.write("    ┌" + "─".repeat(72 + 4 + 4) + "┐\n");
                writer.write("    │" + " ".repeat(72 + 4 + 4) + "│\n");
                writer.write("    │" + exerciseTitle + " ".repeat(72 - exerciseTitle.length()) + "    │\n");
                writer.write("    │" + " ".repeat(72 + 4 + 4) + "│\n");

                //TODO: make a line of text not able to exceed 72. Maybe make font monospace to get accurage from textbox
                //for each line of text
                for(String s : exercises){
                    writer.write("    │    " + s + " ".repeat(72 - s.length()) + "    │" + "\n");
                }
                writer.write("*/\n");

                //TODO: write bottom of box
                //TODO: write region
                //TODO: write method printExerciseX()
                //TODO: write endregion

                count++;
            }
            writer.close();
            System.out.println("Content of each exercise written to Exercises.java successfully.");
        }
        catch (IOException e){
            System.err.println("Failed to write to the file: " + e.getMessage());
        }
    }

}

//set a max line length, then make the 4 spaces, then line --72 max?

// Preview of output:

/*
    │    opejgpaepå...jopejgpaepå...jopejgpaepå...jopejgpaepå...jopejgpaepå...jopejgpaepå opgjggg    │
    ┌────────────────────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                                │
    │    Exercise 1                                                                                  │
    │                                                                                                │
    │    Write a recursive method that totals all the elements in a List<Integer>.                   │
    │    Use the template from                                                                       │
    │    Divide-Solve-Combine (Del, løs og kombiner).                                                │
    │                                                                                                │
    └────────────────────────────────────────────────────────────────────────────────────────────────┘
*/