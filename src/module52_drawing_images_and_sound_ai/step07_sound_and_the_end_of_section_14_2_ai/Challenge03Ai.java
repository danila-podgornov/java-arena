// AI-Generated
package module52_drawing_images_and_sound_ai.step07_sound_and_the_end_of_section_14_2_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        WritableImage picture = new WritableImage(8, 8);
        ImageView view = new ImageView(picture);
        Label count = new Label("Black pixels: 0");

        stage.setScene(new Scene(new VBox(view, count)));
        stage.setTitle("Pixel editor");
        stage.show();
    }

    /**
     * A tiny pixel-art editor. Make a WritableImage of 8 x 8 pixels, all white ({@code Color.WHITE}) at first, and show it in an ImageView. A click on a pixel of the image view turns a white pixel black ({@code Color.BLACK}), and a black pixel white again. Under the image, a label counts the black pixels: {@code Black pixels: 0} at first, and {@code Black pixels: 3} after three pixels were turned black. The scene's root is a VBox with no spacing, holding the image view and then the label, and the window's title is {@code Pixel editor}. The window after the clicks below is drawn under them.
     * Hints
     * 1. A new WritableImage is transparent, so paint all 64 pixels white first, with two loops. In the image view's {@code setOnMouseClicked}, {@code (int) event.getX()} and {@code (int) event.getY()} are the pixel's column and row.
     * 2. {@code picture.getPixelReader().getColor(x, y).equals(Color.WHITE)} tells whether the pixel is white. Keep the count in an instance variable, add or take away one, and set the label's text.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
