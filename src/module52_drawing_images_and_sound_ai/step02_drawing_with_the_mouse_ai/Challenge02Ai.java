// AI-Generated
package module52_drawing_images_and_sound_ai.step02_drawing_with_the_mouse_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(240, 100);
        GraphicsContext pen = canvas.getGraphicsContext2D();

        stage.setScene(new Scene(new VBox(new Label("Sign below"), canvas)));
        stage.setTitle("Sign here");
        stage.show();
    }

    /**
     * A delivery app asks for a signature. Under the label {@code Sign below}, in a VBox with no spacing, a canvas of 240 x 100 pixels takes it: pressing the mouse starts a line, and each drag draws a line from the point before to the new point, in dark blue ({@code Color.DARKBLUE}) and 2 pixels wide. Releasing draws nothing. Nothing else is drawn. The window after the events below is drawn under them.
     * Hints
     * 1. Keep the last point in two instance variables, {@code private double lastX;} and {@code private double lastY;}. The pressed handler only stores the point.
     * 2. The dragged handler draws {@code pen.strokeLine(this.lastX, this.lastY, event.getX(), event.getY());} and then stores the new point. Set the stroke color and the width once, in {@code start}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
