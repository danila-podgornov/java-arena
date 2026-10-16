// AI-Generated
package module52_drawing_images_and_sound_ai.step03_images_as_grids_of_pixels_ai.challenge03_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:pic.png");
        ImageView view = new ImageView(picture);

        stage.setScene(new Scene(new VBox(view)));
        stage.setTitle("Photo frame");
        stage.show();
    }

    /**
     * A digital photo frame shows the picture {@code pic.png}. When the image can be read, the scene's root is a VBox with no spacing, holding an ImageView of it and, under it, a label with its size: {@code 32 x 24 pixels} (whole numbers). When it can't be read (the file is missing), the scene's root is only the label {@code No picture: pic.png is missing}, with no ImageView. The window's title is {@code Photo frame}.
     * <p>The first test gives the program {@code landscape.png} as {@code pic.png}, and the window should look like the drawing below. Another test gives it no file at all.
     * Hints
     * 1. {@code picture.isError()} is {@code true} when the file couldn't be read. Then the scene's root is just {@code new Label("No picture: pic.png is missing")}.
     * 2. Otherwise cast the size to whole numbers, {@code (int) picture.getWidth()}, so that the label says {@code 32 x 24 pixels} and not {@code 32.0 x 24.0 pixels}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
