// AI-Generated
package module53_project_an_asteroids_style_game_ai.step01_the_sea_and_the_submarine_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);
        pane.getChildren().add(new Rectangle(360, 240, Color.MIDNIGHTBLUE));

        // the jellyfish

        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(180);
        sub.setTranslateY(180);
        sub.setRotate(-90);
        pane.getChildren().add(sub);

        stage.setScene(new Scene(pane));
        stage.setTitle("Swarm");
        stage.show();
    }

    /**
     * A swarm of jellyfish in a row. Using a loop, add four jellyfish to the pane, after the water: jellyfish {@code i} (counting from 0) is a new {@code Polygon(-10, 0, -6, -8, 0, -10, 6, -8, 10, 0, 7, 10, 3, 2, 0, 10, -3, 2, -7, 10)} filled with {@code Color.ORCHID}, moved to x {@code 60 + 80 * i} and y 50, and turned {@code 30 * i} degrees. After the loop, the starter code adds the submarine, at (180, 180) and pointing up.
     * <p>The window it should show is drawn below.
     * Hints
     * 1. Make the polygon inside the loop, so each round has a new one: a node can be in a pane only once.
     * 2. In the loop: {@code jellyfish.setTranslateX(60 + 80 * i);}, {@code jellyfish.setTranslateY(50);} and {@code jellyfish.setRotate(30 * i);}, then {@code pane.getChildren().add(jellyfish);}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
