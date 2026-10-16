// AI-Generated
package module53_project_an_asteroids_style_game_ai.step06_around_the_edges_of_the_sea_ai.challenge02_ai;

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

        Sub sub = new Sub(180, 120);
        pane.getChildren().add(sub.getShape());
        List<Jellyfish> jellyfish = new ArrayList<>();
        jellyfish.add(new Jellyfish(60, 200, 60));
        jellyfish.add(new Jellyfish(300, 30, 250));
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
        stage.setTitle("Wrapping");
        stage.show();
    }

    public static double wrap(double value, double size) {
        double result = value % size;
        if (result < 0) {
            result = result + size;
        }
        return result;
    }

    /**
     * Make the sea wrap around. {@code Main} already has the method {@code wrap} of the challenge before. Add to {@code Main} two constants, {@code public static final int WIDTH = 360;} and {@code HEIGHT = 240}, and use them for the pane's preferred size and the water's size. Then change Mover's {@code move} so that the new x is wrapped into {@code Main.WIDTH} and the new y into {@code Main.HEIGHT} with {@code Main.wrap}.
     * <p>The test turns the submarine to point left, speeds it up for 24 frames and lets it run off the left edge: it comes back on the right and ends at (322.5, 120).
     * Hints
     * 1. In Main, right after <code>public class Main extends Application {</code>: {@code public static final int WIDTH = 360;} and {@code public static final int HEIGHT = 240;}. Then {@code pane.setPrefSize(WIDTH, HEIGHT);}.
     * 2. In Mover: {@code shape.setTranslateX(Main.wrap(shape.getTranslateX() + velocity.getX(), Main.WIDTH));}, and the same for y with {@code Main.HEIGHT}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
