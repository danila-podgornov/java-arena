// AI-Generated
package module53_project_an_asteroids_style_game_ai.step02_steering_with_the_keys_ai;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {
    private Map<KeyCode, Boolean> held = new HashMap<>();

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(180);
        sub.setTranslateY(120);
        pane.getChildren().addAll(new Rectangle(360, 240, Color.MIDNIGHTBLUE), sub);

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> held.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> held.put(event.getCode(), false));

        stage.setScene(scene);
        stage.setTitle("Sonar");
        stage.show();
    }

    /**
     * The submarine's sonar charges while Space is held. Count the frames during which Space is held: in every frame, if Space is held, add 1 to a counter (a field). When Space is released, print {@code Sonar charged for N frames} with the counter, and set the counter back to 0. Other keys don't print anything. Keep the held keys in a {@code Map<KeyCode, Boolean>}.
     * <p>The test holds Space for 12 frames, lets go, runs 5 more frames, and then presses and releases Space at once (no frame runs while it's held).
     * <pre>{@code
     * Sonar charged for 12 frames
     * Sonar charged for 0 frames
     * }</pre>
     * Hints
     * 1. The counter must be a field, {@code private int charge = 0;}: a lambda can't change a local variable of {@code start}. The timer adds 1 to it in every frame where {@code held.getOrDefault(KeyCode.SPACE, false)} is true.
     * 2. In the released handler, after putting {@code false}, check {@code if (event.getCode() == KeyCode.SPACE)}: print the line, then set the counter to 0.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
