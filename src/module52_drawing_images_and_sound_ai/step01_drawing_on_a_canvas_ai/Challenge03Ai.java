// AI-Generated
package module52_drawing_images_and_sound_ai.step01_drawing_on_a_canvas_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(300, 60);
        GraphicsContext pen = canvas.getGraphicsContext2D();

        stage.setScene(new Scene(new VBox(canvas)));
        stage.setTitle("Color card");
        stage.show();
    }

    /**
     * A paint shop prints cards of color samples. The file {@code colors.txt} holds one web color code on each line, such as {@code #e63946}. Show them on a canvas 300 pixels wide and 60 high: for the color on line {@code i} of the file (counting from 0), a filled square 40 x 40 with its top left corner at x {@code 10 + 50 * i} and y 10, in the color {@code Color.web(code)}. Under the canvas, in a VBox with no spacing, a label says how many colors there are: {@code Colors: 3}. The window's title is {@code Color card}.
     * <p>For the file below, the window should look like the drawing under it.
     * Hints
     * 1. Read the lines with {@code Files.readAllLines(Paths.get("colors.txt"))} (and add {@code throws Exception} to {@code start}). A loop with an index {@code i} over the lines gives each square its place, {@code 10 + 50 * i}.
     * 2. In the loop: {@code pen.setFill(Color.web(codes.get(i)));} and then {@code pen.fillRect(10 + 50 * i, 10, 40, 40);}. After it, make the label and put both in the VBox: {@code new VBox(canvas, count)}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
