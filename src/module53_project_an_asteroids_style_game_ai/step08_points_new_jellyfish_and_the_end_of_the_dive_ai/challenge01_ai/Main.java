// AI-Generated
package module53_project_an_asteroids_style_game_ai.step08_points_new_jellyfish_and_the_end_of_the_dive_ai.challenge01_ai;

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
     * Points. The starter code is the game of step 7, with bubbles that pop after 50 frames, and it prints {@code Pop!} for every hit. Make the hits count instead:
     * <ol>
     * <li>add a field {@code points}, 0 at the start, and a Text {@code score}: {@code new Text(12, 24, "Score: 0")}, filled with {@code Color.WHITE}, added to the pane right after the water
     * <li>a hit counts only when the bubble and the jellyfish are both still alive (check that before {@code collides}); then mark both as not alive as before, add 10 to {@code points}, set the Text to {@code Score: } and the points, and print the same text (in place of {@code Pop!})
     * </ol>
     * <p>The test is the one of step 7's first challenge.
     * <pre>{@code
     * Score: 10
     * Score: 20
     * }</pre>
     * Hints
     * 1. The field is {@code private int points = 0;}. In {@code start}, after the water: {@code Text score = new Text(12, 24, "Score: 0");}, {@code score.setFill(Color.WHITE);} and {@code pane.getChildren().add(score);}.
     * 2. The check becomes {@code if (b.isAlive() && j.isAlive() && b.collides(j))}, and inside it, after the two {@code setAlive(false)} lines: {@code points += 10;}, {@code score.setText("Score: " + points);} and the print.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
