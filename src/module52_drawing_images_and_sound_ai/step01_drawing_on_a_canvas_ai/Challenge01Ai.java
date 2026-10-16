// AI-Generated
package module52_drawing_images_and_sound_ai.step01_drawing_on_a_canvas_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(120, 80);
        GraphicsContext pen = canvas.___();
        pen.setFill(Color.DARKGREEN);
        pen.___(0, 0, 120, 80);
        pen.setFill(Color.WHITE);
        pen.fillRect(30, 0, 20, 80);
        pen.setFill(Color.BLACK);
        pen.fillOval(___, ___, 30, 30);

        stage.setScene(new Scene(new Pane(canvas)));
        stage.setTitle("Hiking club");
        stage.show();
    }

    /**
     * A hiking club's flag, 120 pixels wide and 80 high. Fill in the blanks so that it draws, in this order: a dark green background ({@code Color.DARKGREEN}) over the whole canvas, a white stripe 20 pixels wide from x 30 down the whole height, and a black circle 30 pixels across whose center is at (90, 40). The window it should show is drawn below.
     * Hints
     * 1. The canvas's GraphicsContext comes from {@code canvas.getGraphicsContext2D()}, and a filled rectangle is {@code fillRect(x, y, width, height)}.
     * 2. {@code fillOval} takes the top left corner of the square around the circle. The circle is 30 across, so its radius is 15: the corner is at (90 - 15, 40 - 15).
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
