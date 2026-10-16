// AI-Generated
package module53_project_an_asteroids_style_game_ai.step05_bumping_into_jellyfish_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

        Sub sub = new Sub(180, 120);
        pane.getChildren().add(sub.getShape());
        List<Jellyfish> jellyfish = new ArrayList<>();
        // five jellyfish

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
        stage.setTitle("Swarm");
        stage.show();
    }

    /**
     * A swarm from a seeded Random. Add to {@code Main} a field {@code random}, a {@code new Random(14)}. The starter code has an empty list of jellyfish, which the game loop moves. Where the comment is, make five jellyfish with a loop. For each one, take three numbers from {@code random}, in this order: its x, {@code random.nextInt(360)}, its y, {@code random.nextInt(80)}, and its heading, {@code random.nextInt(360)}. Make the jellyfish with them, add it to the list and add its shape to the pane.
     * <p>The first test shows the window before any frame runs.
     * Hints
     * 1. The order of the calls matters: with a seed, {@code random} gives the same numbers every time, in order, so x, y and heading must be taken in exactly that order, in separate statements or in that order in the arguments.
     * 2. {@code for (int i = 0; i < 5; i++) { Jellyfish j = new Jellyfish(random.nextInt(360), random.nextInt(80), random.nextInt(360)); jellyfish.add(j); pane.getChildren().add(j.getShape()); }}
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
