// AI-Generated
package module52_drawing_images_and_sound_ai.step03_images_as_grids_of_pixels_ai.challenge01_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:pic.png");
        PixelReader reader = picture.___();
        Label shown = new Label("Click a pixel");
        ImageView view = new ImageView(picture);
        view.setOnMouseClicked(event -> {
            int x = (int) event.getX();
            int y = (int) event.getY();
            Color color = reader.___(x, y);
            int red = (int) Math.round(color.___() * 255);
            int green = (int) Math.round(color.getGreen() * 255);
            int blue = (int) Math.round(color.getBlue() * ___);
            shown.setText("(" + x + ", " + y + "): " + red + " " + green + " " + blue);
        });

        stage.setScene(new Scene(new VBox(view, shown)));
        stage.setTitle("Eyedropper");
        stage.show();
    }

    /**
     * An eyedropper. The program reads {@code pic.png} and shows it in an image view, with a label under it that starts as {@code Click a pixel}. A click on a pixel sets the label to the pixel's place and its red, green and blue as whole numbers from 0 to 255: {@code (3, 3): 51 102 153}. Fill in the blanks. The challenge's picture is {@code tiny.png}, given to the program as {@code pic.png}:
     * <p>Image: tiny.png
     * Hints
     * 1. An image's pixels are read through its PixelReader, from {@code getPixelReader()}, and the reader's {@code getColor(x, y)} gives one pixel's Color.
     * 2. A Color's {@code getRed()} is between 0.0 and 1.0, so times 255 (and rounded) it's a whole number from 0 to 255. Blue works the same way.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
