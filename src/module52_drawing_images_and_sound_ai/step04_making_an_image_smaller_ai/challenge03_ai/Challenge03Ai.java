// AI-Generated
package module52_drawing_images_and_sound_ai.step04_making_an_image_smaller_ai.challenge03_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image original = new Image("file:pic.png");

        stage.setScene(new Scene(new Pane(new ImageView(original))));
        stage.setTitle("Picture in picture");
        stage.show();
    }

    /**
     * Picture in picture: a copy of {@code pic.png} with a third-size copy of it in its top right corner, 1 pixel in from the top and right edges. Start with a full copy, {@code new WritableImage(reader, width, height)}. Then write the third-size copy (every third pixel, as {@code Thumbnails.shrink} in the challenge before does with a factor of 3) over it: it is {@code width / 3} pixels wide and {@code height / 3} high (whole-number division), and its pixel (x, y), which is the original's (3x, 3y), goes to (x + width - width / 3 - 1, y + 1). The pixels around it stay the picture's own. Show only the result, in an ImageView inside a Pane. The window's title is {@code Picture in picture}. The first test gives the program {@code landscape.png} as {@code pic.png}, and the window should look like the drawing below.
     * Hints
     * 1. {@code new WritableImage(reader, width, height)} is a copy of the whole picture to start from, with {@code reader = original.getPixelReader()} and the size as ints.
     * 2. Loop over the third-size copy, {@code y < height / 3} and {@code x < width / 3}, and write {@code reader.getColor(3 * x, 3 * y)} at {@code (x + width - width / 3 - 1, y + 1)}. Show {@code new ImageView(result)}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
