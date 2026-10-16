// AI-Generated
package module52_drawing_images_and_sound_ai.step06_color_filters_ai.challenge03_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:pic.png");

        stage.setScene(new Scene(new Pane(new ImageView(picture))));
        stage.setTitle("Filter preview");
        stage.show();
    }

    /**
     * A photo app previews its new warm filter: the left half of the picture stays as it is, and the right half is filtered, so you can compare the two. The result is exactly as big as {@code pic.png}. With {@code width} the picture's width, a pixel is in the right half when {@code x >= width / 2} (whole-number division). A pixel in the left half is the picture's pixel unchanged. For a pixel in the right half, {@code g} is the gray amount of JavaFX's {@code grayscale()} of the picture's pixel, as a whole number from 0 to 255 (the red of the gray color, times 255, rounded with {@code Math.round}), and the pixel becomes {@code Color.rgb(g, g * 3 / 4, g / 2)} (whole-number division).
     * <p>Show the result in an ImageView inside a Pane. The window's title is {@code Filter preview}. The first test gives the program {@code landscape.png} as {@code pic.png}, and the window should look like the drawing below.
     * Hints
     * 1. Make a WritableImage of the picture's size and go through every pixel with two loops. Read the picture's pixel (x, y) and decide with {@code if (x >= width / 2)} which half it is in.
     * 2. In the left half, write the color you read. In the right half, {@code color.grayscale()} is a gray Color, {@code (int) Math.round(color.grayscale().getRed() * 255)} is {@code g}, and the pixel is {@code Color.rgb(g, g * 3 / 4, g / 2)}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
