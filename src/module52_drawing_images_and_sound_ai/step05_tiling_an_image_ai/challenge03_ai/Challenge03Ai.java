// AI-Generated
package module52_drawing_images_and_sound_ai.step05_tiling_an_image_ai.challenge03_ai;

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
        Image picture = new Image("file:pic.png");

        stage.setScene(new Scene(new Pane(new ImageView(picture))));
        stage.setTitle("Border");
        stage.show();
    }

    /**
     * A border for a page: {@code pic.png} repeated 4 times across, in one row, with every second tile (the second and the fourth) mirrored left to right. So the result is 4 times as wide as the picture and as high as it. In a mirrored tile, the tile's pixel (x, y) shows the picture's pixel (width - 1 - x, y); the other tiles show the picture as it is. Show the result in an ImageView inside a Pane. The window's title is {@code Border}. The first test gives the program {@code landscape.png} as {@code pic.png}, and the window should look like the drawing below.
     * Hints
     * 1. The result is {@code new WritableImage(4 * width, height)}. For pixel (x, y), the column in the tile is {@code x % width}, and the tile's number is {@code x / width}: 0, 1, 2 or 3.
     * 2. When the tile's number is odd ({@code x / width % 2 == 1}), read the column {@code width - 1 - x % width} instead. The row is {@code y} in every tile.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
