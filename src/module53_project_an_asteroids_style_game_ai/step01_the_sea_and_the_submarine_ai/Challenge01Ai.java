// AI-Generated
package module53_project_an_asteroids_style_game_ai.step01_the_sea_and_the_submarine_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.___(360, 240);

        Rectangle water = new Rectangle(360, 240, Color.MIDNIGHTBLUE);
        Polygon sub = new Polygon(-15, -6, 9, -6, 15, 0, 9, 6, -15, 6);
        sub.setFill(Color.GOLD);
        sub.___(90);
        sub.setTranslateY(___);
        sub.___(___);

        pane.getChildren().addAll(water, sub);

        stage.setScene(new Scene(pane));
        stage.setTitle("Deep dive");
        stage.show();
    }

    /**
     * The submarine at (90, 60), pointing down. Fill in the blanks: the pane gets the preferred size 360 x 240, and the submarine is moved to (90, 60) and turned so that its nose points straight down.
     * Hints
     * 1. A pane's preferred size is set with {@code setPrefSize(width, height)}, and a shape is moved with {@code setTranslateX} and {@code setTranslateY}.
     * 2. The nose points right at 0 degrees. Turning clockwise (a positive angle) by a quarter turn points it down: {@code setRotate(90)}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
