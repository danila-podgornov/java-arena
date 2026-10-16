// AI-Generated
package module53_project_an_asteroids_style_game_ai.step07_firing_bubbles_ai.challenge01_ai;

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
                // remove what popped

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
        stage.setTitle("Bubbles");
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
     * In the starter code, bubbles and jellyfish are marked when they collide, but nothing is removed, so a popped jellyfish stays and pops again in every frame. Where the comment is, remove every bubble and every jellyfish that isn't alive: first their shapes from the pane, then the Movers from their lists, with streams, {@code filter} and {@code collect} as above. The test fires three bubbles and lets them fly.
     * <pre>{@code
     * Pop!
     * Pop!
     * }</pre>
     * Hints
     * 1. Two jobs for each list, in this order: take the shapes of the dead ones out of the pane, then keep only the living ones in the list. Streams with {@code filter} do both.
     * 2. For the bubbles: {@code bubbles.stream().filter(b -> !b.isAlive()).forEach(b -> pane.getChildren().remove(b.getShape()));} removes the shapes. Do the same for the jellyfish.
     * 3. Then keep the living ones: {@code bubbles = bubbles.stream().filter(b -> b.isAlive()).collect(Collectors.toList());}, and the same for {@code jellyfish}. Remove the shapes first: once a dead bubble has left the list, nothing knows about it any more.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
