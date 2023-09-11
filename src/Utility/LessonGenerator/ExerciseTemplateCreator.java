package Utility.LessonGenerator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExerciseTemplateCreator extends Application{

    static VBox vbxScroll;

    static ArrayList<String[]> exerciseDescriptions = new ArrayList<>();
    static int currentExercisePage;
    @Override
    public void start(Stage primaryStage) {

        initGUI(primaryStage);

    }

    private static void initGUI(Stage primaryStage){
        // Create Package Name
        Label lblPkName = new Label("Package Name: ");
        TextField txfPackageName = new TextField();
        txfPackageName.setPrefSize(100, 20);
        txfPackageName.setMaxSize(250, 20);

        // Create Navigation bar
        Button btnPrevious = new Button("Previous");
        btnPrevious.setOnAction(e -> previousPage());
        btnPrevious.setAlignment(Pos.BASELINE_LEFT);

        Label lblExercise = new Label("Exercise " + currentExercisePage);
        lblExercise.setAlignment(Pos.BASELINE_CENTER);

        Button btnNext = new Button("Next");
        btnNext.setOnAction(e -> nextPage());
        btnNext.setAlignment(Pos.BASELINE_RIGHT);


        HBox hbxNavigation = new HBox();
        hbxNavigation.setAlignment(Pos.BASELINE_CENTER);
        hbxNavigation.setMinSize(500, 20);
        hbxNavigation.setPrefSize(500, 20);

        // Create empty regions (panes) for left and right alignment
        Pane leftSpacer = new Pane();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS); // Expand to fill available space
        Pane rightSpacer = new Pane();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS); // Expand to fill available space



        hbxNavigation.getChildren().addAll(btnPrevious,leftSpacer, lblExercise,rightSpacer, btnNext);
        //endregion


        //region Create DescriptionField
        TextArea txaDescription = new TextArea("bop");
        txaDescription.setPrefSize(600, 450);
        txaDescription.setMinSize(600, 450);
        txaDescription.setMaxSize(600, 450);
        //endregion


        //region Create Button
        Button btnConfirm = new Button("Confirm");
        btnConfirm.setPrefSize(150, 50);
        btnConfirm.setOnAction(e -> generateLesson());
        //endregion

        //region Create Main Vbox
        VBox vbxMain = new VBox(10);
        vbxMain.setAlignment(Pos.TOP_CENTER);
        vbxMain.getChildren().addAll(lblPkName, txfPackageName, hbxNavigation, txaDescription);
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
        //save the previous textArea line for line into the arraylist as an array of strings in order
        //dont forget to also do for button
    }
    private static void previousPage(){

    }

    private static void generateLesson() {
//            try {
//
//
//                String filePath = "src/Utility/LessonGenerator/ExerciseTemplate_Output.java";
//
//                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
//
//                writer.write("/**");
//                writer.newLine();
//                writer.write(" * Author: " + author);
//                writer.newLine();
//                writer.write(" * Date: " + date);
//                writer.newLine();
//                writer.write(" * Description: " + description);
//                writer.newLine();
//                writer.write(" */");
//                writer.newLine();
//
//                writer.close();
//                System.out.println("Code comment added to " + filePath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }


    /*

    Create the header of the box
    Then input all text.
    Allign text left.
    Auto generate a Header (Exercise X),
    then do a blank line
    do the ²|" lines on the left, 4 spaces before, 4 spaces after
    Then find longest line, move over 4 spaces, and add a "|" to the right
    Make the "|" on other lines, at same place
    Make bottom of box






     */





}





//region ASCII
    /*
        Single Lines:
        Horizontal: ─
        Vertical: │

    Double Lines:
        Horizontal: ═
        Vertical: ║

    Corners:
        Top Left: ┌
        Top Right: ┐
        Bottom Left: └
        Bottom Right: ┘

    T-Junctions:
        T-Top: ┬
        T-Bottom: ┴
        T-Left: ├
        T-Right: ┤

    Cross:
        Cross: ┼

    Dotted Lines:
        Dotted Horizontal: ·
        Dotted Vertical: :

    Diagonal Lines:
        Forward Slash (/): /
        Backslash (): \
     */
//endregion

/*
    Preview of output:
    ┌─────────────────────────────────────────────────────────────────────────────────┐
    │                                                                                 |
    |    Exercise 1                                                                   |
    |                                                                                 |
    |    Write a recursive method that totals all the elements in a List<Integer>.    |
    |    Use the template from                                                        |
    |    Divide-Solve-Combine (Del, løs og kombiner).                                 |
    |                                                                                 |
    └─────────────────────────────────────────────────────────────────────────────────┘
*/