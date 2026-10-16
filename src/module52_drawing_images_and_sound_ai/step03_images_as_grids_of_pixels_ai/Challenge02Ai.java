// AI-Generated
package module52_drawing_images_and_sound_ai.step03_images_as_grids_of_pixels_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> rows = Files.readAllLines(Paths.get("art.txt"));

        stage.setScene(new Scene(new Pane()));
        stage.setTitle("Pixel art");
        stage.show();
    }

    /**
     * A pixel-art editor saves its pictures as text. In the file {@code art.txt}, each line is a row of pixels and each character a pixel: {@code #} is black ({@code Color.BLACK}), {@code o} is orange ({@code Color.ORANGE}) and {@code .} is white ({@code Color.WHITE}). Every line is as long as the first one.
     * <p>Make a WritableImage as wide as a line and as high as the file has lines, give each pixel the color of its character, and show the image in an ImageView, inside a Pane. The window's title is {@code Pixel art}. For this file:
     * <pre>{@code
     * .......
     * ..##...
     * .#oo#.#
     * #oooo##
     * .#oo#.#
     * ..##...
     * }</pre>
     * <p>the window should look like the drawing below.
     * Hints
     * 1. The width is {@code rows.get(0).length()} and the height {@code rows.size()}. Make {@code new WritableImage(width, height)} and get its PixelWriter.
     * 2. Loop over y (the rows) and, inside, over x. The character is {@code rows.get(y).charAt(x)}; pick the color with {@code if} and {@code else if}, and set it with {@code writer.setColor(x, y, ...)}. At the end, the Pane holds {@code new ImageView(art)}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
