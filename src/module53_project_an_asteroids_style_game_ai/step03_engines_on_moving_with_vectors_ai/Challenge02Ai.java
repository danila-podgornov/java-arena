// AI-Generated
package module53_project_an_asteroids_style_game_ai.step03_engines_on_moving_with_vectors_ai;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {
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

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (held.getOrDefault(KeyCode.LEFT, false)) {
                    sub.setRotate(sub.getRotate() - 4);
                }
                if (held.getOrDefault(KeyCode.RIGHT, false)) {
                    sub.setRotate(sub.getRotate() + 4);
                }
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Engines");
        stage.show();
    }

    /**
     * Give the submarine its engine. The starter code turns it with Left and Right (4 degrees a frame). Add a field {@code velocity}, a {@code Point2D} that starts at (0, 0), and in every frame, after the turning:
     * <ol>
     * <li>if Up is held, add to the velocity a push of 0.125 in the direction of the submarine's rotate: {@code Math.cos} and {@code Math.sin} of {@code Math.toRadians(sub.getRotate())}, each times 0.125, added with {@code velocity.add(...)}
     * <li>then move the submarine by its velocity: add its x to the translate x and its y to the translate y
     * </ol>
     * <p>The test holds Up for 16 frames and then runs 24 frames more: the submarine reaches 2 pixels a frame and ends at (245, 120).
     * Hints
     * 1. The velocity must be a field, {@code private Point2D velocity = new Point2D(0, 0);}, since the timer's code changes it. Point2D is immutable: {@code velocity = velocity.add(...)} keeps the new point.
     * 2. In {@code handle}, after the turning: {@code if (held.getOrDefault(KeyCode.UP, false)) { double angle = Math.toRadians(sub.getRotate()); velocity = velocity.add(Math.cos(angle) * 0.125, Math.sin(angle) * 0.125); }}, then {@code sub.setTranslateX(sub.getTranslateX() + velocity.getX());} and the same for y.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
