// AI-Generated
package module53_project_an_asteroids_style_game_ai.step04_submarine_and_jellyfish_share_a_class_ai.challenge01_ai;

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
        jellyfish.add(new Jellyfish(60, 60, 30));
        jellyfish.add(new Jellyfish(300, 180, 200));
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
        stage.setTitle("Deep dive");
        stage.show();
    }

    /**
     * Write the class {@code Jellyfish}. The starter code calls {@code super(...)} with the jellyfish's polygon. Add to the constructor, after that: fill the shape with {@code Color.ORCHID}, turn it by {@code heading} degrees with {@code turn}, and accelerate it once by 0.5. Then override {@code move()} so that it first moves the jellyfish as a Mover does and then turns it 1 degree clockwise.
     * <p>{@code Main} makes a submarine at (180, 120) and two jellyfish, at (60, 60) heading 30 degrees and at (300, 180) heading 200 degrees, and moves them in every frame. The test runs 40 frames.
     * Hints
     * 1. Mover already has {@code getShape}, {@code turn} and {@code accelerate}, and a Jellyfish has them too: call them in the constructor after {@code super(...)}. For the turning, override {@code move} and let Mover's own {@code move} do the moving first.
     * 2. In the constructor: {@code getShape().setFill(Color.ORCHID);}, {@code turn(heading);} and {@code accelerate(0.5);}. The override: {@code @Override public void move() { super.move(); turn(1); }}. Without {@code super.}, {@code move()} would call itself forever.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
