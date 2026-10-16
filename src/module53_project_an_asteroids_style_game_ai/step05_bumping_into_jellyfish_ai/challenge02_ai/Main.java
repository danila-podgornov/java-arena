// AI-Generated
package module53_project_an_asteroids_style_game_ai.step05_bumping_into_jellyfish_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private Map<KeyCode, Boolean> held = new HashMap<>();

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        pane.getChildren().add(new Rectangle(360, 240, Color.MIDNIGHTBLUE));

        Sub sub = new Sub(60, 120);
        pane.getChildren().add(sub.getShape());
        List<Jellyfish> jellyfish = new ArrayList<>();
        jellyfish.add(new Jellyfish(150, 120, 180));
        jellyfish.add(new Jellyfish(300, 40, 90));
        jellyfish.forEach(j -> pane.getChildren().add(j.getShape()));

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> held.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> held.put(event.getCode(), false));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (held.getOrDefault(KeyCode.LEFT, false)) {
                    sub.turn(-4);
                }
                if (held.getOrDefault(KeyCode.RIGHT, false)) {
                    sub.turn(4);
                }
                if (held.getOrDefault(KeyCode.UP, false)) {
                    sub.accelerate(0.125);
                }
                sub.move();
                jellyfish.forEach(j -> j.move());
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Bump");
        stage.show();
    }

    /**
     * Make the bump count. Two files need a change:
     * <ol>
     * <li>In {@code Mover.java}, {@code collides} returns {@code false} for now. Make it return whether this Mover's shape and the other's overlap, with {@code Shape.intersect}.
     * <li>In {@code Main.java}, in {@code handle}, after everything has moved, go through the jellyfish in the list's order. For the first one that the submarine collides with: fill the submarine with {@code Color.RED}, print {@code Bump!}, stop the timer, and leave the loop.
     * </ol>
     * <p>The submarine starts at (60, 120), a jellyfish at (150, 120) drifts toward it, and another at (300, 40) drifts down. The test runs 150 frames.
     * {@code Bump!}
     * Hints
     * 1. {@code Shape.intersect} gives the overlap of the two shapes, and an empty overlap has bounds of width -1. In {@code handle}, after the moves, check the submarine against each jellyfish.
     * 2. In Mover: {@code return Shape.intersect(shape, other.getShape()).getBoundsInLocal().getWidth() != -1;}. In {@code handle}, after {@code jellyfish.forEach(j -> j.move());}: {@code for (Jellyfish j : jellyfish) { if (sub.collides(j)) { ... } }}, where the braces hold {@code sub.getShape().setFill(Color.RED);}, the print, {@code stop();} and {@code break;}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
