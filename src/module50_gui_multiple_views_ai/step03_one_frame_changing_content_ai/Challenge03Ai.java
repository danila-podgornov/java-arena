// AI-Generated
package module50_gui_multiple_views_ai.step03_one_frame_changing_content_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label hall = new Label("Great hall");
        Label tower = new Label("Tower");
        Button next = new Button("Next");
        BorderPane frame = new BorderPane(hall);
        frame.setTop(next);
        next.setOnAction(event -> {
            if (frame.getCenter() == hall) {
                frame.setCenter(tower);
            } else {
                frame.setCenter(hall);
            }
        });

        next.fire();
        System.out.println(frame.getCenter() == tower);
        System.out.println(frame.getChildren().size() + " " + (hall.getParent() == null));
        next.fire();
        next.fire();
        System.out.println(frame.getCenter() == hall);

        stage.setScene(new Scene(frame));
        stage.setTitle("Guide");
        stage.show();
    }

    /**
     * A guide with two pages and a {@code Next} button that switches between them. The program clicks the button itself with {@code fire()}, and {@code getParent()} returns the pane a node is in, or {@code null} when it isn't in one. What does it print?
     * Hints
     * 1. {@code new BorderPane(hall)} puts {@code hall} in the center. Each {@code fire()} swaps the center: hall, then tower, then hall, then tower.
     * 2. The BorderPane's children are the nodes in its regions: the button on top and the page in the center. The page that was taken out isn't in the pane any more, so it has no parent.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
