// AI-Generated
package module53_project_an_asteroids_style_game_ai.step07_firing_bubbles_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 360;
    public static final int HEIGHT = 240;

    private Map<KeyCode, Boolean> held = new HashMap<>();
    private Random random = new Random(16);
    private List<Jellyfish> jellyfish = new ArrayList<>();
    private List<Bubble> bubbles = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(new Rectangle(WIDTH, HEIGHT, Color.MIDNIGHTBLUE));

        Sub sub = new Sub(WIDTH / 2, HEIGHT / 2);
        pane.getChildren().add(sub.getShape());
        for (int i = 0; i < 4; i++) {
            Jellyfish j = new Jellyfish(random.nextInt(WIDTH), random.nextInt(60), random.nextInt(360));
            jellyfish.add(j);
            pane.getChildren().add(j.getShape());
        }

        Scene scene = new Scene(pane);
        scene.setOnKeyPressed(event -> {
            held.put(event.getCode(), true);
            if (event.getCode() == KeyCode.SPACE && bubbles.size() < 4) {
                Bubble bubble = new Bubble(sub.getShape().getTranslateX(), sub.getShape().getTranslateY(), sub.getShape().getRotate());
                bubbles.add(bubble);
                pane.getChildren().add(bubble.getShape());
            }
        });
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
                bubbles.forEach(b -> b.move());

                for (Bubble b : bubbles) {
                    for (Jellyfish j : jellyfish) {
                        if (b.collides(j)) {
                            b.setAlive(false);
                            j.setAlive(false);
                            System.out.println("Pop!");
                        }
                    }
                }
                bubbles.stream()
                        .filter(b -> !b.isAlive())
                        .forEach(b -> pane.getChildren().remove(b.getShape()));
                jellyfish.stream()
                        .filter(j -> !j.isAlive())
                        .forEach(j -> pane.getChildren().remove(j.getShape()));
                bubbles = bubbles.stream()
                        .filter(b -> b.isAlive())
                        .collect(Collectors.toList());
                jellyfish = jellyfish.stream()
                        .filter(j -> j.isAlive())
                        .collect(Collectors.toList());

                for (Jellyfish j : jellyfish) {
                    if (sub.collides(j)) {
                        sub.getShape().setFill(Color.RED);
                        System.out.println("Bump!");
                        stop();
                        break;
                    }
                }
            }
        }.start();

        stage.setScene(scene);
        stage.setTitle("Rapid fire");
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
     * Rapid fire: holding Space fires a bubble every 15 frames. Move the firing from the pressed handler into the game loop. Add a field {@code reload}, 0 at the start. At the very beginning of {@code handle}, before the keys that turn and push:
     * <ol>
     * <li>if {@code reload} is more than 0, subtract 1 from it
     * <li>then, if Space is held, {@code reload} is 0 and fewer than 4 bubbles are out, fire a bubble as the handler did (from the submarine's place, in its heading, added to the list and the pane) and set {@code reload} to 15
     * </ol>
     * <p>The pressed handler then only puts {@code true} in the map. The test holds Space for 40 frames and runs 10 more: bubbles were fired in frames 1, 16 and 31.
     * Hints
     * 1. The pressed handler becomes {@code scene.setOnKeyPressed(event -> held.put(event.getCode(), true));}. The field is {@code private int reload = 0;}.
     * 2. At the start of {@code handle}: {@code if (reload > 0) { reload--; }}, then {@code if (held.getOrDefault(KeyCode.SPACE, false) && reload == 0 && bubbles.size() < 4) { ... reload = 15; }} with the three lines that make and add the bubble.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
