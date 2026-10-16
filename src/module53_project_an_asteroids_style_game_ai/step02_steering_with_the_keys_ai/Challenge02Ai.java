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

public class Challenge02Ai extends Application {

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

        stage.setScene(scene);
        stage.setTitle("Depth");
        stage.show();
    }

    /**
     * The submarine dives and climbs. In the starter code, the submarine is at (180, 120). Keep the held keys in a {@code Map<KeyCode, Boolean>} and add a game loop: in every frame, while Up is held the submarine moves up 2 pixels (its translate y goes down by 2), but only if its y is more than 20; while Down is held it moves down 2 pixels, but only if its y is less than 220. Check Up first, then Down. It doesn't turn, and nothing is printed.
     * <p>The test holds Up for 30 frames, so the submarine ends at (180, 60).
     * Hints
     * 1. Keep the held keys in a map field, filled by a pressed and a released handler on the scene, and move the submarine in the timer's {@code handle}, which reads the map.
     * 2. The field is {@code private Map<KeyCode, Boolean> held = new HashMap<>();}; the handlers put {@code true} and {@code false} for {@code event.getCode()}. In {@code handle}: {@code if (held.getOrDefault(KeyCode.UP, false) && sub.getTranslateY() > 20) { sub.setTranslateY(sub.getTranslateY() - 2); }}, and the same for Down with {@code < 220} and {@code + 2}. Don't forget {@code .start()} after the timer.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
