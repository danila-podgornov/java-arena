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

public class Challenge01Ai extends Application {
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
        scene.___(event -> held.put(event.getCode(), false));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (held.___(KeyCode.LEFT, false)) {
                    sub.setRotate(sub.getRotate() - 4);
                }
                if (held.getOrDefault(KeyCode.RIGHT, false)) {
                    sub.setRotate(sub.getRotate() + 4);
                }
            }
        }.___();

        stage.setScene(scene);
        stage.setTitle("Steering");
        stage.show();
    }

    /**
     * Fill in the blanks so that releasing a key puts {@code false} in the map, {@code handle} asks the map whether Left is held, and the timer starts. The test holds Left for 15 frames, so the submarine ends turned -60 degrees.
     * Hints
     * 1. The scene's handler for a key that comes up is {@code setOnKeyReleased}. The map's method that gives a value for a missing key is {@code getOrDefault}.
     * 2. A timer does nothing until it's started: {@code new AnimationTimer() { ... }.start();}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
