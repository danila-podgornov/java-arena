// AI-Generated
package module52_drawing_images_and_sound_ai.step06_color_filters_ai.challenge01_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:pic.png");

        stage.setScene(new Scene(new HBox(10, new ImageView(picture))));
        stage.setTitle("Gray");
        stage.show();
    }

    /**
     * A black-and-white filter. Show {@code pic.png} and a gray copy of it side by side in an HBox with a spacing of 10, the original first. In the gray copy, each pixel's red, green and blue are all the <b>average</b> of the original pixel's three amounts: take each amount as a whole number from 0 to 255 (times 255, rounded with {@code Math.round}), add them and divide by 3 with whole-number division. The window's title is {@code Gray}. The first test gives the program the sunset {@code photo.png} as {@code pic.png}, and the window should look like the drawing below.
     * Hints
     * 1. Make a WritableImage of the same size, and in the two loops read each pixel's Color with {@code reader.getColor(x, y)}.
     * 2. {@code int red = (int) Math.round(color.getRed() * 255);}, the same for green and blue, then {@code int average = (red + green + blue) / 3;} and {@code writer.setColor(x, y, Color.rgb(average, average, average));}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
