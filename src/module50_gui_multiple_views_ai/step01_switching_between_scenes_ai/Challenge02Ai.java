// AI-Generated
package module50_gui_multiple_views_ai.step01_switching_between_scenes_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label status = new Label("Wi-Fi is on");
        Button open = new Button("Settings");
        Scene home = new Scene(new VBox(status, open));

        Button off = new Button("Turn Wi-Fi off");
        Button back = new Button("Back");
        Scene settings = new Scene(new VBox(off, back));

        open.setOnAction(event -> {
            stage.setScene(settings);
            stage.setTitle("Settings");
        });
        off.setOnAction(event -> status.setText("Wi-Fi is off"));
        back.setOnAction(event -> {
            stage.setScene(home);
            stage.setTitle("Home");
        });

        stage.setScene(home);
        stage.setTitle("Home");
        System.out.println(stage.getTitle() + ": " + status.getText());
        open.fire();
        off.fire();
        System.out.println(stage.getTitle() + " " + (stage.getScene() == home));
        back.fire();
        System.out.println(stage.getTitle() + ": " + status.getText());
        stage.show();
    }

    /**
     * A phone has a home scene and a settings scene. The program clicks its own buttons with {@code fire()}, which runs a button's handler whether or not its scene is showing. What does it print?
     * Hints
     * 1. {@code open.fire()} shows the settings scene and sets the title to {@code Settings}, so the window no longer shows {@code home}.
     * 2. {@code off} changes the label in the home scene while the settings show. The label keeps its new text, and {@code back} shows the home scene with it.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
