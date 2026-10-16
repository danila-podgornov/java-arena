// AI-Generated
package module52_drawing_images_and_sound_ai.step04_making_an_image_smaller_ai.challenge01_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image original = new Image("file:pic.png");

        stage.setScene(new Scene(new HBox(10, new ImageView(original))));
        stage.setTitle("Thumbnail");
        stage.show();
    }

    /**
     * Thumbnails a quarter of the size. Read {@code pic.png} and make a copy of it that keeps every fourth pixel in each direction: it is {@code width / 4} by {@code height / 4}, and its pixel (x, y) is the original's (4x, 4y). Show the original and the thumbnail side by side in an HBox with a spacing of 10, the original first. The window's title is {@code Thumbnail}. The first test gives the program the sunset {@code photo.png} as {@code pic.png}, and the window should look like the drawing below.
     * Hints
     * 1. The thumbnail is {@code new WritableImage(width, height)} with {@code width = (int) original.getWidth() / 4}, and the same for the height.
     * 2. Loop over the thumbnail's pixels, y outside and x inside, and copy {@code reader.getColor(4 * x, 4 * y)} with {@code writer.setColor(x, y, ...)}. Then add {@code new ImageView(thumbnail)} to the HBox after the original.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
