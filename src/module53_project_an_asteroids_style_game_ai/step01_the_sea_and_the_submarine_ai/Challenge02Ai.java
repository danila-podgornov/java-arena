// AI-Generated
package module53_project_an_asteroids_style_game_ai.step01_the_sea_and_the_submarine_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(360, 240);

        Rectangle water = new Rectangle(360, 240, Color.MIDNIGHTBLUE);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.setTranslateX(180);
        sub.setTranslateY(120);
        pane.getChildren().addAll(water, sub);

        stage.setScene(new Scene(pane));
        stage.setTitle("Deep dive");
        stage.show();
    }

    /**
     * Add a jellyfish and a bubble to the sea. The starter code has the pane, the water and the submarine. After the submarine, add to the pane's children, in this order:
     * <ol>
     * <li>a jellyfish: {@code new Polygon(-10, 0, -6, -8, 0, -10, 6, -8, 10, 0, 7, 10, 3, 2, 0, 10, -3, 2, -7, 10)} (a round top and three tentacles), filled with {@code Color.ORCHID}, moved to (270, 70) and turned 15 degrees
     * <li>a bubble: {@code new Circle(5, Color.LIGHTCYAN)}, moved with {@code setTranslateX} and {@code setTranslateY} to (60, 180)
     * </ol>
     * <p>The window it should show is drawn below.
     * Hints
     * 1. Make the jellyfish as the submarine is made: {@code new Polygon(...)} with the corners of the task, then {@code setFill}, {@code setTranslateX}, {@code setTranslateY} and {@code setRotate(15)}.
     * 2. Add the shapes with {@code pane.getChildren().add(jellyfish);} and then {@code pane.getChildren().add(bubble);}, after the line that adds the water and the submarine.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
