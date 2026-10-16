// AI-Generated
package module50_gui_multiple_views_ai.step01_switching_between_scenes_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label book = new Label("The Glass Orchard, chapter 3 of 12");
        Button toSettings = new Button("Settings");
        Scene bookScene = new Scene(new VBox(10, book, toSettings));

        Label heading = new Label("Settings");
        Button back = new Button("Back");
        Scene settingsScene = new Scene(new VBox(10, heading, back));

        toSettings.setOnAction(event -> stage.___(settingsScene));
        back.setOnAction(event -> stage.setScene(___));

        stage.setScene(___);
        stage.setTitle("Reader");
        stage.show();
    }

    /**
     * An e-reader has two scenes, the book and the settings. Fill in the three blanks, so that {@code Settings} shows the settings scene, {@code Back} shows the book again, and the window starts with the book. The task card shows the window after a click on Settings.
     * Hints
     * 1. Look at what {@code start} does to the stage at its end, just before {@code setTitle}: the first blank calls that same method.
     * 2. The first blank is {@code setScene}. Back and the start of the program both show the scene with the book, {@code bookScene}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
