// AI-Generated
package module53_project_an_asteroids_style_game_ai.step04_submarine_and_jellyfish_share_a_class_ai.challenge03_ai;

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

        Sub sub = new Sub(180, 200);
        Jellyfish first = new Jellyfish(40, 40, 0);
        Jellyfish second = new Jellyfish(180, 40, 90);
        Jellyfish third = new Jellyfish(320, 40, 180);
        pane.getChildren().addAll(sub.getShape(), first.getShape(), second.getShape(), third.getShape());

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
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Everything moves");
        stage.show();
    }

    /**
     * Everything that moves, in one list. The starter code makes a submarine and three jellyfish and adds their shapes to the pane, but nothing moves yet. After the line that adds the shapes, make a {@code List<Mover>} called {@code movers} and add the submarine and the three jellyfish to it, in that order. In {@code handle}, after the keys, move every Mover of the list with one for-each loop.
     * <p>The test holds Up for 8 frames and then runs 50 frames more.
     * Hints
     * 1. A Sub is a Mover and a Jellyfish is a Mover, so one {@code List<Mover> movers = new ArrayList<>();} can hold them all: {@code movers.add(sub);} and so on.
     * 2. In {@code handle}, after the three key checks: {@code for (Mover mover : movers) { mover.move(); }}. Each object runs its own {@code move}: the jellyfish spin, the submarine doesn't.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
