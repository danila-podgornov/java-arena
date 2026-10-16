// AI-Generated
package module53_project_an_asteroids_style_game_ai.step08_points_new_jellyfish_and_the_end_of_the_dive_ai.challenge02_ai;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 360;
    public static final int HEIGHT = 240;

    private Map<KeyCode, Boolean> held = new HashMap<>();
    private Random random = new Random(16);
    private List<Jellyfish> jellyfish = new ArrayList<>();
    private List<Bubble> bubbles = new ArrayList<>();
    private int points = 0;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        pane.getChildren().add(new Rectangle(WIDTH, HEIGHT, Color.MIDNIGHTBLUE));
        Text score = new Text(12, 24, "Score: 0");
        score.setFill(Color.WHITE);
        pane.getChildren().add(score);

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
                        if (b.isAlive() && j.isAlive() && b.collides(j)) {
                            b.setAlive(false);
                            j.setAlive(false);
                            points += 10;
                            score.setText("Score: " + points);
                            System.out.println("Score: " + points);
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
        stage.setTitle("Deep dive");
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
     * New jellyfish from the surface. The starter code is the game with points. In {@code handle}, right after the lines that remove what popped, add the new jellyfish:
     * <ul>
     * <li>if {@code random.nextDouble()} is less than 0.02, make a jellyfish at x {@code random.nextInt(WIDTH)}, y 0, with the heading {@code random.nextInt(360)} (take the numbers in that order: the chance, x, heading)
     * <li>add it to the list and its shape to the pane, but only if it doesn't collide with the submarine
     * </ul>
     * <p>Use the field {@code random} that placed the first jellyfish. The test runs the game of the lesson's example.
     * <pre>{@code
     * Score: 10
     * Score: 20
     * Bump!
     * }</pre>
     * Hints
     * 1. {@code if (random.nextDouble() < 0.02) { ... }}, and inside it {@code Jellyfish newcomer = new Jellyfish(random.nextInt(WIDTH), 0, random.nextInt(360));}.
     * 2. Then {@code if (!newcomer.collides(sub)) { jellyfish.add(newcomer); pane.getChildren().add(newcomer.getShape()); }}. The order of the random calls matters, since every call takes the next number.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
