// AI-Generated
package module52_drawing_images_and_sound_ai.step01_drawing_on_a_canvas_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(120, 160);
        GraphicsContext pen = canvas.getGraphicsContext2D();

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("No entry");
        stage.show();
    }

    /**
     * A road sign: no entry. Draw it on the canvas of 120 x 160 pixels that the starter code makes, with these calls in this order:
     * <ol>
     * <li>a gray post ({@code Color.GRAY}): a filled rectangle 10 wide and 110 high, from (55, 50)
     * <li>the sign: a red ({@code Color.RED}) filled circle 100 pixels across, in the square from (10, 0)
     * <li>a white ({@code Color.WHITE}) filled bar 70 wide and 20 high, from (25, 40)
     * <li>the sign's edge: the outline of the same circle, in dark red ({@code Color.DARKRED}) and 3 pixels wide
     * </ol>
     * <p>The post starts in the middle of the sign, so the circle covers its top. Keep the window's title and the Pane. The window it should show is drawn below.
     * Hints
     * 1. Before each filled shape, {@code pen.setFill(...)} picks its color. The circle is {@code fillOval(10, 0, 100, 100)}.
     * 2. The edge uses the stroke color and width: {@code pen.setStroke(Color.DARKRED);}, {@code pen.setLineWidth(3);}, then {@code pen.strokeOval(10, 0, 100, 100);}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
