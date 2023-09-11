package Utility.LessonGenerator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExerciseTemplateCreator extends Application{

    @Override
    public void start(Stage primaryStage) {

        initGUI(primaryStage);

    }

    private static void initGUI(Stage primaryStage){
        // Create Package Name
        Label lblPkName = new Label("Package Name: ");
        TextField txfPackageName = new TextField();

        // Create Exercise Amount
        Label lblAmount = new Label("# of Exercises: ");
        Spinner<Integer> spinner = new Spinner<>(1, 15, 1);

        // Create Button
        Button btnConfirm = new Button("Confirm");
        btnConfirm.setPrefSize(150, 50);
        btnConfirm.setOnAction(e -> generateLesson());

        // Create Vbox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(lblPkName, txfPackageName, lblAmount, spinner);

        // Create Border Pane
        BorderPane borderPane = new BorderPane();

        BorderPane.setAlignment(vbox, Pos.TOP_CENTER);
        BorderPane.setMargin(vbox, new Insets(12, 12, 12, 12));
        borderPane.setCenter(vbox);

        BorderPane.setAlignment(btnConfirm, Pos.BASELINE_CENTER);
        BorderPane.setMargin(btnConfirm, new Insets(12, 12, 12, 12));
        borderPane.setBottom(btnConfirm);

        // Create Scene
        Scene scene = new Scene(borderPane, 700, 700);

        primaryStage.setTitle("Create new Lesson");
        primaryStage.setScene(scene);
        primaryStage.show();
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