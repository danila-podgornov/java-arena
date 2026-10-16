// AI-Generated
package module52_drawing_images_and_sound_ai.step05_tiling_an_image_ai.challenge01_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:pic.png");
        PixelReader reader = picture.getPixelReader();
        int width = (int) picture.getWidth();
        int height = (int) picture.getHeight();

        WritableImage tiles = new WritableImage(2 * width, 2 * height);
        PixelWriter writer = tiles.getPixelWriter();
        for (int y = 0; y < 2 * height; y++) {
            for (int x = 0; x < ___; x++) {
                writer.setColor(x, y, reader.getColor(x ___ width, y % ___));
            }
        }

        stage.setScene(new Scene(new Pane(new ImageView(___))));
        stage.setTitle("Tiles");
        stage.show();
    }

    /**
     * Tile {@code pic.png} 2 times across and 2 times down: pixel (x, y) of the result is the picture's pixel (x % width, y % height). Fill in the blanks. The first test gives the program the heart of {@code icon.png} as {@code pic.png}, and the window should look like the drawing below.
     * Hints
     * 1. The result is twice as wide as the picture, so x goes up to {@code 2 * width}. The place in the tile is the remainder, {@code x % width}.
     * 2. Down, the tile is {@code height} pixels high, so it's {@code y % height}. The image view shows the new image, {@code tiles}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
